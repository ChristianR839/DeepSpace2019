/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import frc.robot.OI;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Pistons;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Scheduler;

import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeInCommand;

import frc.robot.OI;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Pistons;


import edu.wpi.first.wpilibj.command.Command;

public class Drivetrain extends Command {
  public static double defaultRampRate = 0.2;

  //WPI_TalonSRX _rghtFront = new WPI_TalonSRX(4);
  //WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(3);
  //WPI_TalonSRX _leftFront = new WPI_TalonSRX(1);
  //WPI_TalonSRX _leftFollower = new WPI_TalonSRX(2);

  DifferentialDrive _diffDrive = new DifferentialDrive(_leftFront, _rghtFront);

  Joystick joystick0 = new Joystick(0);
  
  Faults _faults_L = new Faults();
  Faults _faults_R = new Faults();
  public Drivetrain() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
     /* factory default values */
     _rghtFront.configFactoryDefault();
     _rghtFollower.configFactoryDefault();
     _leftFront.configFactoryDefault();
     _leftFollower.configFactoryDefault();



     /* set up followers */
     _rghtFollower.follow(_rghtFront);
     _leftFollower.follow(_leftFront);

     /* [3] flip values so robot moves forward when stick-forward/LEDs-green */
     _rghtFront.setInverted(true); // !< Update this
     _leftFront.setInverted(true); // !< Update this

     /*
      * set the invert of the followers to match their respective master controllers
      */
     _rghtFollower.setInverted(InvertType.FollowMaster);
     _leftFollower.setInverted(InvertType.FollowMaster);

     /*
      * [4] adjust sensor phase so sensor moves positive when Talon LEDs are green
      */
     _rghtFront.setSensorPhase(true);
     _leftFront.setSensorPhase(true);

     /*
      * WPI drivetrain classes defaultly assume left and right are opposite. call
      * this so we can apply + to both sides when moving forward. DO NOT CHANGE
      */
     _diffDrive.setRightSideInverted(false);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    String work = "";

        /* get gamepad stick values */
        double leftforw = -1*joystick0.getRawAxis(5); /* positive is forward */
        double rightforw = joystick0.getRawAxis(1); /* positive is forward */
        //boolean btn1 = joystick0.getRawButton(1); /* is button is down, print joystick values */

        /* deadband gamepad 10% */
        if (Math.abs(leftforw) < 0.10) {
            leftforw = 0;
        }
        if (Math.abs(rightforw) < 0.10) {
            rightforw = 0;
        }

        /* drive robot */
        _diffDrive.tankDrive(leftforw, rightforw);

        /*
         * [2] Make sure Gamepad Forward is positive for FORWARD, and GZ is positive for
         * RIGHT
         */
        work += " GF:" + leftforw + " GT:" + rightforw;

        /* get sensor values */
        // double leftPos = _leftFront.GetSelectedSensorPosition(0);
        // double rghtPos = _rghtFront.GetSelectedSensorPosition(0);
        double leftVelUnitsPer100ms = _leftFront.getSelectedSensorVelocity(0);
        double rghtVelUnitsPer100ms = _rghtFront.getSelectedSensorVelocity(0);

        work += " L:" + leftVelUnitsPer100ms + " R:" + rghtVelUnitsPer100ms;

        /*
         * drive motor at least 25%, Talons will auto-detect if sensor is out of phase
         */
        _leftFront.getFaults(_faults_L);
        _rghtFront.getFaults(_faults_R);

        if (_faults_L.SensorOutOfPhase) {
            work += " L sensor is out of phase";
        }
        if (_faults_R.SensorOutOfPhase) {
            work += " R sensor is out of phase";
        }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}

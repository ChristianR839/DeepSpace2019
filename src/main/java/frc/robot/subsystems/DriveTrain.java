/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.DriveWithJoystick;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.SpeedController;

/*
 * Add your docs here.
 */
public class DriveTrain extends Subsystem 
{
  SpeedControllerGroup leftSide, rightSide;
  public static DifferentialDrive Drive;
  RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
  SpeedController leftDriveControl = RobotMap._leftFront;
  SpeedController rightDriveControl = RobotMap._rghtFront;

  public void initDefaultCommand() 
  {
    setDefaultCommand(new DriveWithJoystick());
        
    //RobotMap._rghtFront.set(ControlMode.PercentOutput, 0);
    //RobotMap._rghtFollower.set(ControlMode.PercentOutput, 0);
    //RobotMap._leftFront.set(ControlMode.PercentOutput, 0);
    //RobotMap._leftFollower.set(ControlMode.PercentOutput, 0);
  }

  public void setDriveSpeeds(double dleft, double dright)
  {
    robotDrive.tankDrive(dleft, dright);
  }
  
  public void stop()
  {
    RobotMap._rghtFront.set(0);
    RobotMap._rghtFollower.set(0);
    RobotMap._leftFront.set(0);
    RobotMap._leftFollower.set(0);
  }

  /*
  public void DriveTrain()
  {

    leftSide = new SpeedControllerGroup(RobotMap._leftFront, RobotMap._leftFollower);
    rightSide = new SpeedControllerGroup(RobotMap._rghtFront, RobotMap._rghtFollower);

    Drive = new DifferentialDrive(leftSide, rightSide);
  }
  */
}

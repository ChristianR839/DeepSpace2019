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

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem 
{
  
  WPI_TalonSRX _rghtFront, _rghtFollower, _leftFront, _leftFollower;
  SpeedControllerGroup leftSide, rightSide;
  public static DifferentialDrive drive;

  public void initDefaultCommand() 
  {
    setDefaultCommand(new DriveWithJoystick());
        
    RobotMap._rghtFront.set(ControlMode.PercentOutput, 0);
    RobotMap._rghtFollower.set(ControlMode.PercentOutput, 0);
    RobotMap._leftFront.set(ControlMode.PercentOutput, 0);
    RobotMap._leftFollower.set(ControlMode.PercentOutput, 0);
  }

  public void setDriveSpeeds(double dleft, double dright)
  {
    drive.tankDrive(dleft, dright);
  }

  public void stop()
  {
    RobotMap._rghtFront.set(0);
    RobotMap._rghtFollower.set(0);
    RobotMap._leftFront.set(0);
    RobotMap._leftFollower.set(0);
  }

  public void DriveTrain()
  {
    _rghtFront = new WPI_TalonSRX(4);
    _rghtFollower = new WPI_TalonSRX(3);
    _leftFront = new WPI_TalonSRX(1);
    _leftFollower = new WPI_TalonSRX(2);

    leftSide = new SpeedControllerGroup(_leftFront, _leftFollower);
    rightSide = new SpeedControllerGroup(_rghtFront, _rghtFollower);

    drive = new DifferentialDrive(leftSide, rightSide);
  }
}

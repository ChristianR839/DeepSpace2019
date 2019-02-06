/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.DriveWithJoystick;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem
{

  SpeedController _rghtFront = RobotMap._rghtFront;
  SpeedController _rghtFollower = RobotMap._rghtFollower;
  SpeedController _leftFront = RobotMap._leftFront;
  SpeedController _leftFollower = RobotMap._leftFollower;

  RobotDrive robotDrive = RobotMap.drivetrain;

  public void initDefaultCommand()
  {
    setDefaultCommand(new DriveWithJoystick());
  }

  public void setDriveSpeeds(double leftForw, double rightForw)
  {
        robotDrive.tankDrive(leftForw, rightForw);
  }

        
  RobotMap.frontLeftMotor.set(ControlMode.PercentOutput, 0);
  RobotMap.frontRightMotor.set(ControlMode.PercentOutput, 0);
  RobotMap.backLeftMotor.set(ControlMode.PercentOutput, 0);
  RobotMap.backRightMotor.set(ControlMode.PercentOutput, 0);
  public void setDriveSpeeds()
  {
    RobotMap.robotDrive.drive
  }
}

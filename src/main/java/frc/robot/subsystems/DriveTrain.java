/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveWithJoystick;

/*
 * Add your docs here.
 */
public class DriveTrain extends Subsystem
{
  //SpeedControllerGroup leftSide, rightSide;
  public DifferentialDrive robotDrive;
  //RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
  //SpeedController leftDriveControl = RobotMap.leftSide;
  //SpeedController rightDriveControl = RobotMap.rightSide;

  private static final int TalonSRX04ID = 4;  //Right Front
  private static final int TalonSRX03ID = 3;  //Right Follower (Back)
  private static final int TalonSRX01ID = 1;  //Left Front
  private static final int TalonSRX02ID = 2;  //Left Follower (Back)

  public void initDefaultCommand() 
  {
    setDefaultCommand(new DriveWithJoystick());
  }

public DriveTrain()
{
  final WPI_TalonSRX _rghtFront = new WPI_TalonSRX(TalonSRX04ID);
  final WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(TalonSRX03ID);
  final WPI_TalonSRX _leftFront = new WPI_TalonSRX(TalonSRX01ID);
  final WPI_TalonSRX _leftFollower = new WPI_TalonSRX(TalonSRX02ID);

  final SpeedControllerGroup rightSide = new SpeedControllerGroup(_rghtFront, _rghtFollower);
  final SpeedControllerGroup leftSide = new SpeedControllerGroup(_leftFront, _leftFollower);

  robotDrive = new DifferentialDrive(leftSide, rightSide);
}

public void setDriveSpeeds(double dleft, double dright)
{
  robotDrive.tankDrive(dleft, dright);
}

public void stop()
{
  robotDrive.stopMotor();
}



  /*
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
    //robotDrive.tankDrive(dleft, dright);
    RobotMap.leftSide.set(dleft);
    RobotMap.rightSide.set(dright);
  }
  
  public void stop()
  {
    RobotMap._rghtFront.set(0);
    RobotMap._rghtFollower.set(0);
    RobotMap._leftFront.set(0);
    RobotMap._leftFollower.set(0);
  }

  /*
  public void DriveTrainControl()
  {
    RobotMap.leftSide = new SpeedControllerGroup(RobotMap._leftFront, RobotMap._leftFollower);
    RobotMap.rightSide = new SpeedControllerGroup(RobotMap._rghtFront, RobotMap._rghtFollower);

    Drive = new DifferentialDrive(leftDriveControl, rightDriveControl);

  }
  */
}

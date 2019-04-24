/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.DriveWithJoystick;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class DriveTrain extends Subsystem
{
  public DifferentialDrive robotDrive;

  private static final int TalonSRX01ID = 1;
  private static final int TalonSRX02ID = 2;
  private static final int TalonSRX05ID = 5;
  private static final int TalonSRX06ID = 6;

  public void initDefaultCommand() 
  {
    setDefaultCommand(new DriveWithJoystick());
  }

  public DriveTrain()
  {
    final WPI_TalonSRX _leftFront = new WPI_TalonSRX(TalonSRX02ID);
    final WPI_TalonSRX _leftFollower = new WPI_TalonSRX(TalonSRX01ID);
    final WPI_TalonSRX _rghtFront = new WPI_TalonSRX(TalonSRX06ID);
    final WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(TalonSRX05ID);

    final SpeedControllerGroup rightSide = new SpeedControllerGroup(_rghtFront, _rghtFollower);
    final SpeedControllerGroup leftSide = new SpeedControllerGroup(_leftFront, _leftFollower);

    robotDrive = new DifferentialDrive(rightSide, leftSide);

    _leftFront.configOpenloopRamp(0.3);
    _rghtFront.configOpenloopRamp(0.3);
  }

  public void setDriveSpeeds(double xspeed, double zrotation)
  {
    robotDrive.arcadeDrive(xspeed, zrotation);
  }

  public void stop()
  {
    robotDrive.stopMotor();
  }
}
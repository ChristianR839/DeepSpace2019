/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Elevator extends Subsystem
{

  private static final int elevatorMotorID = 9;
  private static final int elevatorMotorFollowerID = 10;

  public static WPI_TalonSRX elevatorMotor;
  public static WPI_TalonSRX elevatorMotorFollower;

  public static double ticksPerInch = 349.5357142857143;

	public static double getTicks(double height)
	{
		return height * ticksPerInch;
	}

  @Override
  public void initDefaultCommand()
    {

    }

  public Elevator()
  {
    final WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(elevatorMotorID);
    final WPI_TalonSRX elevatorMotorFollower = new WPI_TalonSRX(elevatorMotorFollowerID);
    elevatorMotorFollower.set(ControlMode.Follower,elevatorMotor.getDeviceID());
    elevatorMotor.configOpenloopRamp(.5, 0);
  }

  public void raise()
    {
      elevatorMotor.set(1);
    }

  public void lower()
    {
      elevatorMotor.set(-1);
    }

  public void stop()
    {
      elevatorMotor.set(0);
    }
}
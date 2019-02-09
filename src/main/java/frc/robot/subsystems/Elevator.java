/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Elevator extends Subsystem
{

  public static double ticksPerInch = 349.5357142857143;

	public static double getTicks(double height)
	{
		return height * ticksPerInch;
	}

  @Override
  public void initDefaultCommand()
    {
      RobotMap.elevatorMotorFollower.set(ControlMode.Follower,RobotMap.elevatorMotor.getDeviceID());
      RobotMap.elevatorMotor.configOpenloopRamp(.5, 0);
    }

  public void raise()
    {
      RobotMap.elevatorMotor.set(1);
    }

  public void lower()
    {
      RobotMap.elevatorMotor.set(-1);
    }

  public void stop()
    {
      RobotMap.elevatorMotor.set(0);
    }
}
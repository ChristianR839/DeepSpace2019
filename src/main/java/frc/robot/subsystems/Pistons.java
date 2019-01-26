/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Pistons extends Subsystem
{

  @Override
  public void initDefaultCommand()
  {

  }

  public void push()
	{
		//RobotMap.'solenoid_name'.set(.6);
  }

  public void release()
	{
		//RobotMap.'solenoid_name'.set(.6);
  }
}

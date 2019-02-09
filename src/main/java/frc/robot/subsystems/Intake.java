/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Intake extends Subsystem
{
  @Override
  public void initDefaultCommand()
  {
    
  }

  public void intake()
	{
    RobotMap.intakeMotor.set(.6);
    //System.out.print("XXXXXXXXXXXXXXXXXXXXX");
  }
  
  public void outtake()
	{
		RobotMap.intakeMotor.set(-.6);
  }
  
  public void stop()
	{
		RobotMap.intakeMotor.set(0);
	}
}
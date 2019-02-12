/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Pistons extends Subsystem
{

  //private static final int solenoidNumber = 7;
  //private final Solenoid pistonsSolenoid;

  public Pistons()
  {
    //pistonsSolenoid = new Solenoid(solenoidNumber);
  }

  @Override
  public void initDefaultCommand()
  {
    
  }

  public void push()
	{
    //pistonsSolenoid.set(true);
  }

  public void release()
	{
		//pistonsSolenoid.set(false);
  }
}

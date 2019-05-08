/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class BackPistons extends Subsystem
{
  private Solenoid backPistonsSolenoid;
  Compressor compressor = new Compressor(11);

  public BackPistons()
  {
    compressor.setClosedLoopControl(true);
    backPistonsSolenoid = new Solenoid(7); //2-7 are available, but most likely 2 or 7
  }

  @Override
  public void initDefaultCommand()
  {
    
  }

  public void back_push()
	{
    backPistonsSolenoid.set(true);
    System.out.println("BACK_PUSH");
  }

  public void back_pull()
	{
   backPistonsSolenoid.set(false);
   System.out.println("BACK_PULL");
  }
}
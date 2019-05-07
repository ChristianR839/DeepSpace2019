/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class BackPistons extends Subsystem
{
  private DoubleSolenoid backPistonsSolenoid;
  Compressor compressor = new Compressor(11);

  public BackPistons()
  {
    compressor.setClosedLoopControl(true);
    backPistonsSolenoid = new DoubleSolenoid(11, 0, 1);
  }

  @Override
  public void initDefaultCommand()
  {
    
  }

  public void back_push()
	{
    backPistonsSolenoid.set(Value.kForward);
    System.out.println("BACK_PUSH");
  }

  public void back_pull()
	{
   backPistonsSolenoid.set(Value.kReverse);
   System.out.println("BACK_PULL");
  }
}
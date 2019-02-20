/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.PistonsCommand;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Pistons extends Subsystem
{
  private DoubleSolenoid pistonsSolenoid;
  Compressor compressor = new Compressor(11);

  public Pistons()
  {
    compressor.setClosedLoopControl(true);
    pistonsSolenoid = new DoubleSolenoid(11, 0, 1);
  }

  @Override
  public void initDefaultCommand()
  {
    
  }

  public void push()
	{
    pistonsSolenoid.set(Value.kForward);
  }

  public void release()
	{
	 pistonsSolenoid.set(Value.kReverse);
  }
}
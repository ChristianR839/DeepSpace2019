/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class PistonsPullCommand extends Command
{
  public PistonsPullCommand()
  {
    requires(Robot.pistons);
  }

  @Override
  protected void initialize()
  {
    Robot.pistons.pull();
  }

  @Override
  protected void execute()
  {
    
  }

  @Override
  protected boolean isFinished()
  {
    return false;
  }

  @Override
  protected void end()
  {
    
  }
}
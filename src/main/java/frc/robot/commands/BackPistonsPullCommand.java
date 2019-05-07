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

public class BackPistonsPullCommand extends Command
{
  public BackPistonsPullCommand()
  {
    requires(Robot.backPistons);
  }

  @Override
  protected void initialize()
  {
    Robot.backPistons.back_pull();
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
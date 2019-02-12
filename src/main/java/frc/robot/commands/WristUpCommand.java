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

public class WristUpCommand extends Command
{
  public WristUpCommand()
    {
    	requires(Robot.wrist);
    }

  @Override
  protected void initialize()
  {

  }

  @Override
  protected void execute()
  {
    Robot.wrist.up();
  }

  @Override
  protected boolean isFinished()
  {
    return false;
  }

  @Override
  protected void end()
  {
    Robot.wrist.stop();
  }

  @Override
  protected void interrupted()
  {
    end();
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class IntakeInCommand extends Command
{
  
  double power = 1;
  double maxCurrent = 0;
  
  /*public IntakeInCommand(double duration)
  {
  	this.setTimeout(duration);
    this.power = 1;
    requires(Robot.intake); //repetitive?
  }*/

  public IntakeInCommand()
  {
    requires(Robot.intake);
  }
  @Override
  protected void initialize()
  {

  }
  @Override
  protected void execute()
  {
    Robot.intake.intake();
    System.out.print("XXXXXXXXXXXXXXXXXXXXX");
  }
  @Override
  protected boolean isFinished()
  {
    return false;
  }
  @Override
  protected void end()
  {
    Robot.intake.stop();
  }
  @Override
  protected void interrupted()
  {
    end();
  }
}
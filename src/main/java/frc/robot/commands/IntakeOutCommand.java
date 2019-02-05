/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class IntakeOutCommand extends Command
{

  private static final double DEFAULT_SPEED = 0.5;
  private static double outtakeSpeed = DEFAULT_SPEED;
	private String side;

  public IntakeOutCommand(double duration)
    {
    	this.setTimeout(duration);
    	requires(Robot.intake);
    }
  
  public IntakeOutCommand()
  {
    requires(Robot.intake);
  }

  public IntakeOutCommand(double duration, String side)
  {
    this.side = side;
    this.setTimeout(duration);
    requires(Robot.intake);
    
  }

  @Override
  protected void initialize()
  {

  }

  @Override
  protected void execute()
  {
    Robot.intake.outtake();
  }

  @Override
  protected boolean isFinished()
  {
    return this.isTimedOut();
  }

  @Override
  protected void end()
  {
    Robot.intake.stop();
    this.side = null;
    outtakeSpeed = DEFAULT_SPEED;
  }

  @Override
  protected void interrupted()
  {
    end();
  }
}
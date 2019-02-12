/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Elevator;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class ElevatorUpCommand extends Command
{
	private double height = 0;

  public ElevatorUpCommand(double height)
  {
    this.height = Elevator.getTicks(height);
    	requires(Robot.elevator);
  }

  @Override
  protected void initialize()
  {
    
  }

  @Override
  protected void execute()
  {
    Robot.elevator.raise();
    System.out.println(Elevator.elevatorMotor.getSelectedSensorPosition(0));
  }

  @Override
  protected boolean isFinished() 
  {
    int encoderPosition = Elevator.elevatorMotor.getSelectedSensorPosition(0);
    return encoderPosition >= 28500 || this.isTimedOut() || (this.height > 0 && encoderPosition >= this.height);
  }

  @Override
  protected void end()
  {
    Robot.elevator.stop();
  }

  @Override
  protected void interrupted()
  {
    end();
  }
}
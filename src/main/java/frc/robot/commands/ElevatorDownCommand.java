/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.command.Command;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class ElevatorDownCommand extends Command
{

  double power = -1;

  public ElevatorDownCommand(double duration)
  {
    this.setTimeout(duration);
    this.power = -1;
    requires(Robot.elevator);
  }

  public ElevatorDownCommand()
  {
    requires(Robot.elevator);
  }

  @Override
  protected void initialize()
  {

  }

  @Override
  protected void execute()
  {
    Robot.elevator.lower();
  }

  @Override
  protected boolean isFinished()
  {
    return RobotMap.elevatorMotor.getSelectedSensorPosition(0) < 100 || this.isTimedOut();
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
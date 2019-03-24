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

public class ElevatorAnalogCommand extends Command
{
  public ElevatorAnalogCommand()
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
    Robot.elevator.moveElevatorAnalog(Robot.oi.getElevatorAnalogSpeed());
    //System.out.println("POSITION:" + Elevator.elevatorMotor.getSelectedSensorPosition(0));
    //System.out.println("VELOCITY:" + Elevator.elevatorMotor.getSelectedSensorVelocity(0));
    System.out.println(Elevator.elevatorMotor.get());
  }

  @Override
  protected boolean isFinished() 
  {
    return false;
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
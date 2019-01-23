/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.presets;

import frc.robot.commands.ElevatorUpCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

  /*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class HatchHighPreset extends CommandGroup
{
  public HatchHighPreset()
  {
    addSequential(new ElevatorUpCommand(26215.17857142857f));
  }
}
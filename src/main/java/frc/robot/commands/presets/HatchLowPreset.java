/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.presets;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.ElevatorUpCommand;

/*
* @Authors
* Christian
* Jackson
* FRC 839
*/

public class HatchLowPreset extends CommandGroup
{
  public HatchLowPreset()
  {
    addSequential(new ElevatorUpCommand(6641.178571428572f));
  }
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Shoulder extends Subsystem
{
  @Override
  public void initDefaultCommand()
  {
    
  }
  
  public void up()
  {
    RobotMap.shoulderMotor.set(1);
    RobotMap.shoulderMotorFollower.set(1);
  }
  
  public void down()
  {
    RobotMap.shoulderMotor.set(-1);
    RobotMap.shoulderMotorFollower.set(-1);
  }
  
  public void stop()
  {
    RobotMap.shoulderMotor.set(0);
    RobotMap.shoulderMotorFollower.set(0);
  }
}
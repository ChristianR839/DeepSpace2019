/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Shoulder extends Subsystem
{
  private static final int leftID = 7;
  private static final int followerID = 8;
  private SpeedControllerGroup shoulderMotorGroup;

  public Shoulder()
  {
  final WPI_TalonSRX shoulderMotor = new WPI_TalonSRX(leftID);
  final WPI_TalonSRX shoulderMotorFollower = new WPI_TalonSRX(followerID);

  shoulderMotorGroup = new SpeedControllerGroup(shoulderMotor, shoulderMotorFollower);
  }
  
  @Override
  public void initDefaultCommand()
  {
    
  }
  
  public void up()
  {
    shoulderMotorGroup.set(1);
   
  }
  
  public void down()
  {
    shoulderMotorGroup.set(-1);
  }
  
  public void stop()
  {
    shoulderMotorGroup.set(0);
  }
}
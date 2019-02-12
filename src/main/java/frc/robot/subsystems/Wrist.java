/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Wrist extends Subsystem
{

  private static final int wristMotorID = 6;
  private final WPI_TalonSRX wristMotor;

  @Override
  public void initDefaultCommand()
  {
    
  }

  public Wrist()
  {
    wristMotor = new WPI_TalonSRX(wristMotorID);
    wristMotor.configFactoryDefault();
  }

  public void up()
	{
    wristMotor.set(1);
  }
  
  public void down()
	{
		wristMotor.set(-1.0);
  }
  
  public void stop()
	{
		wristMotor.stopMotor();
	}
}
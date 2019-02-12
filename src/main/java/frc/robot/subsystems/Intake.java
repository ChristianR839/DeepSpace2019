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

public class Intake extends Subsystem
{

  private static final int intakeMotorID = 5;
  private final WPI_TalonSRX intakeMotor;

  @Override
  public void initDefaultCommand()
  {
    
  }

  public Intake()
  {
    intakeMotor = new WPI_TalonSRX(intakeMotorID);
    intakeMotor.configFactoryDefault();
  }

  public void intake()
	{
    intakeMotor.set(1);
  }
  
  public void outtake()
	{
		intakeMotor.set(-1.0);
  }
  
  public void stop()
	{
		intakeMotor.stopMotor();
	}
}
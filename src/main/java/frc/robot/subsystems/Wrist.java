/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.WristAnalogCommand;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Wrist extends Subsystem
{

  private static final int wristMotorID = 10;
  private final WPI_TalonSRX wristMotor;

  public final static int ticksPerRevolution = 4096;
  public final static double ___Circumference = 2 * Math.PI * 1.0; // FIX ME
  public final static int tolerance = getRawSensorValueFromInches(2); // Ticks
  public final static double minimumPosition = 0;
  public final static double maximumPosition = 36;

  private static final int getRawSensorValueFromInches(double degrees)
  {
    double revs = degrees / ___Circumference;
    int ticks = (int) (revs * ticksPerRevolution);
    return ticks;
  }

  private static final double getInchesFromRawSensorValue(int ticks)
  {
    double revs = ticks / ticksPerRevolution;
    double degrees = revs * ___Circumference;
    return degrees;
  }

  @Override
  public void initDefaultCommand()
  {
    setDefaultCommand(new WristAnalogCommand());
  }

  public Wrist()
  {
    wristMotor = new WPI_TalonSRX(wristMotorID);
    wristMotor.configFactoryDefault();

    wristMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute);

    // wristMotor.configForwardSoftLimitThreshold(getRawSensorValueFromInches(maximumPosition));
    // wristMotor.configForwardSoftLimitEnable(true);
    // wristMotor.configReverseSoftLimitThreshold(getRawSensorValueFromInches(minimumPosition));
    // wristMotor.configReverseSoftLimitEnable(true);
  }

  /**
   * Get the position of the wrist in degrees
   */
  public double getPosition()
  {
    int ticks = wristMotor.getSelectedSensorPosition();
    double degrees = getInchesFromRawSensorValue(ticks);
    return degrees;
  }

  /**
   * Tell the wrist how far to turn in degrees
   */
  public void setPosition(double degrees)
  {
    wristMotor.set(ControlMode.MotionMagic, getRawSensorValueFromInches(degrees));
  }

  /**
   * Checks to see if the wrist is at/near its target
   * If it is not on target return False
   */
  public boolean isOnTarget()
  {
    // What is our error?
    // error = goal - current
    double error = wristMotor.getClosedLoopTarget() - wristMotor.getSelectedSensorPosition();
    // Are we within an acceptable range?
    // abs(error) - tol. <= 0
    boolean onTarget = Math.abs(error) - tolerance <= 0;
    // Return if we are on target
    return onTarget;
  }

  public void moveWristAnalog(double wristAnalogSpeed)
	{
    wristMotor.set(wristAnalogSpeed);
  }

  public void up()
  {
    wristMotor.set(1);
  }

  public void down()
  {
    wristMotor.set(-1);
  }
  
  public void stop()
	{
		wristMotor.stopMotor();
	}
}
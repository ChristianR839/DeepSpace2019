/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.ShoulderAnalogCommand;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Shoulder extends Subsystem
{
  private static final int shoulderMotorID = 3;
  private static final int shoulderMotorFollowerID = 4;

  public final WPI_TalonSRX shoulderMotor;
  public final WPI_TalonSRX shoulderMotorFollower;

  public final static int degreesPerRevolution = 360;
  public final static double ___Circumference = 2 * Math.PI * 1.0; // FIX ME
  public final static int tolerance = getRawSensorValueFromInches(2); // Degrees
  public final static double minimumPosition = 0;
  public final static double maximumPosition = 36;

  private static final int getRawSensorValueFromInches(double degrees)
  {
    double revs = degrees / ___Circumference;
    int ticks = (int) (revs * degreesPerRevolution);
    return ticks;
  }

  private static final double getInchesFromRawSensorValue(int ticks)
  {
    double revs = ticks / degreesPerRevolution;
    double degrees = revs * ___Circumference;
    return degrees;
  }

  public Shoulder()
  {
    shoulderMotor = new WPI_TalonSRX(shoulderMotorID);
    shoulderMotorFollower = new WPI_TalonSRX(shoulderMotorFollowerID);

    shoulderMotorFollower.set(ControlMode.Follower,shoulderMotor.getDeviceID());

    shoulderMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute); // FeedbackDevice.___

    // shoulderMotor.configForwardSoftLimitThreshold(getRawSensorValueFromInches(maximumPosition));
    // shoulderMotor.configForwardSoftLimitEnable(true);
    // shoulderMotor.configReverseSoftLimitThreshold(getRawSensorValueFromInches(minimumPosition));
    // shoulderMotor.configReverseSoftLimitEnable(true);
  }
  
  @Override
  public void initDefaultCommand()
  {
    setDefaultCommand(new ShoulderAnalogCommand());
  }

  /**
   * Get the position of the shoulder in degrees
   */
  public double getHeight()
  {
    int ticks = shoulderMotor.getSelectedSensorPosition();
    double degrees = getInchesFromRawSensorValue(ticks);
    return degrees;
  }

  /**
   * Tell the shoulder how far to turn in degrees
   */
  public void setHeight(double inches)
  {
    shoulderMotor.set(ControlMode.MotionMagic, getRawSensorValueFromInches(inches));
  }

  /**
   * Checks to see if the shoulder is at/near its target
   * If it is not on target return False
   */
  public boolean isOnTarget()
  {
    // What is our error?
    // error = goal - current
    double error = shoulderMotor.getClosedLoopTarget() - shoulderMotor.getSelectedSensorPosition();
    // Are we within an acceptable range?
    // abs(error) - tol. <= 0
    boolean onTarget = Math.abs(error) - tolerance <= 0;
    // Return if we are on target
    return onTarget;
  }
  
  public void moveShoulderAnalog(double shoulderAnalogSpeed)
  {
    shoulderMotor.set(shoulderAnalogSpeed);
  }
  
  public void stop()
  {
    shoulderMotor.set(0);
  }
}
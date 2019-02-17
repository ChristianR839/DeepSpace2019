/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;


import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Elevator extends Subsystem
{

  private static final int elevatorMotorID = 9;
  private static final int elevatorMotorFollowerID = 10;

  public final WPI_TalonSRX elevatorMotor;
  public final WPI_TalonSRX elevatorMotorFollower;

  public final static int ticksPerRevolution = 4096;
  public final static double sprkCircumference = 2 * Math.PI * 1.0; // FIX ME
  public final static int tolerance = getRawSensorValueFromInches(0.5);
  public final static double minimumHeight = 0;
  public final static double maximumHeight = 36;

  private static final int getRawSensorValueFromInches(double inches)
  {
    double revs = inches / sprkCircumference;
    int ticks = (int) (revs * ticksPerRevolution);
    return ticks;
  }

  private static final double getInchesFromRawSensorValue(int ticks)
  {
    double revs = ticks / ticksPerRevolution;
    double inches = revs * sprkCircumference;
    return inches;
  }

  public Elevator()
  {
    elevatorMotor = new WPI_TalonSRX(elevatorMotorID);
    elevatorMotorFollower = new WPI_TalonSRX(elevatorMotorFollowerID);

    elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);

    elevatorMotor.configForwardSoftLimitThreshold(getRawSensorValueFromInches(maximumHeight));
    elevatorMotor.configForwardSoftLimitEnable(true);
    elevatorMotor.configReverseSoftLimitThreshold(getRawSensorValueFromInches(minimumHeight));
    elevatorMotor.configReverseSoftLimitEnable(true);

    elevatorMotorFollower.set(ControlMode.Follower,elevatorMotor.getDeviceID());
  }

  @Override
  public void initDefaultCommand()
  {
    
  }

  /**
   * Get the height of the elevator in inches.
   */
  public double getHeight()
  {
    int ticks = elevatorMotor.getSelectedSensorPosition();
    double inches = getInchesFromRawSensorValue(ticks);
    return inches;
  }

  /**
   * Tell the elevator how high to go in inches
   */
  public void setHeight(double inches)
  {
    elevatorMotor.set(ControlMode.MotionMagic, getRawSensorValueFromInches(inches));
  }

  /**
   * Checks to see if the elevator is at/near its target
   * If it is not on target return False
   */
  public boolean isOnTarget()
  {
    // What is our error?
    // error = goal - current
    double error = elevatorMotor.getClosedLoopTarget() - elevatorMotor.getSelectedSensorPosition();
    // Are we within an acceptable range?
    // abs(error) - tol. <= 0
    boolean onTarget = Math.abs(error) - tolerance <= 0;
    // Return if we are on target
    return onTarget;
  }

  public void raise()
    {
      elevatorMotor.set(1);
    }

  public void lower()
    {
      elevatorMotor.set(-1);
    }

  public void stop()
    {
      elevatorMotor.set(0);
    }

  public void updateSmartDashboard()
  {
    SmartDashboard.putNumber("ElevatorHeight", getHeight());
  }
}
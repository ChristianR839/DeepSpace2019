/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

 //NOTE: ADD SOMETHING FOR THE PNEUMATIC SYSTEM HERE//

public class RobotMap
{
    private static final int TalonSRX04ID = 4;  //Right Front
    private static final int TalonSRX03ID = 3;  //Right Follower (Back)
    private static final int TalonSRX01ID = 1;  //Left Front
    private static final int TalonSRX02ID = 2;  //Left Follower (Back)

    private static final int elevatorMotorID = 69;
    private static final int elevatorMotorFollowerID = 69;

    private static final int intakeMotorID = 69;

    private static final int shoulderMotorID = 69;
    private static final int shoulderMotorFollowerID = 69;

    private static final int wristMotorID = 69;


    public static final WPI_TalonSRX _rghtFront = new WPI_TalonSRX(TalonSRX04ID);
    public static final WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(TalonSRX03ID);
    public static final WPI_TalonSRX _leftFront = new WPI_TalonSRX(TalonSRX01ID);
    public static final WPI_TalonSRX _leftFollower = new WPI_TalonSRX(TalonSRX02ID);

    public static final WPI_TalonSRX elevatorMotor = new WPI_TalonSRX(elevatorMotorID);
    public static final WPI_TalonSRX elevatorMotorFollower = new WPI_TalonSRX(elevatorMotorFollowerID);

    public static final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(intakeMotorID);

    public static final WPI_TalonSRX shoulderMotor = new WPI_TalonSRX(shoulderMotorID);
    public static final WPI_TalonSRX shoulderMotorFollower = new WPI_TalonSRX(shoulderMotorFollowerID);

    public static final WPI_TalonSRX wristMotor = new WPI_TalonSRX(wristMotorID);

    public static Joystick joystickDrive;
    public static Joystick joystickNum;


    public static void init()
	{
		joystickDrive = new Joystick(0);
		joystickNum = new Joystick(1);
	}
}
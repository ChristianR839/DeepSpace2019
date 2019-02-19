/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class OI
{
    public UniversalJoystick joystickDrive = new UniversalJoystick(0);
    public UniversalJoystick joystickAccessory = new UniversalJoystick(1);
    //public UniversalJoystick joystickNum = new UniversalJoystick(1);6
    
    public Button elevatorDownButton;
    public Button elevatorUpButton;
    public Button intakeInButton;
    public Button intakeOutButton;
    public Button shoulderUpButton;
    public Button shoulderDownButton;
    // public Button wristDownButton;
    // public Button wristUpButton;
    public Button pistonsButton;
    // public Button ballcargopresetbutton;
    // public Button ballhighpresetbutton;
    // public Button ballloadpresetbutton;
    // public Button balllowpresetbutton;
    // public Button ballmidpresetbutton;
    // public Button hatchhighpresetbutton;
    // public Button hatchlowpresetbutton;
    // public Button hatchmidpresetbutton;

    public OI()
    {
        elevatorDownButton = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnLB);
        elevatorUpButton = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnRB);

        //elevatorDownButton.whenPressed(new ElevatorMoveCommand(0));
        //elevatorUpButton.whenPressed(new ElevatorMoveCommand(10));

        elevatorDownButton.whileHeld(new ElevatorUpCommand());
        elevatorUpButton.whileHeld(new ElevatorDownCommand());
        
        intakeInButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnLB);
        intakeOutButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnRB);

        intakeInButton.whileHeld(new IntakeInCommand());
        intakeOutButton.whileHeld(new IntakeOutCommand());
        
        shoulderUpButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnX);
        shoulderDownButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnY);

        shoulderUpButton.whileHeld(new ShoulderUpCommand());
    	shoulderDownButton.whileHeld(new ShoulderDownCommand());

        //wristDownButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnX);
        //wristUpButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnX);

        //pistonsButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnB);

        //ballcargopresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        //ballhighpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        //ballloadpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        //balllowpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        //ballmidpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);

        //hatchhighpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        //hatchlowpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        //hatchmidpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
    }
/*
    public UniversalJoystick getJoystickDrive()
    {
        return joystickDrive;
    }
    */
    public double getLeftSpeed()
    {
        return joystickDrive.leftAxisY();
    }

    public double getRightSpeed()
    {
        return joystickDrive.rightAxisY();
    }

    // public double getLeftTestSpeed()
    // {
    //     return joystickAccessory.leftAxisY();
    // }

    // public double getRightTestSpeed()
    // {
    //     return joystickAccessory.rightAxisY();
    // }

    double deadBand(double axisVal) {
		if (axisVal < -0.150)
			return axisVal;
		if (axisVal > +0.150)
			return axisVal;
		return 0;
    }
}
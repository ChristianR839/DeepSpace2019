/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ElevatorMoveCommand;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
import frc.robot.commands.PistonsCommand;

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
    
    public Button intakeInButton;
    public Button intakeOutButton;
    public Button pistonsButton;

    public Button ballLowPreset;
    public Button ballMidPreset;
    public Button ballHighPreset;
    public Button ballCargoPreset;
    public Button hatchLowPreset;
    public Button hatchMidPreset;
    public Button hatchHighPreset;

    public OI()
    {
        //elevatorDownButton = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnLB);
        //elevatorUpButton = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnRB);

        //elevatorDownButton.whenPressed(new ElevatorMoveCommand(0));
        //elevatorUpButton.whenPressed(new ElevatorMoveCommand(10));

        ballLowPreset = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnA);
        ballMidPreset = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnB);
        ballHighPreset = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnY);
        ballCargoPreset = new JoystickButton(joystickAccessory, UniversalJoystick.kBtnX);
        hatchLowPreset = new JoystickButton(GenericHID.getPOV(180)); //pov maybe?? ask mentor
        hatchMidPreset = new JoystickButton(getPOV(270)); //FIX
        hatchHighPreset = new JoystickButton(getPOV(0)); //FIX

        ballLowPreset.whenPressed(new ElevatorMoveCommand(27.5));
        ballMidPreset.whenPressed(new ElevatorMoveCommand(55.5));
        ballHighPreset.whenPressed(new ElevatorMoveCommand(83.5));
        ballCargoPreset.whenPressed(new ElevatorMoveCommand(31.5));
        hatchLowPreset.whenPressed(new ElevatorMoveCommand(19));
        hatchMidPreset.whenPressed(new ElevatorMoveCommand(47));
        hatchHighPreset.whenPressed(new ElevatorMoveCommand(75));

        intakeInButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnLB);
        intakeOutButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnRB);

        intakeInButton.whileHeld(new IntakeInCommand());
        intakeOutButton.whileHeld(new IntakeOutCommand());

        pistonsButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnB);

        pistonsButton.whileHeld(new PistonsCommand());
    }

    public double getLeftSpeed()
    {
        return joystickDrive.leftAxisY();
    }

    public double getRightSpeed()
    {
        return joystickDrive.rightAxisY();
    }

    public double getElevatorAnalogSpeed()
    {
        return joystickAccessory.leftAxisY(); // Change to joystick axis for functionality
    }

    public double getShoulderAnalogSpeed()
    {
        return joystickAccessory.rightAxisY();
    }

    public double getWristAnalogSpeed()
    {
        return joystickAccessory.triggers();
    }

    double deadBand(double axisVal) {
		if (axisVal < -0.150)
			return axisVal;
		if (axisVal > +0.150)
			return axisVal;
		return 0;
    }
}
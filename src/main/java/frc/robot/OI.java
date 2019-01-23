/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.ElevatorDownCommand;
import frc.robot.commands.ElevatorUpCommand;
import frc.robot.commands.IntakeInCommand;
import frc.robot.commands.IntakeOutCommand;
import frc.robot.commands.WristDownCommand;
import frc.robot.commands.WristUpCommand;
import frc.robot.commands.PistonsCommand;
import frc.robot.commands.ElevatorPresetsInput;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class OI
{
    public UniversalJoystick joystickDrive = new UniversalJoystick(0);
    public UniversalJoystick joystickNum = new UniversalJoystick(1);
    
    public Button elevatorDownButton;
	public Button elevatorUpButton;
	public Button intakeInButton;
    public Button intakeOutButton;
    public Button wristDownButton;
    public Button wristUpButton;
    public Button pistonsButton;
    public Button elevatorPresetsInputButton;

    public OI()
    {
        elevatorDownButton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        elevatorUpButton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        
        intakeInButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnLB);
        intakeOutButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnRB);

        wristDownButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnX);
        wristUpButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnX);

        pistonsButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnB);

        elevatorPresetsInputButton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
    }
}

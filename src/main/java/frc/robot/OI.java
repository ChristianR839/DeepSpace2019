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
import frc.robot.commands.presets.BallCargoPreset;
import frc.robot.commands.presets.BallHighPreset;
import frc.robot.commands.presets.BallLoadPreset;
import frc.robot.commands.presets.BallLowPreset;
import frc.robot.commands.presets.BallMidPreset;
import frc.robot.commands.presets.HatchHighPreset;
import frc.robot.commands.presets.HatchLowPreset;
import frc.robot.commands.presets.HatchMidPreset;

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
    public Button ballcargopresetbutton;
    public Button ballhighpresetbutton;
    public Button ballloadpresetbutton;
    public Button balllowpresetbutton;
    public Button ballmidpresetbutton;
    public Button hatchhighpresetbutton;
    public Button hatchlowpresetbutton;
    public Button hatchmidpresetbutton;

    public OI()
    {
        elevatorDownButton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        elevatorUpButton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        
        intakeInButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnLB);
        intakeOutButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnRB);

        wristDownButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnX);
        wristUpButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnX);

        pistonsButton = new JoystickButton(joystickDrive, UniversalJoystick.kBtnB);

        ballcargopresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        ballhighpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        ballloadpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        balllowpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        ballmidpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);

        hatchhighpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        hatchlowpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
        hatchmidpresetbutton = new JoystickButton(joystickNum, UniversalNumpad.kBtnX);
    }
}
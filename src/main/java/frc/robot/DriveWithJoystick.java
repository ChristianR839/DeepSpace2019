package frc.robot;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import frc.robot.OI;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Pistons;
import frc.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Scheduler;

import com.ctre.phoenix.motorcontrol.Faults;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Scheduler;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeInCommand;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import frc.robot.OI;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Pistons;


import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command
{
    public DriveWithJoystick() 
    {
        requires(Robot.drivetrain);
 //       requires(Robot.gyro);
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	//Robot.gyro.reset();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//if(Robot.oi.shiftButton.get())
        //    Robot.drivetrain.setDriveSpeeds(Robot.oi.getStrafeSpeed(), Robot.oi.getSpeed(), Robot.oi.getRotation(), Robot.gyro.getAngle());
    	//else
            Robot.drivetrain.setDriveSpeeds(Robot.oi.getLeftSpeed(), Robot.oi.getRightSpeed());

    }
        
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() 
    {
        Robot.drivetrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
        end();
    }
}

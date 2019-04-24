package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class DriveWithJoystick extends Command
{
    public DriveWithJoystick() 
    {
        requires(Robot.drivetrain);
    //  requires(Robot.gyro);
    }
    
    // Called just before this Command runs the first time
    protected void initialize()
    {
    	//Robot.gyro.reset();
    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        Robot.drivetrain.setDriveSpeeds(Robot.oi.getRightSpeed(), Robot.oi.getLeftSpeed());
        //System.out.println("Setting: " + Robot.oi.getRightSpeed() + ":" + Robot.oi.getLeftSpeed());
        //System.out.println(Robot.oi.joystickDrive.getRawAxis(1));
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
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pistons;
import frc.robot.subsystems.Wrist;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Robot extends TimedRobot
{
    public static Intake intake;
    public static Elevator elevator;
    public static Wrist wrist;
    public static Pistons pistons;
    public static DriveTrain drivetrain;
    public static OI oi;

    Command autonomousCommand;

    @Override
    public void robotInit()
    {

    }

    @Override
    public void robotPeriodic()
    {

    }

    @Override
    public void disabledInit() 
    {

    }

    @Override
    public void disabledPeriodic() 
    {

    }

    @Override
    public void autonomousInit() 
    {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    @Override
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }
    
    @Override
    public void teleopInit() 
    {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    @Override
    public void teleopPeriodic()
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() 
    {

    }
}


/*
According to all known laws
of aviation,
there is no way a bee
should be able to fly.
Its wings are too small to get
its fat little body off the ground.
The bee, of course, flies anyway
because bees don't care
what humans think is impossible.
Yellow, black. Yellow, black.
Yellow, black. Yellow, black.
Ooh, black and yellow!
Let's shake it up a little.
*/
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.OI;

import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Pistons;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Scheduler;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Robot extends IterativeRobot
{
    public static Intake intake = null;
    public static Elevator elevator = null;
    public static Wrist wrist = null;
    public static Pistons pistons = null;
    public static OI oi;

    public static double defaultRamprate = 0.2;


    public void teleopInit() 
    {
	
    }


    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
    }


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
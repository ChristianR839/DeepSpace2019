/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Pistons;
import frc.robot.subsystems.Shoulder;
import frc.robot.subsystems.Wrist;
import frc.robot.vision.Pixy2;
import frc.robot.vision.Pixy2.LinkType;
import frc.robot.vision.Pixy2CCC;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

import javax.lang.model.util.ElementScanner6;

public class Robot extends TimedRobot
{
    public static Intake intake;
    public static Elevator elevator;
    public static Wrist wrist;
    public static Pistons pistons;
    public static DriveTrain drivetrain;
    public static OI oi;
    public static Shoulder shoulder;
    public static Pixy2 pixy;

    private int counter = 0;

    Command autonomousCommand;

    @Override
    public void robotInit()
    {

        drivetrain = new DriveTrain();
        intake = new Intake();
        elevator = new Elevator();
        wrist = new Wrist();
        shoulder = new Shoulder();
        pistons = new Pistons();
        pixy = Pixy2.createInstance(LinkType.SPI);
        pixy.init(0);
        oi = new OI();
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
        Pixy2CCC ccc = pixy.getCCC();
        int result = ccc.getBlocks(false, 1, 5 );
        int pixelstomove = 0;
        if( result == 2 ) //only calculate when exactly 2 blocks (tape)
        {
            ArrayList<Pixy2CCC.Block> blocks = ccc.getBlocks();
            //If block is left of center, error will be negative number
            //if block is rigth of center, error will be positive number
            //Blocks x is 0-315, center is 158.
            int b1_error = blocks.get(0).getX() - 158; //Distance from center
            int b2_error = blocks.get(1).getX() - 158; //Distance from center
            int distanceApart = Math.abs(blocks.get(0).getX() - blocks.get(1).getX());
            if(( b1_error < 0) && (b2_error < 0))
            {
                //Both left of center, need to move right
                pixelstomove = (Math.max(b1_error, b2_error) * -1 ) + (distanceApart / 2);
            }
            else if((b1_error > 0 ) && (b2_error > 0))
            {
                //Both right of center, need to move left
                pixelstomove = (Math.min(b1_error, b2_error) * -1 ) - (distanceApart / 2);
            }
            else
            {
                //To make math easy, always use the block that is on the right side
                //of center. If > distance/2 away, result will be negative (move left)
                //if < distance/2 away, result will be positinve (move right)
                if( b1_error > 0 )
                {
                    pixelstomove = (distanceApart / 2) - b1_error;
                }
                else
                {
                    pixelstomove = (distanceApart / 2) - b2_error;
                }
            }

            System.out.println("PxToMove: " + pixelstomove);//////////////////////////motors
        }
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
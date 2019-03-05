
package frc.robot;

import java.util.ArrayList;

import frc.robot.vision.Pixy2;
import frc.robot.vision.Pixy2.LinkType;
import frc.robot.vision.Pixy2CCC;

public class VisionTracking 
{

    private static final double DEGREES_PER_PIXEL = 0.338028169;
    private static Pixy2 pixy;

    private int counter = 0;


    public VisionTracking() {

        pixy = Pixy2.createInstance(LinkType.SPI);
        pixy.init(0);

    }


    public double getAngleToTarget()
    {

        Pixy2CCC ccc = pixy.getCCC();
        int result = ccc.getBlocks(false, 1, 5 );
        int pixelstomove = 0;

        //only calculate when exactly 2 blocks (tape)
        
        if ( result != 2 )
            return 0;

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

       //System.out.println("PxToMove: " + pixelstomove);//////////////////////////motors
        System.out.println("Degrees_to_Move: " + pixelstomove * DEGREES_PER_PIXEL + );

        return pixelstomove * DEGREES_PER_PIXEL;  
    }
}
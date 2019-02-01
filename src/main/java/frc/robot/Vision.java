package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * @Authors
 * Christian
 * Jackson
 * FRC 839
 */

public class Vision extends Subsystem {


	// default values used (hi Christian)
	// the SPI port used eg; Port.kOnboardCS[0-3] or Port.kMXP (don't know what this means yet)
	public PixySPI pixy1;
	Port port = Port.kOnboardCS0;
	String print;
	public HashMap<Integer, ArrayList<PixyPacket>> packets = new HashMap<Integer, ArrayList<PixyPacket>>();

	public Vision(){
		// Open a pipeline to a Pixy camera.
		pixy1 = new PixySPI(new SPI(port), packets, new PixyException(print));
	}


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public void testPixy1(){
		int ret = -1;
		// Get the packets from the pixy.
		try {
			ret = pixy1.readPackets();
		} catch (PixyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//setup for smart dashboard use (yes... didnt just copy and paste eveything)
		SmartDashboard.putNumber("Pixy Vision: packets size: ", packets.size());

		for(int i = 1; i <= PixySPI.PIXY_SIG_COUNT ; i++) {
			SmartDashboard.putString("Pixy Vision: Signature: ", Integer.toString(i));

			SmartDashboard.putNumber("Pixy Vision: packet: " + Integer.toString(i) + ": size: ", packets.get(i).size());
			
			// Loop through the packets for this signature.
			for(int j=0; j < packets.get(i).size(); j++) {
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": X: ", packets.get(i).get(j).X);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Y: ", packets.get(i).get(j).Y);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Width: ", packets.get(i).get(j).Width);
				SmartDashboard.putNumber("Pixy Vision: " + Integer.toString(i) + ": Height: ", packets.get(i).get(j).Height);
			}
		}
	}
}


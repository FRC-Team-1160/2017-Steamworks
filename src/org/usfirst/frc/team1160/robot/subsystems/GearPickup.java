//accidentally wrote the gear pickup code in the shooter code

package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;
/**
 *
 */
public class GearPickup extends Subsystem {
	private static GearPickup instance;
	private Spark spark;
	private CANTalon talon;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static GearPickup getInstance()
	{
		if (instance == null)
		{
			instance = new GearPickup();
		}
		return instance;
	}
	private GearPickup()
	{
		spark = new Spark(0);
		talon = new CANTalon(0);
	}
	public void pickupGear()
	{
		spark.set(0.5);
		talon.set(0.5);
	}
	
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


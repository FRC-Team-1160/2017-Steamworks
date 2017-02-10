package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.commands.SparkDefault;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SparkSystem extends Subsystem {
	private static SparkSystem instance;
	private Spark thing;
	
	private SparkSystem()
	{
		thing = new Spark(0);
	}
	public static SparkSystem getInstance()
	{
		if (instance == null)
		{
			instance = new SparkSystem();
		}
		return instance;
	}
	public void setSpeed(double speed)
	{
		thing.set(speed);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new SparkDefault());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


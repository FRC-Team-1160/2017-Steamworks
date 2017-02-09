package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.commands.ServoDefault;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ServoSystem extends Subsystem {
	private static ServoSystem instance;
	private Servo thing;
	private ServoSystem()
	{
		Servo thing = new Servo(1);
	}
	public static ServoSystem getInstance()
	{
		if (instance == null)
		{
			instance = new ServoSystem();
		}
		return instance;
	}
	public void setSpeed()
	{
		thing.set(0.5);
	}
	public void angle()
	{
		thing.setAngle(90);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
       setDefaultCommand(new ServoDefault());
    }
}


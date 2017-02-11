package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ServoSystem extends Subsystem implements RobotMap{
	private static ServoSystem instance;
	private Servo thing;
	private ServoSystem()
	{
		thing = new Servo(SERVO);
	}
	public static ServoSystem getInstance()
	{
		if (instance == null)
		{
			instance = new ServoSystem();
		}
		return instance;
	}
	
	
	public void angle(int angle)
	{
		thing.setAngle(angle);
		System.out.println("Servo Angle: " + thing.getAngle());
		
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


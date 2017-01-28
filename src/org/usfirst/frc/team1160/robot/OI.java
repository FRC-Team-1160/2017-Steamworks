package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1160.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap
{
	public static OI instance;
	ModifiedJoystick stick;
	
	
	public static OI getInstance()
	{
		if (instance == null){
			instance =  new OI();
		}
		return instance;
	}
	private OI(){
		stick = new ModifiedJoystick(1);
	}
	public void buttons(){
		
	}
	public ModifiedJoystick getStick(){
		return stick;
	}
}

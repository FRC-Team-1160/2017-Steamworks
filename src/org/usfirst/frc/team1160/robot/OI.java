package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1160.robot.commands.ExampleCommand;
import org.usfirst.frc.team1160.robot.commands.auto.DriveForward;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap
{
	public static OI instance;
	ModifiedJoystick stick;
	JoystickButton drive;
	
	
	public static OI getInstance()
	{
		if (instance == null){
			instance =  new OI();
		}
		return instance;
	}
	
	private OI(){
		stick = new ModifiedJoystick(0);
		createButtons();
	}
	
	public void createButtons(){
		drive = new JoystickButton(stick,1);
		assignButtons();
	}
	
	public void assignButtons(){
		drive.whenPressed(new DriveForward(4));
	}
	public ModifiedJoystick getStick(){
		return stick;
	}
}

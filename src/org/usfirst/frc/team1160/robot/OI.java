package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1160.robot.commands.ServoAngle;
import org.usfirst.frc.team1160.robot.commands.ServoDefault;
import org.usfirst.frc.team1160.robot.commands.Intake.StartIntake;
import org.usfirst.frc.team1160.robot.commands.Intake.StopIntake;
import org.usfirst.frc.team1160.robot.commands.auto.DriveForward;
import org.usfirst.frc.team1160.robot.commands.climb.Climb;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap
{
	public static OI instance;
	ModifiedJoystick stick;
	JoystickButton climb, gearHold, gearRelease, startIntake, stopIntake;
	
	
	
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
		climb = new JoystickButton(stick,1);
		
		gearHold = new JoystickButton(stick,2);
		gearRelease = new JoystickButton(stick,3);
		
		startIntake = new JoystickButton(stick,4);
		stopIntake = new JoystickButton(stick,6);
		assignButtons();
	}
	
	public void assignButtons(){
		climb.whileHeld(new Climb());
		gearHold.whenPressed(new ServoDefault());
		gearRelease.whenPressed(new ServoAngle());
		
		startIntake.whenPressed(new StartIntake());
		stopIntake.whenPressed(new StopIntake());
	}
	public ModifiedJoystick getStick(){
		return stick;
	}
}

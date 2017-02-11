package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1160.robot.commands.ExampleCommand;
import org.usfirst.frc.team1160.robot.commands.ServoAngle;
import org.usfirst.frc.team1160.robot.commands.ServoDefault;
import org.usfirst.frc.team1160.robot.commands.Intake.StartIntake;
import org.usfirst.frc.team1160.robot.commands.Intake.StopIntake;
import org.usfirst.frc.team1160.robot.commands.auto.DriveForward;
import org.usfirst.frc.team1160.robot.subsystems.FuelIntake;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap
{
	public static OI instance;
	ModifiedJoystick stick;
	JoystickButton drive,gearHold,gearAngle, startIntake, stopIntake;
	
	
	
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
		
		gearHold = new JoystickButton(stick,2);
		gearAngle = new JoystickButton(stick,3);
		
		startIntake = new JoystickButton(stick,4);
		stopIntake = new JoystickButton(stick,6);
		assignButtons();
	}
	
	public void assignButtons(){
		drive.whenPressed(new DriveForward(4));
		gearHold.whenPressed(new ServoDefault());
		gearAngle.whenPressed(new ServoAngle());
		
		startIntake.whenPressed(new StartIntake());
		stopIntake.whenPressed(new StopIntake());
	}
	public ModifiedJoystick getStick(){
		return stick;
	}
}

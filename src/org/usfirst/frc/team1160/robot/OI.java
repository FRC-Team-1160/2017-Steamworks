package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1160.robot.commands.ServoAngle;
import org.usfirst.frc.team1160.robot.commands.ServoDefault;
import org.usfirst.frc.team1160.robot.commands.Intake.FuelToShooter;
import org.usfirst.frc.team1160.robot.commands.Intake.StartIntake;
import org.usfirst.frc.team1160.robot.commands.Intake.StopIntake;
import org.usfirst.frc.team1160.robot.commands.auto.DriveForward;
import org.usfirst.frc.team1160.robot.commands.climb.Climb;
import org.usfirst.frc.team1160.robot.commands.shoot.SetBlueSide;
import org.usfirst.frc.team1160.robot.commands.shoot.SetRedSide;
import org.usfirst.frc.team1160.robot.commands.shoot.ShootFromCenter;
import org.usfirst.frc.team1160.robot.commands.shoot.ShootFromSide;
import org.usfirst.frc.team1160.robot.commands.shoot.TurnShooterLeft;
import org.usfirst.frc.team1160.robot.commands.shoot.TurnShooterRight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap
{
	public static OI instance;
	ModifiedJoystick mainStick, shootStick;
	//Buttons for main joystick
	JoystickButton climb, gearHold, gearRelease, startIntake, stopIntake;
	//Buttons for shooting joystick
	JoystickButton turnShooterLeft, turnShooterRight, fuelToShooter, stopIntake2, shootFromSide, shootFromCenter, setBlueSide, setRedSide;
	
	
	
	public static OI getInstance()
	{
		if (instance == null){
			instance =  new OI();
		}
		return instance;
	}

	private OI(){
		mainStick = new ModifiedJoystick(0);
		shootStick = new ModifiedJoystick(1);
		
		createButtons();
	}
	
	public void createButtons(){
		//Create Buttons for main joystick
		climb = new JoystickButton(mainStick,1);
		gearHold = new JoystickButton(mainStick,2);
		gearRelease = new JoystickButton(mainStick,3);
		startIntake = new JoystickButton(mainStick,4);
		stopIntake = new JoystickButton(mainStick,6);
		
		//Create Buttons for shooting joystick
		shootFromCenter = new JoystickButton(shootStick,1);
		fuelToShooter = new JoystickButton(shootStick,2);
		shootFromSide = new JoystickButton(shootStick,3);
		turnShooterLeft = new JoystickButton(shootStick,4);	
		turnShooterRight = new JoystickButton(shootStick,5);
		setBlueSide = new JoystickButton(shootStick, 8);
		setRedSide = new JoystickButton(shootStick,9);
		stopIntake2 = new JoystickButton(shootStick, 6);

		assignButtons();
	}
	
	public void assignButtons(){
		//Assign commands to main joystick buttons
		climb.whileHeld(new Climb());
		gearHold.whenPressed(new ServoDefault());
		gearRelease.whenPressed(new ServoAngle());
		startIntake.whenPressed(new StartIntake());
		stopIntake.whenPressed(new StopIntake());
		
		//Assign commands to shooting joystick buttons
		shootFromCenter.whenPressed(new ShootFromCenter());
		shootFromSide.whenPressed(new ShootFromSide());
		turnShooterLeft.whileHeld(new TurnShooterLeft());
		turnShooterRight.whileHeld(new TurnShooterRight());
		fuelToShooter.whenPressed(new FuelToShooter());
		setBlueSide.whenPressed(new SetBlueSide());
		setRedSide.whenPressed(new SetRedSide());
		stopIntake2.whenPressed(new StopIntake());
	}
	public ModifiedJoystick getStick(){
		return mainStick;
	}
	
	public ModifiedJoystick getShootStick(){
		return shootStick;
	}
}

 package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team1160.robot.commands.ServoAngle;
import org.usfirst.frc.team1160.robot.commands.ServoDefault;
import org.usfirst.frc.team1160.robot.commands.Intake.FuelToShooter;
import org.usfirst.frc.team1160.robot.commands.Intake.ReverseIntake;
import org.usfirst.frc.team1160.robot.commands.Intake.StartIntake;
import org.usfirst.frc.team1160.robot.commands.Intake.StopIntake;
import org.usfirst.frc.team1160.robot.commands.agitator.AgitatorDefault;
import org.usfirst.frc.team1160.robot.commands.agitator.AgitatorRelease;
import org.usfirst.frc.team1160.robot.commands.auto.TurnAngle;
import org.usfirst.frc.team1160.robot.commands.climb.Climb;
import org.usfirst.frc.team1160.robot.commands.drive.SlowManualDrive;
import org.usfirst.frc.team1160.robot.commands.gearPickup.GearPickupOn;
import org.usfirst.frc.team1160.robot.commands.gearPickup.GearPickupReverse;
import org.usfirst.frc.team1160.robot.commands.gearPickup.GearPickupStop;
import org.usfirst.frc.team1160.robot.commands.gearPickup.SetArmPosition;
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
	JoystickButton climb, gearHold, gearRelease, gearIntakeStop,
				   startIntake, reverseIntake, stopIntake,
				   turnRight,driveForward, slowDrive;
	//Buttons for shooting joystick
	JoystickButton gearFullUp, gearIntakePosition, gearPlacePosition;
	
	
	
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
		slowDrive = new JoystickButton(mainStick,2);
		gearHold = new JoystickButton(mainStick,5);
		gearRelease = new JoystickButton(mainStick,7);
		gearIntakeStop = new JoystickButton(mainStick,8);
		reverseIntake = new JoystickButton(mainStick,3);
		startIntake = new JoystickButton(mainStick,4);
		stopIntake = new JoystickButton(mainStick,6);
		turnRight = new JoystickButton(mainStick,9);
		driveForward = new JoystickButton(mainStick,10);
		
		//Create Buttons for shooting joystick
		gearFullUp = new JoystickButton(shootStick,3);
		gearIntakePosition = new JoystickButton(shootStick, 2);
		gearPlacePosition = new JoystickButton(shootStick, 1);


		assignButtons();
	}
	
	public void assignButtons(){
		//Assign commands to main joystick buttons
		climb.whileHeld(new Climb());
		slowDrive.toggleWhenPressed(new SlowManualDrive());
		gearHold.whenPressed(new GearPickupOn());
		gearRelease.whenPressed(new GearPickupReverse());
		gearIntakeStop.whenPressed(new GearPickupStop());
		reverseIntake.whenPressed(new ReverseIntake());
		startIntake.whenPressed(new StartIntake());
		stopIntake.whenPressed(new StopIntake());
		turnRight.whenPressed(new TurnAngle(-35));
		
		//Assign commands to shooting joystick buttons
		gearFullUp.whenPressed(new SetArmPosition(0));
		gearIntakePosition.whenPressed(new SetArmPosition(-1.1));
		gearPlacePosition.whenPressed(new SetArmPosition(-0.5));

	}
	public ModifiedJoystick getStick(){
		return mainStick;
	}
	
	public ModifiedJoystick getShootStick(){
		return shootStick;
	}
}

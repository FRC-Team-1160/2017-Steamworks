
package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.shoot.JoyControl;

import com.ctre.CANTalon;

/**
 *
 */
public class Shooter extends Subsystem implements RobotMap {
	private static Shooter instance;
	private CANTalon shooter;
	private Boolean blueSide;
 
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public static Shooter getInstance() {
		if (instance == null) {
			instance = new Shooter();
		}
		return instance;
	}

	private Shooter() {
		shooter = new CANTalon(SHOOTER_FLYWHEEL);
		blueSide = true;
		shooter.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
	}
	
	public void joyControl(){
		shooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		double speed = -2*(Robot.oi.getShootStick().getZ()+1);
		//System.out.println("Shooter Speed Manually set to: " + speed);
		shooter.set(speed);
	}
	
	public void setSpeed(double speed){
		shooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooter.set(speed);
	}
	
	public void shootFromCenter(){
		shooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		if(blueSide){
			shooter.set(SHOOTER_SPEED_BLUE_CENTER);
		}
		else{
			shooter.set(SHOOTER_SPEED_RED_CENTER);
		}
	}
	
	public void shootFromSide(){
		shooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		if(blueSide){
			shooter.set(SHOOTER_SPEED_BLUE_SIDE);
		}
		else{
			shooter.set(SHOOTER_SPEED_RED_SIDE);
		}
	}

	public void setBlueSide(){
		blueSide = true;
		System.out.println("Shooter Speeds Calibrated for Blue Side");
		SmartDashboard.putString("Calibrated to Side:", "Blue");
	}
	
	public void setRedSide(){
		blueSide = false;
		System.out.println("Shooter Speeds Calibrated for Red Side");
		SmartDashboard.putString("Calibrated to Side:", "Red");
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new JoyControl());
	}
}


package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
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
	private Timer time;
 
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
		shooter.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		shooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooter.configEncoderCodesPerRev(SHOOTER_ENC_COUNT);
		
		shooter.setF(SHOOTER_KF);
		shooter.setP(SHOOTER_KP);
		shooter.setI(SHOOTER_KI);
		
		time = new Timer();
	}
	
	public void joyControl(){
		shooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		double speed = -0.5*(Robot.oi.getShootStick().getZ()+1);
		//System.out.println("Shooter Speed Manually set to: " + speed);
		shooter.set(speed);
	}
	
	public void setSpeed(double speed){
		shooter.changeControlMode(CANTalon.TalonControlMode.Speed);
		shooter.set(speed);
	}
	
	public double getSpeed(){
		return shooter.getSpeed();
	}
	public void shootFromCenter(){
		shooter.set(SHOOTER_SPEED_CENTER);
		}
	
	public void shootFromSide(){
		shooter.set(SHOOTER_SPEED_SIDE);
	}

	public void startTime(){
		time.reset();
		time.start();
	}
	
	
	public double getTime(){
		return time.get();
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new JoyControl());
	}
}

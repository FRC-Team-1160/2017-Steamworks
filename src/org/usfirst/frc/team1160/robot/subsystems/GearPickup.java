package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPickup extends Subsystem implements RobotMap{

	public static GearPickup instance;
	private CANTalon pickup;
	private Timer timer;
	
	public static GearPickup getInstance(){
		if(instance == null){
			instance = new GearPickup();
		}
		return instance;
	}
	
	private GearPickup(){
		pickup = new CANTalon(SHOOTER_TURNTABLE);
		timer = new Timer();
	}
	
	public void setSpeed(double speed){
		pickup.set(speed);
	}
	
	public void startTime(){
		timer.reset();
		timer.start();
	}
	
	public double getTime(){
		return timer.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPickup extends Subsystem implements RobotMap{

	public static GearPickup instance;
	private Jaguar jag;
	
	public static GearPickup getInstance(){
		if(instance == null){
			instance = new GearPickup();
		}
		return instance;
	}
	
	private GearPickup(){
		jag = new Jaguar(4);
	}
	
	public void setSpeed(double speed){
		jag.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

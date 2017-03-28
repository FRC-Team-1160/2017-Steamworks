package org.usfirst.frc.team1160.robot.commands.gearPickup;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GearPickupOn extends Command implements RobotMap{

	public GearPickupOn(){
		requires(Robot.gearPickup);
	}
	
	
	protected void execute(){
		Robot.gearPickup.setSpeed(GEAR_PICKUP_INTAKE);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

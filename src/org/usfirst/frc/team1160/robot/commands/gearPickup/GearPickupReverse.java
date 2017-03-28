package org.usfirst.frc.team1160.robot.commands.gearPickup;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GearPickupReverse extends Command implements RobotMap{

	public GearPickupReverse(){
		requires(Robot.gearPickup);
	}
	
	
	protected void execute(){
		Robot.gearPickup.setSpeed(GEAR_PICKUP_REVERSE);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

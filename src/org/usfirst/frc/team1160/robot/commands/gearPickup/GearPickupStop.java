package org.usfirst.frc.team1160.robot.commands.gearPickup;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GearPickupStop extends Command implements RobotMap{

	public GearPickupStop(){
		requires(Robot.gearPickup);
	}
	
	
	protected void execute(){
		Robot.gearPickup.setSpeed(0);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

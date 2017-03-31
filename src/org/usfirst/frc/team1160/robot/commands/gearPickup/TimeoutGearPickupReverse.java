package org.usfirst.frc.team1160.robot.commands.gearPickup;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TimeoutGearPickupReverse extends Command implements RobotMap{
	
	double timeout;
	public TimeoutGearPickupReverse(double timeout){
		requires(Robot.gearPickup);
		this.timeout = timeout;
	}
	
	protected void initialize(){
		Robot.gearPickup.startTime();
	}
	
	protected void execute(){
		Robot.gearPickup.setSpeed(GEAR_PICKUP_REVERSE);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.gearPickup.getTime() >= timeout;
	}

	
	
}

package org.usfirst.frc.team1160.robot.commands.gearPickup;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetArm extends Command{

	private double timeout, speed;
	
	public SetArm(double speed, double timeout){
		requires(Robot.gearArm);
		
		this.speed = speed;
		this.timeout = timeout;
	}
	
	protected void initialize(){
		Robot.gearArm.startTime();
	}
	
	protected void execute(){
		Robot.gearArm.set(speed);
	}
	
	protected void end(){
		//Robot.gearArm.set(0);
	}
	
	protected void interrupted(){
		//Robot.gearArm.set(0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.gearArm.getTime() >= timeout;
	}

}

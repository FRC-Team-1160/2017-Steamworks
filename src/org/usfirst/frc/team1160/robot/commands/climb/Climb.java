package org.usfirst.frc.team1160.robot.commands.climb;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command{

	public Climb(){
		requires(Robot.climber);
	}
	
	protected void initialize(){
		Robot.climber.climb();
	}
	
	protected void end(){
		Robot.climber.stop();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

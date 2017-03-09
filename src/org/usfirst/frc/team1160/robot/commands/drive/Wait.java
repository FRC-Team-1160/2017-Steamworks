package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{

	private double waitTime;
	
	public Wait(double time){
		requires(Robot.dt);
		
		waitTime = time;
	}
	
	protected void initialize(){
		Robot.dt.startTime();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.dt.timeDone(waitTime);

	}

}

package org.usfirst.frc.team1160.robot.commands.agitator;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AgitatorRelease extends Command implements RobotMap{

	public AgitatorRelease(){
		requires(Robot.agitator);
	}
	
	protected void initialize(){
		Robot.agitator.setAngle(AGITATOR_ANGLE_RELEASE);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}

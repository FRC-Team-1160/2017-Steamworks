package org.usfirst.frc.team1160.robot.commands.agitator;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AgitatorDefault extends Command implements RobotMap{

	public AgitatorDefault(){
		requires(Robot.agitator);
	}
	
	protected void initialize(){
		Robot.agitator.setAngle(AGITATOR_ANGLE_DEFAULT);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}

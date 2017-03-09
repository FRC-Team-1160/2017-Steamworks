package org.usfirst.frc.team1160.robot.commands.shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetRedSide extends Command{
	
	public SetRedSide(){
		requires(Robot.shooter);
	}
	
	protected void initialize(){
		Robot.turntable.setRedSide();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}

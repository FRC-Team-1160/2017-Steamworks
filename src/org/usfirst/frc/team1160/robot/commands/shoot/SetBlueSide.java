package org.usfirst.frc.team1160.robot.commands.shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetBlueSide extends Command{
	
	public SetBlueSide(){
		requires(Robot.shooter);
	}
	
	protected void initialize(){
		Robot.shooter.setBlueSide();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}

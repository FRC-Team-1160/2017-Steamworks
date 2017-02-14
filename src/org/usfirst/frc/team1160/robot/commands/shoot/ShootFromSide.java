package org.usfirst.frc.team1160.robot.commands.shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootFromSide extends Command{
	
	public ShootFromSide(){
		requires(Robot.shooter);
	}
	protected void initialize(){
		Robot.shooter.shootFromSide();
	}
	
	protected void end(){
		Robot.shooter.setSpeed(0);
	}
	
	protected void interrupted(){
		Robot.shooter.setSpeed(0);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}

package org.usfirst.frc.team1160.robot.commands.shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnShooterLeft extends Command{

	public TurnShooterLeft(){
		requires(Robot.turntable);
	}
	
	protected void initialize(){
		Robot.turntable.turnLeft();
	}
	
	protected void end(){
		Robot.turntable.stop();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

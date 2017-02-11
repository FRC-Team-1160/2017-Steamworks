package org.usfirst.frc.team1160.robot.commands.shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnShooterManual extends Command{

	public TurnShooterManual(){
		requires(Robot.turntable);
	}
	
	protected void execute(){
		Robot.turntable.joyControl();
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

package org.usfirst.frc.team1160.robot.commands.shoot;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoyControl extends Command{

	public JoyControl(){
		requires(Robot.shooter);
	}
	
	protected void execute(){
		Robot.shooter.joyControl();
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
		return false;
	}

}

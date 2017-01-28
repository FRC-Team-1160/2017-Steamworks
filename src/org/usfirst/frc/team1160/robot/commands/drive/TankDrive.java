package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command{

	
	protected void initialize(){
	}
	
	protected void execute(){
		Robot.dt.drive();
	}
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

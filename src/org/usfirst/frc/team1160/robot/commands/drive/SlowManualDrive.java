package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SlowManualDrive extends Command{
	
	public SlowManualDrive(){
		requires(Robot.dt);
	}
	
	protected void initialize() {
		Robot.dt.setSlowManual();
		System.out.println("DT set to slow speed");
	}

	protected void execute() {
		Robot.dt.slowManualDrive();
	}

	protected boolean isFinished() {
		return false;
	}



}

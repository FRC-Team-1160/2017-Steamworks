package org.usfirst.frc.team1160.robot.commands.Intake;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopIntake extends Command{

	public StopIntake(){
		requires(Robot.intake);
	}
	
	protected void initialize(){
		Robot.intake.stop();
	}
	
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}

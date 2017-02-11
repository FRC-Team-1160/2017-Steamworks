package org.usfirst.frc.team1160.robot.commands.Intake;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FuelToShooter extends Command{

	public FuelToShooter(){
		requires(Robot.intake);
	}
	
	protected void initialize(){
		Robot.intake.fuelToShooter();
	}
	
	protected void interrupted(){
		Robot.intake.stop();
	}
	
	protected void end(){
		Robot.intake.stop();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

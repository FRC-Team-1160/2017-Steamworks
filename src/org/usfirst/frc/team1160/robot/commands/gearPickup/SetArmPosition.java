package org.usfirst.frc.team1160.robot.commands.gearPickup;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SetArmPosition extends Command {

	double position;
	
	public SetArmPosition(double position){
		requires(Robot.gearArm);
		
		this.position = position;
	}
	
	protected void execute(){
		Robot.gearArm.setTalon(position);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

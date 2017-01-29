package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command{

	private double distance;
	
	public DriveForward(double distance){
		requires(Robot.dt);
		
		this.distance = distance;
	}
	
	protected void initialize(){
		Robot.dt.setAuto();
		Robot.dt.driveDistance(distance);
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end(){
		Robot.dt.setManual();
		//This will be in be in %VBus, so will set the speed to 0
		Robot.dt.driveDistance(0);
		Robot.dt.printPosition();
		System.out.println("Tried to drive " + distance + "units.");
	}

}

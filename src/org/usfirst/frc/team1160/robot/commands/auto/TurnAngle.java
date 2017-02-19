package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnAngle extends Command{

	private double angle;
	
	public TurnAngle(double angle){
		requires(Robot.dt);
		
		this.angle = angle;
	}
	
	protected void initialize(){
		Robot.dt.setAuto();
		Robot.dt.turnAngle(angle);
		Robot.dt.startTime();
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return Robot.dt.timeDone(1.3);
	}
	
	protected void interrupted(){
		Robot.dt.setManual();
		Robot.dt.set(0);
		Robot.dt.printPosition();
		System.out.println("Tried to turn " + angle + "degrees.");
	}
	
	protected void end(){
		Robot.dt.setManual();
		Robot.dt.set(0);
		Robot.dt.printPosition();
		System.out.println("Tried to turn " + angle + "degrees.");
	}

}

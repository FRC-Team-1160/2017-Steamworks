package org.usfirst.frc.team1160.robot.commands.gearPickup;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoyControl extends Command{

	public JoyControl(){
		requires(Robot.gearArm);
	}
	
	protected void initialize(){
		Robot.gearArm.setVoltageMode();
	}
	
	protected void execute(){
		Robot.gearArm.joyControl();
		System.out.println("Arm voltage: " + Robot.gearArm.getVoltage());
	}
	
	protected void end(){
		//Robot.gearArm.stop();
	}
	
	protected void interrupted(){
		//Robot.gearArm.stop();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

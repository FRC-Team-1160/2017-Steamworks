package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Agitator extends Subsystem implements RobotMap {

	public static Agitator instance;
	private Servo leftServo, rightServo;
	
	public static Agitator getInstance(){
		if(instance==null){
			instance = new Agitator();
		}
		return instance;
	}
	
	private Agitator(){
		leftServo = new Servo(AGITATOR_LEFT);
		rightServo = new Servo(AGITATOR_RIGHT);
	}
	
	public void setAngle(int angle){
		leftServo.setAngle(angle);
		rightServo.setAngle(180 - angle);
		
		System.out.println("Left Agitator: " + leftServo.getAngle());
		System.out.println("Right Agitator: " + rightServo.getAngle());

	}
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

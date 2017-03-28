package org.usfirst.frc.team1160.robot.subsystems;


import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearArm extends Subsystem implements RobotMap{

	public static GearArm instance;
	private CANTalon talon;
	
	public static GearArm getInstance(){
		if(instance==null){
			instance = new GearArm();
		}
		return instance;
	}
	
	private GearArm(){
		
		talon = new CANTalon(6);
		talon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		talon.configEncoderCodesPerRev(400);
		talon.reverseOutput(true);
		//rightServo = new Servo(3);
		//System.out.println(servo.get()); 
		talon.setPosition(0);
		
	}

	public double getVoltage(){
		return talon.getOutputVoltage();
	}
	
	public void setVoltageMode(){
		talon.changeControlMode(CANTalon.TalonControlMode.Voltage);
	}
	public void setTalon(double position){
		talon.changeControlMode(CANTalon.TalonControlMode.Position);
		talon.clearIAccum();
		talon.set(position);
	}
	
	public void joyControl(){
		talon.set(-Robot.oi.getShootStick().getZ()*GEAR_ARM_SCALE);
	}

	@Override
	protected void initDefaultCommand() {

	}

}

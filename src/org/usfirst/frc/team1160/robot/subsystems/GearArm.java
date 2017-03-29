package org.usfirst.frc.team1160.robot.subsystems;


import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.gearPickup.JoyControl;

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
		talon.enableBrakeMode(true);
		
	}

	public double getVoltage(){
		return talon.getOutputVoltage();
	}
	
	public void setVoltageMode(){
		talon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	public void setTalon(double position){
		talon.changeControlMode(CANTalon.TalonControlMode.Position);
		talon.clearIAccum();
		talon.set(position);
	}
	
	public void turnLeft(){
		talon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		talon.set(TURNTABLE_SCALE/2);
	}
	
	public void turnRight(){
		talon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		talon.set(-TURNTABLE_SCALE/2);	
	}
	
	public void stop(){
		talon.set(0);
	}
	
	public void joyControl(){
		System.out.println(-Robot.oi.getShootStick().getZ()*GEAR_ARM_SCALE);
		talon.set(-0.15 - Robot.oi.getShootStick().getY()*GEAR_ARM_SCALE);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoyControl());
	}

}

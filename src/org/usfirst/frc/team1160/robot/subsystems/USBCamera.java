package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

public class USBCamera extends Subsystem implements RobotMap{

	public static USBCamera instance;
	private static UsbCamera camera;
	
	public static USBCamera getInstance(){
		if(instance == null){
			instance = new USBCamera();
		}
		return instance;
	}
	
	private USBCamera(){
		camera = CameraServer.getInstance().startAutomaticCapture();
		CameraServer.getInstance().putVideo("Gear Cam", (int)IMG_WIDTH*4, (int)IMG_HEIGHT*4);

	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

package org.usfirst.frc.team1160.robot.subsystems;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.vision.GripPipeline;

import edu.wpi.cscore.AxisCamera;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class VisionProcessing extends Subsystem implements RobotMap{

	public static VisionProcessing instance;
	
	private VisionThread visionThread;
	private double centerX, xDistanceFromCenter;
	private final Object imgLock = new Object();
	
	private VisionProcessing(){
		centerX = 0.0;
		 AxisCamera camera = CameraServer.getInstance().addAxisCamera("10.11.60.11");
		 camera.setResolution((int)IMG_WIDTH, (int)IMG_HEIGHT);
		
		visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
		    //Stream Videos to Dashboard
			CameraServer.getInstance().putVideo("Shooting Camera", (int)IMG_WIDTH*2, (int)IMG_HEIGHT*2);
			
			//Run GRIP Pipeline
			
			if (!pipeline.filterContoursOutput().isEmpty()) {
		            Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
		            synchronized (imgLock) {
		                centerX = r.x + (r.width / 2);
		                xDistanceFromCenter = centerX - IMG_WIDTH/2;
		            }
		        }
		    
		    });
		    visionThread.start();
	}
	
	public static VisionProcessing getInstance(){
		if(instance == null){
			instance = new VisionProcessing();
		}
		return instance;
	}
	
	public double getCenterX(){
		System.out.println("Center X of Target(pixels): " + centerX);
		return centerX;
	}
	
	public double getXDistanceFromCenter(){
		System.out.println("Center of target is " +xDistanceFromCenter + " pixels away from the center" );
		return xDistanceFromCenter;
	}
	
	public double getAngleToTarget(){
		double centerX = getCenterX();
		double angle = (xDistanceFromCenter/IMG_WIDTH)*FOV_HORIZONTAL;
		System.out.println("Turret Aimed " + angle + " degrees from target center.");
		return angle;
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

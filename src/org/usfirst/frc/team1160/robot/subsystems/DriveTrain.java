package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.ManualDrive;

import com.ctre.CANTalon;

public class DriveTrain extends Subsystem implements RobotMap{

	public static DriveTrain instance;
	private CANTalon frontLeft, frontRight, backLeft, backRight;
	private Timer time;

	
	public static DriveTrain getInstance(){
		if (instance == null){
			instance = new DriveTrain();
		}
		return instance;
	}
	
	private DriveTrain(){
		time = new Timer();
		frontLeft  = new CANTalon(DT_FRONTLEFT);
		backLeft = new CANTalon(DT_BACKLEFT);
		frontRight = new CANTalon(DT_FRONTRIGHT);
		backRight = new CANTalon(DT_BACKRIGHT);
		
		frontLeft.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		frontRight.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		frontLeft.configEncoderCodesPerRev(256);
		frontRight.configEncoderCodesPerRev(256);

	}
	
	/*
	 * Talon Mode change functions
	 */
	public void setAuto(){
		resetPos();
		//backLeft.configMaxOutputVoltage(9);
		//backRight.configMaxOutputVoltage(9);
		//backLeft.setPID(dP, I, D);
		//backRight.setPID(dP, I, D);
		System.out.println("Talons set to autonomous mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Position);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
		backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		backLeft.setAllowableClosedLoopErr(100);
		backRight.setAllowableClosedLoopErr(100);
	}
	
	public void setManual(){
		frontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		frontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		frontRight.reverseSensor(false);
	}
	
	/*
	 * Basic Autonomous Functions
	 */
	
	public void resetPos(){
		System.out.println("Talon positions set to 0.");
		frontLeft.setEncPosition(0);;
		frontRight.setEncPosition(0);
	}
	
	public void driveDistance(double distance){
		// TODO After Closed Loop Control Works, tune this
		frontLeft.set(distance);
		frontRight.set(distance);
	}

	
	/*
	 * Timing Functions
	 */
	public void startTime(){
		time.reset();
		time.start();
	}
	
	public boolean timeDone (double var){
		return time.get() > var;
	}
	
	/*
	 * Basic Teleop Functions
	 */
	public void manualDrive(){
		frontLeft.set(DT_SCALE*(OI.getInstance().getStick().getZ() - OI.getInstance().getStick().getY()));
		backLeft.set(frontLeft.getDeviceID());
		frontRight.set(DT_SCALE*(OI.getInstance().getStick().getZ() + OI.getInstance().getStick().getY()));
		backRight.set(frontRight.getDeviceID());
		
		//System.out.println("Left Drive Traveled: " + frontLeft.getPosition()*DT_WHEEL_CIRC_FT + " feet.");
		//System.out.println("Right Drive Position: " + frontRight.getPosition()*DT_WHEEL_CIRC_FT + " feet.");

	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}
}

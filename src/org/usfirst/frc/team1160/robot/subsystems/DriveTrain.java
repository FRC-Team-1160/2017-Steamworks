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
		frontRight.configEncoderCodesPerRev(360);
		
		setManual();

	}
	
	/*
	 * Talon Mode change functions
	 */
	public void setAuto(){
		resetPos();

		frontLeft.setProfile(1);
		frontRight.setProfile(1);

		
		System.out.println("Talons set to autonomous mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Position);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
		frontRight.reverseSensor(true);
		
		
		frontLeft.setVoltageRampRate(4);
		frontRight.setVoltageRampRate(3.7);
		frontLeft.configMaxOutputVoltage(4.5);
		frontRight.configMaxOutputVoltage(4);
		
		frontLeft.configEncoderCodesPerRev(256);
		frontRight.configEncoderCodesPerRev(360);
		
		frontLeft.setAllowableClosedLoopErr(20);
		frontRight.setAllowableClosedLoopErr(20);

		
		
	}
	
	public void setManual(){
		frontLeft.setProfile(0);
		frontRight.setProfile(0);
		
		frontLeft.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		frontRight.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
		frontRight.reverseSensor(false);
		frontLeft.setVoltageRampRate(13);
		frontRight.setVoltageRampRate(13);
		frontLeft.configMaxOutputVoltage(13);
		frontRight.configMaxOutputVoltage(13);
		
		frontLeft.configEncoderCodesPerRev(256);
		frontRight.configEncoderCodesPerRev(360);
		
		System.out.println("DT set to Manual" );
	}
	
	public void setSlowPositionMode(){
		resetPos();

		System.out.println("Talons set to slow position mode.");
		frontLeft.changeControlMode(CANTalon.TalonControlMode.Position);
		frontRight.changeControlMode(CANTalon.TalonControlMode.Position);
		frontRight.reverseSensor(false);
		
		frontLeft.setVoltageRampRate(3);
		frontRight.setVoltageRampRate(3);
		frontLeft.configMaxOutputVoltage(4);
		frontRight.configMaxOutputVoltage(4);
		
		frontLeft.configEncoderCodesPerRev(256);
		frontRight.configEncoderCodesPerRev(360);
	}
	/*
	 * Basic Autonomous Functions
	 */
	
	public void resetPos(){
		System.out.println("Talon positions set to 0.");
		frontLeft.setEncPosition(0);;
		frontRight.setEncPosition(0);
	}
	
	public void set(double speed){
		frontLeft.set(speed);
		frontRight.set(speed);
	}
	
	public void driveDistance(double distance){
		// TODO After Closed Loop Control Works, tune this
		frontLeft.set(distance);
		frontRight.set(-(distance*0.97));
	}
	
	public void turnAngle(double angle){
		resetPos();
		
		double arcLength = (angle/360)*DT_TURN_CIRC_FT;
		double targetPosition = arcLength/DT_WHEEL_CIRC_FT;
		
		frontLeft.set(-targetPosition);
		frontRight.set(-targetPosition);
	}
	
	public boolean isDone(double setPoint){
		if(Math.abs(Math.abs(frontLeft.get())-setPoint)<(setPoint*0.1) && Math.abs(Math.abs(frontRight.get())-setPoint)<(setPoint*0.1)){
			return true;
		}
		return false;
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
		frontLeft.set(0.5*DT_SCALE*(OI.getInstance().getStick().getZ() - OI.getInstance().getStick().getY()));
		backLeft.set(frontLeft.getDeviceID());
		frontRight.set(0.5*DT_SCALE*(OI.getInstance().getStick().getZ() + OI.getInstance().getStick().getY()));
		backRight.set(frontRight.getDeviceID());
		
		//System.out.println("Left Drive Position: " + frontLeft.getPosition()*DT_WHEEL_CIRC_FT + " feet.");
		//System.out.println("Right Drive Position: " + frontRight.getPosition()*DT_WHEEL_CIRC_FT + " feet.");

		//System.out.println("Left Drive Speed: " + frontLeft.getSpeed());
		//System.out.println("Right Drive Speed: " + frontRight.getSpeed());
	}
	
	public void printPosition(){
		System.out.println("Left Position: " + frontLeft.getPosition());
		System.out.println("Right Position: " + frontRight.getPosition());

	}
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualDrive());
	}
}

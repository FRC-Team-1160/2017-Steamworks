package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.CANTalon;

public class DriveTrain extends Subsystem {

	public static DriveTrain instance;
	private CANTalon frontLeft, frontRight, backLeft, backRight;
	
	public static DriveTrain getInstance(){
		if(instance == null){
			instance = new DriveTrain();
		}
		return instance;
	}
	private DriveTrain(){
		//TODO: Create motor ports in robotmap; import robotmap
		//frontLeft = new CANTalon(DT_FL);
		//frontRight = new CANTalon(DT_FR);
		//backLeft = new CANTalon(DT_BL);
		//backRight = new CANTalon(DT_BR);
		}
	
	public void setManual(){
		backLeft.changeControlMode(CANTalon.TalonControlMode.Follower);
		backRight.changeControlMode(CANTalon.TalonControlMode.Follower);
	}
	public void drive(){
		/*
		 * TODO: Create joysticks in OI
		 * 		 Set Talons to receive joystick output
		 * 		 Uncomment below code
		 */
		
		//frontLeft.set();
		//frontRight.set();
	}
	
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}

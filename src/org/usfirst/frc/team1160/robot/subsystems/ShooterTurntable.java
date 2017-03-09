//accidentally wrote the gear pickup code in the shooter code
//so like replace this whenever -kyle

package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.shoot.TurnShooterManual;

import com.ctre.CANTalon;
/**
 *
 */
public class ShooterTurntable extends Subsystem implements RobotMap{
	private static ShooterTurntable instance;
	private CANTalon turntable;
	private Boolean blueSide;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static ShooterTurntable getInstance()
	{
		if (instance == null)
		{
			instance = new ShooterTurntable();
		}
		return instance;
	}
	
	private ShooterTurntable()
	{
		turntable = new CANTalon(SHOOTER_TURNTABLE);
	}
	
	public void turnLeft(){
		turntable.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		turntable.set(TURNTABLE_SCALE/2);
	}
	
	public void turnRight(){
		turntable.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		turntable.set(-TURNTABLE_SCALE/2);	
	}
	
	public void stop(){
		turntable.set(0);
	}
	
	public void setAngle(double angle){
		turntable.set((angle/360.0)*TURNTABLE_ENC_COUNTS_PER_REV);
		
	}
	
	public void joyControl(){
		turntable.set(-Robot.oi.getShootStick().getX()*TURNTABLE_SCALE);
	}
	
	public void setPositionMode(){
		turntable.changeControlMode(CANTalon.TalonControlMode.Position);
		turntable.setP(TURNTABLE_KP);
		turntable.setD(TURNTABLE_KD);
		
	}
	public void setBlueSide(){
		blueSide = true;
		System.out.println("Shooter Speeds Calibrated for Blue Side");
		SmartDashboard.putString("Calibrated to Side:", "Blue");
	}
	
	public void setRedSide(){
		blueSide = false;
		System.out.println("Shooter Speeds Calibrated for Red Side");
		SmartDashboard.putString("Calibrated to Side:", "Red");
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new TurnShooterManual());
    }
}


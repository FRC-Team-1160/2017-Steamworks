//accidentally wrote the gear pickup code in the shooter code
//so like replace this whenever -kyle

package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

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
		turntable.set(TURNTABLE_SCALE/2);
	}
	
	public void turnRight(){
		turntable.set(-TURNTABLE_SCALE/2);	
	}
	
	public void stop(){
		turntable.set(0);
	}
	
	public void joyControl(){
		turntable.set(-Robot.oi.getShootStick().getX()*TURNTABLE_SCALE);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new TurnShooterManual());
    }
}


//accidentally wrote the gear pickup code in the shooter code

package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1160.robot.RobotMap;

import com.ctre.CANTalon;
/**
 *
 */
public class Climber extends Subsystem implements RobotMap{
	private static Climber instance;
	private CANTalon climber;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static Climber getInstance()
	{
		if (instance == null)
		{
			instance = new Climber();
		}
		return instance;
	}
	private Climber()
	{
		climber = new CANTalon(CLIMBER);
	}
	
	public void climb(){
		climber.set(0.5);
	}
	
	public void stop(){
		climber.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


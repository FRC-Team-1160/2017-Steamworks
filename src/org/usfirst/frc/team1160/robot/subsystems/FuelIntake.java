//accidentally wrote the gear pickup code in the shooter code

package org.usfirst.frc.team1160.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Intake.StopIntake;

import com.ctre.CANTalon;
/**
 *
 */
public class FuelIntake extends Subsystem implements RobotMap{
	private static FuelIntake instance;
	private Spark backRoller;
	private CANTalon frontRoller;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static FuelIntake getInstance()
	{
		if (instance == null)
		{
			instance = new FuelIntake();
		}
		return instance;
	}
	private FuelIntake()
	{
		backRoller = new Spark(INTAKE_BACK_ROLLER);
		frontRoller = new CANTalon(INTAKE_FRONT_ROLLER);
	}
	
	public void pickupFuel()
	{
		backRoller.set(INTAKE_SPEED_BACK);
		frontRoller.set(INTAKE_SPEED_FRONT);
	}
	
	public void releaseFuel()
	{
		backRoller.set(-INTAKE_SPEED_BACK);
		frontRoller.set(-INTAKE_SPEED_FRONT);
	}
	
	public void fuelToShooter(){
		backRoller.set(-INTAKE_SPEED_BACK);
		frontRoller.set(-INTAKE_SPEED_FRONT);
	}
	
	public void stop(){
		backRoller.set(0);
		frontRoller.set(0);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopIntake());
    }
}


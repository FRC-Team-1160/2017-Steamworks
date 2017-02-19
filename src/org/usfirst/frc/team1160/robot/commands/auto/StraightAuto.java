package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.ServoAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StraightAuto extends CommandGroup implements RobotMap{
	
	public StraightAuto(){
		addSequential(new DriveForward(3.7/DT_WHEEL_CIRC_FT));
		addSequential(new ServoAngle());
		addSequential(new TurnAngle(-35));
		addSequential(new TurnAngle(35));
		addSequential(new DriveForward(-2));
	}
}

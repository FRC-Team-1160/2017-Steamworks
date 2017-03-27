package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.commands.ServoAngle;
import org.usfirst.frc.team1160.robot.commands.ServoDefault;
import org.usfirst.frc.team1160.robot.motionProfiling.FollowInvertedProfile;
import org.usfirst.frc.team1160.robot.motionProfiling.FollowProfile;
import org.usfirst.frc.team1160.robot.motionProfiling.StraightGearPath;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StraightAuto extends CommandGroup{
	
	private StraightGearPath path;
	
	public StraightAuto(){
		path = new StraightGearPath();
		
		addSequential(new FollowProfile(path, 4));
		//addSequential(new ServoAngle());
		//addSequential(new FollowInvertedProfile(path, 1.5));
		//addSequential(new ServoDefault());

	}
}

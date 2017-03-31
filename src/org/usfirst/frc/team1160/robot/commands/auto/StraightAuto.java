package org.usfirst.frc.team1160.robot.commands.auto;

import org.usfirst.frc.team1160.robot.commands.ServoAngle;
import org.usfirst.frc.team1160.robot.commands.ServoDefault;
import org.usfirst.frc.team1160.robot.commands.drive.Wait;
import org.usfirst.frc.team1160.robot.commands.gearPickup.GearPickupReverse;
import org.usfirst.frc.team1160.robot.commands.gearPickup.GearPickupStop;
import org.usfirst.frc.team1160.robot.commands.gearPickup.SetArm;
import org.usfirst.frc.team1160.robot.commands.gearPickup.TimeoutGearPickupReverse;
import org.usfirst.frc.team1160.robot.motionProfiling.FollowInvertedProfile;
import org.usfirst.frc.team1160.robot.motionProfiling.FollowProfile;
import org.usfirst.frc.team1160.robot.motionProfiling.StraightGearPath;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StraightAuto extends CommandGroup{
	
	private StraightGearPath path;
	
	public StraightAuto(){
		path = new StraightGearPath();
		
		addSequential(new FollowProfile(path, 3.5));
		addSequential(new SetArm(0.2,0.15));
		addSequential(new TimeoutGearPickupReverse(1.3));
		addSequential(new GearPickupStop());
		addSequential(new FollowInvertedProfile(path, 2.0));

	}
}

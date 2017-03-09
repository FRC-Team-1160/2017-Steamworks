package org.usfirst.frc.team1160.robot.motionProfiling;

import org.usfirst.frc.team1160.robot.MotionProfile;

public class RightGearPath extends MotionProfile{
	
	public RightGearPath(){

		setLeftPosition(new double[]{
				
		});
		
		setLeftVelocity(new double[]{
				
		});
		
		setLeftAcceleration(new double[]{
				
		});
		
		setRightPosition(new double[]{
				
		});
		
		setRightVelocity(new double[]{
				
		});
		
		setRightAcceleration(new double[]{
				
		});


		setNumFinalPoints(getRightVelocity().length);
		setPointsPerSecond(10);

	}
}

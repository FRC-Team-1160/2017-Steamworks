package org.usfirst.frc.team1160.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap
{
	//drivetrain
	public static final int DT_BACKRIGHT = 14;
	public static final int DT_FRONTRIGHT = 15;
	public static final int DT_BACKLEFT = 1;
	public static final int DT_FRONTLEFT = 0;
	
	//everything else
	public static final int turntable = 4;
	public static final int shooter = 5;
	public static final int climber = 6;
	public static final int pickup = 7;
	public static final int conveyor_belt = 8;
}
package org.usfirst.frc.team1160.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap
{


	
	/*
	 * CAN Values
	 */
		public static final int DT_FRONTLEFT = 0;
		public static final int DT_FRONTRIGHT = 1;
		public static final int DT_BACKLEFT = 2;
		public static final int DT_BACKRIGHT = 3;
		public static final int INTAKE_FRONT_ROLLER = 4;
		public static final int SHOOTER_TURNTABLE = 5;
		public static final int SHOOTER_FLYWHEEL = 6;
		public static final int CLIMBER = 7;
		
	/*
	 * PWM Values
	 */
		public static final int INTAKE_BACK_ROLLER = 0;
		public static final int SERVO = 1;
		public static final int AGITATOR_LEFT = 2;
		public static final int AGITATOR_RIGHT = 3;
		
	
	/*
	 * Driving Constants
	 */	
		//Scales down DT speed
		public static final double DT_SCALE = 2;
		//Radius of Wheel
		public static final double DT_WHEEL_RAD_IN = 2; 
		public static final double DT_WHEEL_RAD_FT = DT_WHEEL_RAD_IN/12;
		//Diameter of Wheel
		public static final double DT_WHEEL_DIA_IN = 2*DT_WHEEL_RAD_IN; 
		public static final double DT_WHEEL_DIA_FT = 2*DT_WHEEL_RAD_FT;
		//Circumference of Wheel
		public static final double DT_WHEEL_CIRC_IN = DT_WHEEL_DIA_IN*Math.PI;
		public static final double DT_WHEEL_CIRC_FT = DT_WHEEL_DIA_FT*Math.PI;
		//Turning Circle constants
		public static final double DT_TURN_DIA_FT = 2;
		public static final double DT_TURN_CIRC_FT = 2*Math.PI;
		//Encoder Ticks Per Revolution
			//****PRACTICE****
			public static final int DT_LEFT_ENC_COUNT_PRACTICE = 256;
			public static final int DT_RIGHT_ENC_COUNT_PRACTICE = 360;
			//****COMPETITION
			public static final int DT_LEFT_ENC_COUNT_COMP = 360;
			public static final int DT_RIGHT_ENC_COUNT_COMP = 360;
		
	/*
	 * Shooter Constants
	 */
		//Scales down Turntable speed
		public static final double TURNTABLE_SCALE = 0.1;
		//Turntalbe Constants
		public static final double TURNTABLE_ENC_COUNTS_PER_REV = 0;
		public static final double TURNTABLE_KP = 0;
		public static final double TURNTABLE_KD = 0;
		
		//Target Velocities
		public static final double SHOOTER_SPEED_CENTER = 0;
		public static final double SHOOTER_SPEED_SIDE = 0;

		//Closed Loop Constants
		public static final int SHOOTER_ENC_COUNT = 0;
		public static final double SHOOTER_KF = 0.0;
		public static final double SHOOTER_KP = 0.0;
		public static final double SHOOTER_KI = 0.0;
		
	/*
	 * Other Constants
	 */
		//Scales down Fuel Intake Speeds
		public static final double INTAKE_SPEED_FRONT = 1;
		public static final double INTAKE_SPEED_FRONT_PRACTICE = 1;
		public static final double INTAKE_SPEED_BACK = 0.4;

		
		
		//Scales down Climber speed
		public static final double CLIMBER_SPEED = 0.5;
		
		//Servo Angle Presets
			//****PRACTICE****
			public static final int SERVO_ANGLE_DEFAULT_PRACTICE = 95;
			public static final int SERVO_ANGLE_RELEASE_PRACTICE = 108;
			//****COMPETITION****
			public static final int SERVO_ANGLE_DEFAULT = 30;
			public static final int SERVO_ANGLE_RELEASE = 100;
		
		//Agitator Angle Presets
			public static final int AGITATOR_ANGLE_DEFAULT = 0;
			public static final int AGITATOR_ANGLE_RELEASE = 90;
	
	/*
	 * Vision Constants
	 */
			
		//Image Dimensions
		public static final double IMG_WIDTH = 320;
		public static final double IMG_HEIGHT = 480;
		//Field of View
		public static final double FOV_HORIZONTAL = 67;
}
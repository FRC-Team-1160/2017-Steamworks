package org.usfirst.frc.team1160.robot;

public abstract class MotionProfile {
	//smooth velocity
		private double[] rightVelocity;
		private double[] leftVelocity;
		
		//acceleration
		private double[] rightAcceleration;
		private double[] leftAcceleration;
		
		//distanceTraveled
		private double[] rightPosition;
		private double[] leftPosition;
		
		//accumulated heading
		private double[] heading;

		private double totalTime;
		private double numFinalPoints;
		public double pointsPerSecond;


		public double[] getRightVelocity() {
			return rightVelocity;
		}

		public void setRightVelocity(double[] rightVelocity) {
			this.rightVelocity = rightVelocity;
		}

		public double[] getLeftVelocity() {
			return leftVelocity;
		}

		public void setLeftVelocity(double[] leftVelocity) {
			this.leftVelocity = leftVelocity;
		}

		public double[] getRightAcceleration() {
			return rightAcceleration;
		}

		public void setRightAcceleration(double[] rightAcceleration) {
			this.rightAcceleration = rightAcceleration;
		}

		public double[] getLeftAcceleration() {
			return leftAcceleration;
		}

		public void setLeftAcceleration(double[] leftAcceleration) {
			this.leftAcceleration = leftAcceleration;
		}

		public double[] getRightPosition() {
			return rightPosition;
		}

		public void setRightPosition(double[] rightPosition) {
			this.rightPosition = rightPosition;
		}

		public double[] getLeftPosition() {
			return leftPosition;
		}

		public void setLeftPosition(double[] leftPosition) {
			this.leftPosition = leftPosition;
		}
		
		public double getNumFinalPoints(){
			return numFinalPoints;
		}
		
		public void setNumFinalPoints(double numFinalPoints){
			this.numFinalPoints = numFinalPoints;
		}
		
		public double getPointsPerSecond(){
			return pointsPerSecond;
		}
		
		public void setPointsPerSecond(double pointsPerSecond){
			this.pointsPerSecond = pointsPerSecond;
		}
	
	
}

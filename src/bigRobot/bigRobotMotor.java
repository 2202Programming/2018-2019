package bigRobot;

import physicalOutput.motors.IMotor;
import robot.IControl;
import robot.Global;

public class bigRobotMotor extends IControl {
	private IMotor motor;
	private BigRobotControl controller;

	public bigRobotMotor(IMotor motor) {
		this.motor = motor;
		controller = (BigRobotControl) Global.controllers;

	}
	public void teleopPeriodic() {
		if (controller.runMotor()) {
			motor.set(0.3);
		}
	}
}

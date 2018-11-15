package coolRobot;

import physicalOutput.motors.IMotor;
import robot.Global;
import robot.IControl;

public class MotorRunner extends IControl {
	private IMotor motor;
	private CoolRobotControl controller;

	public MotorRunner(IMotor motor) {
		this.motor = motor;
		controller = (CoolRobotControl) Global.controllers;
	}

	public void teleopPeriodic() {
		if (controller.runMotor()) {
			motor.set(0.3);
		}

	}
}

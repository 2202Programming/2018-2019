package leoBot;

import comms.XboxController;
import robotDefinitions.controls.ControlBase;

public class NewRobotControl extends ControlBase{
	public NewRobotControl() {
		super(true);
	}
	public boolean runMotor() {
		return controllers[0].getXPressed();
	}
	@Override
	public XboxController[] getControllers() {
		XboxController[] controllers = new XboxController[1];
		controllers[0] = XboxController.getXboxController(0);
		return controllers;
	}
	
	
}

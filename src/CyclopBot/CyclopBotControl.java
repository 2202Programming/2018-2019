package CyclopBot;

import comms.XboxController;
import robotDefinitions.controls.ControlBase;

public class CyclopBotControl extends ControlBase {

	public CyclopBotControl() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	public boolean runMotor () {
		return controllers[0].getXHeld();
	}
	
	@Override
	public XboxController[] getControllers() {
		// TODO Auto-generated method stub
		XboxController[] controllers = new XboxController[1];
		controllers[0] = XboxController.getXboxController(0);
		return controllers;
	}
	
	

}

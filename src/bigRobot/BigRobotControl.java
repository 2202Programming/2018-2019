package bigRobot;

import comms.XboxController;
import robotDefinitions.controls.ControlBase;

public class BigRobotControl extends ControlBase {
	public BigRobotControl() {
		super(true);
	}
	
	public boolean runMotor() {
		return controllers[0].getXHeld();
	}
	
	@Override
	public XboxController[] getControllers() {
		// TODO Auto-generated method stub
		return null;
	}

}

package coolRobot;

import comms.XboxController;
import robotDefinitions.controls.ControlBase;

public class CoolRobotControl extends ControlBase {

	public CoolRobotControl() {
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

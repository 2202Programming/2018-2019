package coolRobot;

import robotDefinitions.RobotDefinitionBase;

public class CoolRobot extends RobotDefinitionBase {

	@Override
	protected boolean useXML() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String loadDefinitionName() {
		// TODO Auto-generated method stub
		return "COOLBOT";
	}

	@Override
	protected void loadManualDefinitions() {
		_properties.put("MOTORPIN", "0");
		// TODO Auto-generated method stub

	}


}

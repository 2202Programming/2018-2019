package leoBot;

import java.util.Map;

import robot.IControl;
import robotDefinitions.RobotDefinitionBase;

public class NewRobot extends RobotDefinitionBase{

	@Override
	protected boolean useXML() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String loadDefinitionName() {
		// TODO Auto-generated method stub
		return "NewRobot";
	}

	@Override
	protected void loadManualDefinitions() {
		_properties.put("MOTORPIN", "0");
		
	}
	
	public Map<String, IControl> loadControlObjects(){
		Map<String, IControl> iControlMap = super.loadControlObjects();
		return iControlMap;
	}

}

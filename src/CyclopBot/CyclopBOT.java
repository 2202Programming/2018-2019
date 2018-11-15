package CyclopBot;

import java.util.Map;

import physicalOutput.motors.IMotor;
import physicalOutput.motors.SparkMotor;
import robot.IControl;
import robotDefinitions.RobotDefinitionBase;

public class CyclopBOT extends RobotDefinitionBase {

	@Override
	protected boolean useXML() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected String loadDefinitionName() {
		// TODO Auto-generated method stub
		return "CyclopBOT";
	}

	@Override
	protected void loadManualDefinitions() {
		// TODO Auto-generated method stub
		_properties.put("MOTORPIN","0");
	}

	public Map<String, IControl> loadControlObjects() {
		Map<String, IControl> iControlMap = super.loadControlObjects();
		
		IMotor motor = new SparkMotor(getInt("MOTORPIN"), false);
		MotorRunner runner = new MotorRunner(motor);
		iControlMap.put("MOTORUNNER", runner);
		
		return iControlMap;
	}
		
	}

package robot;

import comms.DebugMode;
import comms.SmartWriter;
import edu.wpi.first.wpilibj.IterativeRobot;
import miyamoto.Miyamoto;
import miyamoto.NotVlad;
import robotDefinitions.IRobotDefinition;
import robotDefinitions.RobotName;

/**
 * The main robot class that calls the IControl methods of each IControl object
 * associated with the robot comment here
 */
public class Robot extends IterativeRobot {

	private IRobotDefinition robotDefinition;
	public static RobotName name;

	public void robotInit() {
		SmartWriter.putS("Robot State", "Initsing", DebugMode.DEBUG);
		// String to say which robot we are using could later be made into a XML
		// property getter // TODO Can we get this from the robot so
		// it automatically knows what robot it
		// is?
		name = RobotName.MIYAMOTO;
		SmartWriter.putS("RobotName", name.toString(), DebugMode.COMPETITION);
		// Switch to decide which robot definition to use

		robotDefinition = new Miyamoto();

		// Load all the properties in the currently selected definition
		Global.controlObjects = robotDefinition.loadControlObjects();
		Global.controlObjects.putAll(robotDefinition.loadDefaultControlObjects());
		IControl.callRobotInit();
	}

	public void autonomousInit() {
		SmartWriter.putS("Robot State", "Autonomous Init", DebugMode.COMPETITION);

		try {
			IControl.callAutonomousInit();
		} catch (Exception e) {
			SmartWriter.outputError(e, "Auto Init");
		}
	}

	public void autonomousPeriodic() {
		SmartWriter.putS("Robot State", "Autonomous Periodic", DebugMode.COMPETITION);
		try {
			IControl.callAutonomousPeriodic();
		} catch (Exception e) {
			SmartWriter.outputError(e, "Auto Periodic");
		}
	};

	public void teleopInit() {
		SmartWriter.putS("Robot State", "Teleop Init", DebugMode.COMPETITION);
		try {
			IControl.callTeleopInit();
		} catch (Exception e) {
			SmartWriter.outputError(e, "Teleop Init");
		}
	}

	public void teleopPeriodic() {
		SmartWriter.putS("Robot State", "Teleop Periodic", DebugMode.COMPETITION);
		try {
			IControl.callTeleopPeriodic();
		} catch (Exception e) {
			SmartWriter.putB("error", true, DebugMode.DEBUG);
			SmartWriter.outputError(e, "Teleop Periodic");
		}
	}

	public void disabledInit() {

		SmartWriter.putS("Robot State", "Disabled Init", DebugMode.COMPETITION);
		try {
			IControl.callDisabledInit();
		} catch (Exception e) {
			SmartWriter.outputError(e, "Disabled Init");
		}
	}

	public void disabledPeriodic() {

		SmartWriter.putS("Robot State", "Disabled Periodic", DebugMode.COMPETITION);
		try {
			IControl.callDisabledPeriodic();
		} catch (Exception e) {
			SmartWriter.outputError(e, "Disabled Periodic");
		}
	}
}

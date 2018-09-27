package auto.commands;

import auto.IStopCondition;
import edu.wpi.first.wpilibj.command.Command;
import miyamoto.components.Intake;
import robot.Global;

public class OuttakeCommand extends Command {
	private IStopCondition stopCondition;
	private Intake intake;
	private double speed;

	/**
	 * Outtakes at a constant speed until a condition is fulfilled
	 * 
	 * @param stop
	 *            The condition that stops the command
	 */
	public OuttakeCommand(double speed, IStopCondition stop) {
		stopCondition = stop;
		this.speed = speed;
	}

	public void initialize() {
		stopCondition.init();
		intake = (Intake) Global.controlObjects.get("INTAKE");
	}

	public void execute() {
		if (intake == null) {
			initialize();
		}
		intake.runIntake(-speed);
	}

	public void end() {
		intake.stop();
	}
	
	protected boolean isFinished() {
		return stopCondition.stopNow();
	}
	
	public String toString() {
		return "OuttakeCommand";
	}
}

package auto.commands;

import auto.IStopCondition;
import edu.wpi.first.wpilibj.command.Command;
import miyamoto.components.Intake;
import robot.Global;

public class IntakeCommand extends Command {
	private IStopCondition stopCondition;
	private Intake intake;
	private double speed;
	private double holdSpeed;

	/**
	 * Intakes at a constant speed until a condition is fulfilled
	 * 
	 * @param stop
	 *            The condition that stops the command
	 */
	public IntakeCommand(double speed, double holdSpeed, IStopCondition stop) {
		stopCondition = stop;
		this.speed = speed;
		this.holdSpeed = holdSpeed;
	}

	public void initialize() {
		stopCondition.init();
		intake = (Intake) Global.controlObjects.get("INTAKE");
	}

	public void execute() {
		if (intake == null) {
			initialize();
		}
		intake.runIntake(speed);
	}

	public void end() {
		intake.runIntake(holdSpeed);
	}
	
	public String toString() {
		return "IntakeCommand";
	}

	@Override
	protected boolean isFinished() {
		return stopCondition.stopNow();
	}
}

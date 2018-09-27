package auto.commands;

import edu.wpi.first.wpilibj.command.Command;
import auto.IStopCondition;

public class WaitCommand extends Command {
	IStopCondition stop;
	/**
	 * Creates a command that waits
	 * @param stop The stop condition, usually a TimerStopCondition
	 */
	public WaitCommand(IStopCondition stop) {
		this.stop = stop;
	}

	
	@Override
	public void initialize() {
		stop.init();
	}

	@Override
	public void execute() {
		return;
	}


	@Override
	protected boolean isFinished() {
		return stop.stopNow();
	}

}

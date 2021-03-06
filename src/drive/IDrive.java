package drive;

import comms.DebugMode;
import comms.SmartWriter;
import robot.IControl;

/**
 * This class is for any types of drive we choose to implement in the future
 * 
 * @author SecondThread
 *
 */
public abstract class IDrive extends IControl {

	/**
	 * State that stores whether the motors are controlled by the drive, externally,
	 * or are disabled.
	 */
	protected DriveControl driveControl = DriveControl.DRIVE_CONTROLLED;

	/**
	 * Sets the drive control so that it is controlled by this IDrive in case
	 * someone changed it in auto and never set it back
	 */
	public void teleopInit() {
		setDriveControl(DriveControl.DRIVE_CONTROLLED);
	}

	public final void autonomousPeriodic() {
		SmartWriter.putS("Drive State", "" + driveControl, DebugMode.DEBUG);
		switch (driveControl) {
		case DISABLED:
			disableMotors();
			break;
		case DRIVE_CONTROLLED:
			setMotors();
			break;
		case EXTERNAL_CONTROL:
			onMotorsExternalControl();
			break;
		default:
			throw new Error("Illegal driveControl state in IDrive.teleopPeriodic!");
		}
	}

	/**
	 * This cannot be overridden by subclasses. Instead use teleopUpdate(). This
	 * calls the setMotors, disableMotors, or onMotorsExternalControl method
	 * depending on the driveControl state. <br>
	 * <br>
	 * Preconditions: This is called by all subclasses that extend IDrive<br>
	 * Postconditions: Depending on the state of this IDrive, either setMotors,
	 * disableMotors, or onMotorsExternalControl will be called
	 */
	public final void teleopPeriodic() {
		teleopUpdate();
		switch (driveControl) {
		case DISABLED:
			disableMotors();
			break;
		case DRIVE_CONTROLLED:
			setMotors();
			break;
		case EXTERNAL_CONTROL:
			onMotorsExternalControl();
			break;
		default:
			throw new Error("Illegal driveControl state in IDrive.teleopPeriodic!");
		}
	}

	/**
	 * This is the subclass version of teleopPeriodic(). teleopPeriodic() is needed
	 * to call the necessary methods to update motors.
	 */
	protected abstract void teleopUpdate();

	/**
	 * Sets whether this IDrive should control the motors, let the motors be
	 * controlled externally, or disable the motors <br>
	 * <br>
	 * Preconditions: none <br>
	 * Postconditions: If this IDrive has been set to enabled, the values passed to
	 * setLeft/RightMotorsRaw will be the ones set in setLeftMotorDrive and
	 * setRightMotorDrive. If it is set to disabled, the values passed will be the
	 * ones from setLeft
	 * 
	 * @param enabled
	 *            Whether or not this <i>ArcadeDrive</i> object should be enabled.
	 */
	public void setDriveControl(DriveControl driveControl) {
		this.driveControl = driveControl;
	}

	/**
	 * Called when the subclass is suppose to set the motors to whatever the drive
	 * needs them to be at when it is in control
	 */
	protected abstract void setMotors();

	/**
	 * Sets all the motors to zero, or disables them. (Note that there is no
	 * enableMotors callback method. It may just be easier to set the motors to zero
	 * manually or to always enable them when setMotors is called)
	 */
	protected abstract void disableMotors();

	/**
	 * An optional method that can be overridden if drive types need to that is
	 * called when motors are being controlled externally<br>
	 * <br>
	 * 
	 * Preconditions: none<br>
	 * Postconditions: none
	 */
	protected void onMotorsExternalControl() {
	}

	/**
	 * Gets and returns this IDrive's current DriveControl.<br>
	 * <br>
	 * Preconditions: none<br>
	 * Postconditions: none
	 * 
	 * @return This IDrive's current DriveControl
	 */
	public DriveControl getDriveControl() {
		return driveControl;
	}

	/**
	 * Checks to see if this IDrive has motors. <br>
	 * <br>
	 * Preconditions: none<br>
	 * Postconditions: none
	 * 
	 * @return True if and only if this IDrive has encoders.
	 */
	public abstract boolean hasEncoders();

	/**
	 * This is used by Auto commands. That's about it. Nowhere else as far as I
	 * know. <br>
	 * <br>
	 * Precondition: This IDrive state is in EXTERNAL_CONTROL<br>
	 * Postcondition: The left motors will be set to the specified power.
	 * 
	 * @param power
	 *            The power of the left motors
	 */
	public abstract void setLeftMotors(double power);
	
	/**
	 * This is used by Auto commands. That's about it. Nowhere else as far as I
	 * know. <br>
	 * <br>
	 * Precondition: This IDrive state is in EXTERNAL_CONTROL<br>
	 * Postcondition: The right motors will be set to the specified power.
	 * 
	 * @param power
	 *            The power of the right motors
	 */
	public abstract void setRightMotors(double power);
	
	/**
	 * This is used by Auto commands to get the current motor speed. That's about
	 * it. Nowhere else as far as I know. <br>
	 * <br>
	 * Precondition: This IDrive state is in EXTERNAL_CONTROL<br>
	 */
	public abstract double getLeftMotorsSpeed();

	/**
	 * This is used by Auto commands to get the current motor speed. That's about
	 * it. Nowhere else as far as I know. <br>
	 * <br>
	 * Precondition: This IDrive state is in EXTERNAL_CONTROL<br>
	 */
	public abstract double getRightMotorsSpeed();

}

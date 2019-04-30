package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandReset extends Command5800 {

	public CommandReset() {
		super(null);
	}

	protected void execute() {
	}

	protected boolean isDone() {
		return true;
	}

	protected void onCompletion() {
		sensors.reset();
		driverLeft.disable();
		driverRight.disable();
		driverAngle.disable();

		
	}

}

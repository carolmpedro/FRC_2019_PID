package org.usfirst.frc.team5800.robot.base.commands.drive;
import org.usfirst.frc.team5800.robot.base.commands.CommandBase;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandDriverPosition extends Command5800 {

	double targetPosition;


	public CommandDriverPosition(double targetPosition) {
		super(driverLeft);
		this.targetPosition = targetPosition;
	}

	public void onStart() {
		CommandBase.sensors.reset();
		CommandBase.driverRight.actuatePID(this.targetPosition);
		CommandBase.driverLeft.actuatePID(this.targetPosition);
		CommandBase.driverLeft.enable();
		CommandBase.driverRight.enable();
	} 

	protected void execute() {
	}

	protected boolean isDone() {
		return true;
	}

	protected void onCompletion() {
		CommandBase.driverRight.disable();
		CommandBase.driverLeft.disable();
	}
}

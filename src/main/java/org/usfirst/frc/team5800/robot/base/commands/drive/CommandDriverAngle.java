package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.base.commands.CommandBase;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandDriverAngle extends Command5800 {

	double currentRad;
	double targetRad;
	double currentGyro;

	public CommandDriverAngle(double angleTarget) {
		super(driverAngle);

		this.currentGyro = CommandBase.sensors.getChassiAngle();
		this.targetRad = (( Math.PI * angleTarget ) / 180);
		this.currentRad = ((Math.PI * this.currentGyro)/180);
	}

	public void onStart() {
		CommandBase.sensors.reset();
		CommandBase.driverAngle.enable();
	}

	protected void execute() {}

	protected boolean isDone() {
		return true;
	}

	protected void onCompletion() {
		driverAngle.actuatePID(this.targetRad - this.currentRad);
		CommandBase.driverAngle.disable();
	}

}

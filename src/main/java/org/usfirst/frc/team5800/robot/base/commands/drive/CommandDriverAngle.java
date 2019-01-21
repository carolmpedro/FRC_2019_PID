package org.usfirst.frc.team5800.robot.base.commands.drive;

import org.usfirst.frc.team5800.robot.base.commands.CommandBase;
import org.usfirst.frc.team5800.robot.superclasses.Command5800;

public class CommandDriverAngle extends Command5800 {

	double dist;
	double angle;

	public CommandDriverAngle(double angleTarget) {
		super(driver);
		
		this.dist = (( Math.PI / 180 ) * angleTarget);
		this.angle = angleTarget;
	}

	public void onStart() {
		CommandBase.sensors.reset();
		CommandBase.driver.anglePID(this.angle);
		CommandBase.driver.on();
	}

	protected void execute() {}

	protected boolean isDone() {
		return CommandBase.driver.onTarget(); 
	}

	protected void onCompletion() {
		CommandBase.driver.off();
	}

}

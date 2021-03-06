package org.usfirst.frc.team5800.robot.base.commands.generic;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;
import org.usfirst.frc.team5800.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.VictorSP;

public class CommandMotorTime extends Command5800 {
	public VictorSP motor;
	public double speed;

	public CommandMotorTime(Subsystem5800 requiredSubsystem, VictorSP motor, double speed, double time) {
		super(requiredSubsystem);
		setTimeout(time);
		this.motor = motor;
		this.speed = speed;
	}

	@Override
	protected void execute() {
		this.motor.set(this.speed);
	}

	@Override
	protected boolean isDone() {
		return isTimedOut();
	}

	@Override
	protected void onCompletion() {
		this.motor.set(0);
	}
}

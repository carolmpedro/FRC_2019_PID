package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.command.Subsystem;

public class CommandInterruptSubsystem extends Command5800 {
	Subsystem subsystem;

	public CommandInterruptSubsystem(Subsystem sub) {
		super(null);
		subsystem = sub;
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isDone() {
		return true;
	}

	@Override
	protected void onCompletion() {
		subsystem.getCurrentCommand().cancel();
	}
}

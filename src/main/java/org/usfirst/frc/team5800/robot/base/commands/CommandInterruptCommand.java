package org.usfirst.frc.team5800.robot.base.commands;

import org.usfirst.frc.team5800.robot.superclasses.Command5800;

import edu.wpi.first.wpilibj.command.Command;

public class CommandInterruptCommand extends Command5800 {
	Command comToInterrupt;

	public CommandInterruptCommand(Command command) {
		super(null);
		comToInterrupt = command;
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
		comToInterrupt.cancel();
	}
}

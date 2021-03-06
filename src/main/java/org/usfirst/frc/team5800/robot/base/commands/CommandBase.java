package org.usfirst.frc.team5800.robot.base.commands;

import java.util.ArrayList;

import org.usfirst.frc.team5800.robot.OI;
import org.usfirst.frc.team5800.robot.base.commands.generic.CommandUpdateSensors;
import org.usfirst.frc.team5800.robot.base.subsystems.*;
import org.usfirst.frc.team5800.robot.superclasses.Subsystem5800;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class CommandBase extends Command {
	public static OI oi;

	public static ArrayList<Subsystem5800> subsystemList = new ArrayList<Subsystem5800>();

	// Do not remove. Is used to set up each subsystem.
	public static int id = 0;

	// Create an instance of each subsystem here.
	public static SubsystemSensors sensors = new SubsystemSensors();
	public static SubsystemJoystick joystick = new SubsystemJoystick();
	public static SubsystemDriverLeft driverLeft = new SubsystemDriverLeft();
	public static SubsystemDriverRight driverRight = new SubsystemDriverRight();
	public static SubsystemDriverAngle driverAngle = new SubsystemDriverAngle();
	public static SubsystemDriver driver = new SubsystemDriver();

	public static void init() {
		sensors.setDefCommand(new CommandUpdateSensors());

		// Don't move or change this. EVER.
		oi = new OI();

		// Calls the method in SubsystemSensors that starts all sensors. Do not remove.
		sensors.init();

		// Adds information from all subsystems to the dashboard
		for (int a = 0; a < subsystemList.size(); a++) {
			SmartDashboard.putData(subsystemList.get(a));
		}
		SmartDashboard.putNumber("Number of subsystems", id);
	}

	public CommandBase(String name) {
		super(name);
	}

	public CommandBase() {
		super();
	}
}

package org.usfirst.frc.team5800.robot.base.subsystems;

import static org.usfirst.frc.team5800.robot.RobotMap.*;

import org.usfirst.frc.team5800.robot.base.commands.CommandBase;
import org.usfirst.frc.team5800.robot.base.util.Converter;

import edu.wpi.first.wpilibj.command.PIDSubsystem;


public class SubsystemDriverLeft extends PIDSubsystem{

	private double encoderMeterLeft;
	private double enconderMeasurementLeft;
  

	public SubsystemDriverLeft() {
		super("driver", 0.5, 0.0, 0.0);

		this.enconderMeasurementLeft = CommandBase.sensors.getChassiPulses('L');

		disable();
		setOutputRange(-0.5, 0.5);
		setPercentTolerance(2);
	    setSetpoint(0);
	}

	public double returnPIDInput(){
		this.encoderMeterLeft = Converter.convertEncoder(this.enconderMeasurementLeft, 'D');
			return this.encoderMeterLeft;
	}

	protected void usePIDOutput (double output){
		CommandBase.driver.gearLeft.pidWrite(output - (0.035 * CommandBase.sensors.getChassiAngle()));
	}

	protected void initDefaultCommand(){
	}

	public void actuatePID (double input){
		setSetpoint(input);

	}
	}

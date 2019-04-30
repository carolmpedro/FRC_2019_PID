package org.usfirst.frc.team5800.robot.base.subsystems;

import static org.usfirst.frc.team5800.robot.RobotMap.*;

import org.usfirst.frc.team5800.robot.base.commands.CommandBase;
import org.usfirst.frc.team5800.robot.base.util.Converter;

import edu.wpi.first.wpilibj.command.PIDSubsystem;


public class SubsystemDriverRight extends PIDSubsystem{


  private double encoderMeterRight;
  private double enconderMeasurementRight;

	public SubsystemDriverRight() {
    super("driver", 0.5, 0.0, 0.0);
    this.enconderMeasurementRight = CommandBase.sensors.getChassiPulses('R');

		disable();
		setOutputRange(-0.5, 0.5);
		setPercentTolerance(2);
	  setSetpoint(0);
	}

	public double returnPIDInput(){
    this.encoderMeterRight = Converter.convertEncoder(this.enconderMeasurementRight, 'D');
		return this.encoderMeterRight;
	}

	protected void usePIDOutput (double output){
    CommandBase.driver.gearRight.pidWrite(output - (0.035 * CommandBase.sensors.getChassiAngle()));
	}

	protected void initDefaultCommand(){
	}

	public void actuatePID (double input){
		setSetpoint(input);
		
	}
	}

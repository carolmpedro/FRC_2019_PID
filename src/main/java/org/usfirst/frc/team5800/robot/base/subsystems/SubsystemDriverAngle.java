
package org.usfirst.frc.team5800.robot.base.subsystems;

import org.usfirst.frc.team5800.robot.base.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class SubsystemDriverAngle extends PIDSubsystem {

  public SubsystemDriverAngle() {
  
    super("SubsystemDriverAngle", 0.5, 0.0, 0.0);
    setAbsoluteTolerance(0.2);
    setOutputRange(-0.5, 0.5);
    setPercentTolerance(2);
    enable();
    setSetpoint(0);
  }

  public void initDefaultCommand() {
  }

  protected double returnPIDInput() {
    return CommandBase.sensors.getChassiAngle();
  }

  protected void usePIDOutput(double output) {
    CommandBase.driver.gearLeft.pidWrite(output);
    CommandBase.driver.gearRight.pidWrite(-output);
  }

  public void actuatePID (double input){
    setSetpoint(input);
  }
}

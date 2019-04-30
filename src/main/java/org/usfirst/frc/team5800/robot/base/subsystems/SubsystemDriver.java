
package org.usfirst.frc.team5800.robot.base.subsystems;

import static org.usfirst.frc.team5800.robot.RobotMap.*;
import org.usfirst.frc.team5800.robot.superclasses.Subsystem5800;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class SubsystemDriver extends Subsystem5800 {

  private VictorSP motorFrontLeft = new VictorSP(DRIVE_MOTOR_FL_ID);
	private VictorSP motorRearLeft = new VictorSP(DRIVE_MOTOR_RL_ID);
	private VictorSP motorFrontRight = new VictorSP(DRIVE_MOTOR_FR_ID);
	private VictorSP motorRearRight = new VictorSP(DRIVE_MOTOR_RR_ID);

	public SpeedControllerGroup gearLeft = new SpeedControllerGroup(motorFrontLeft, motorRearLeft);
	public SpeedControllerGroup gearRight = new SpeedControllerGroup(motorFrontRight, motorRearRight);
  private DifferentialDrive driveTrain = new DifferentialDrive(gearLeft, gearRight);

	public SubsystemDriver() {
		super();
	}

	@Override
	public void onInit() {
	}

	public void tankDrive(double leftSpeed, double rightSpeed) {
		driveTrain.tankDrive(leftSpeed, rightSpeed);
	}

	public void arcadeDrive(double speed, double heading) {
		driveTrain.arcadeDrive(speed, heading);
	}

	public void driveTrainLeft(double speed) {
		this.gearLeft.set(speed);
	}

	public void driveTrainRight(double speed) {
		this.gearRight.set(speed);
	}
  
  
  }


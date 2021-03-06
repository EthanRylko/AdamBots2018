package org.usfirst.frc.team245.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Sensors {

	// gyro
	private static ADXRS450_Gyro gyro;
	private static DigitalInput photoEye;
	// precondition: run Actuators.init()
	// initializes all sensors
	public static void init() {

		// initialize and calibrate gyro
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();

		// initialize encoders
		// TODO: Figure out what the zeros in these arguments are
		Actuators.getCarriageLiftMotor().configSelectedFeedbackSensor(Constants.QUAD_ENCODER, 0, 0);
		Actuators.getCarriageLiftMotor().setSelectedSensorPosition(0, 0, 0);
		Actuators.getCarriageLiftMotor().configForwardSoftLimitThreshold(Constants.CARRIAGE_LIFT_FORWARD_LIMIT, 0);
		Actuators.getCarriageLiftMotor().configReverseSoftLimitThreshold(Constants.CARRIAGE_LIFT_REVERSE_LIMIT, 0);
		Actuators.getCarriageLiftMotor().configForwardSoftLimitEnable(Constants.CARRIAGE_LIFT_REVERSE_LIMIT_ENABLED, 0);
		Actuators.getCarriageLiftMotor().configReverseSoftLimitEnable(Constants.CARRIAGE_LIFT_REVERSE_LIMIT_ENABLED, 0);
		Actuators.getCarriageLiftMotor().setSensorPhase(Constants.CARRIGE_LIFT_MOTOR_PHASE);
		
		//initialize photoEye
		photoEye = new DigitalInput(Constants.PHOTOEYE_PORT);
	}
	public static DigitalInput getPhotoEye() {
		return photoEye;
	}
	public static boolean getPhotoEyeValue() {
		return photoEye.get();
	}
	public static int getCarriageLiftPosition() {
		return Actuators.getCarriageLiftMotor().getSelectedSensorPosition(0);

	}

}

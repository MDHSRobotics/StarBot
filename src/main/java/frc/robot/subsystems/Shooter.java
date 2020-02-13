
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.Logger;
import frc.robot.devices.DevTalonSRX;
import frc.robot.subsystems.utils.EncoderUtils;

import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.constants.TalonConstants.*;
import static frc.robot.subsystems.Devices.talonSrxShooterBottomWheel;
import static frc.robot.subsystems.Devices.talonSrxShooterTopWheel;
import static frc.robot.RobotManager.isReal;

// Shooter subsystem, for shooting balls.
public class Shooter extends SubsystemBase {

    // Position constants
    private final double GEAR_RATIO = 1;

    // Encoder constants
    private static final boolean SENSOR_PHASE_TOP = true;
    private static final boolean MOTOR_INVERT_TOP = true;

    private static final boolean SENSOR_PHASE_BOTTOM = false;
    private static final boolean MOTOR_INVERT_BOTTOM = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        if (isReal) {
            // Configure devices
            configureTalon(talonSrxShooterBottomWheel, SENSOR_PHASE_BOTTOM, MOTOR_INVERT_BOTTOM);
            configureTalon(talonSrxShooterTopWheel, SENSOR_PHASE_TOP, MOTOR_INVERT_TOP);
        }
    }

    // Configure the talons for this subsystem
    private static void configureTalon(DevTalonSRX talon, boolean sensorPhase, boolean motorInvert) {
        if (!talon.isConnected) return;

        talon.configPeakCurrentDuration(PEAK_AMPERAGE_DURATION, TIMEOUT_MS);
        talon.configPeakCurrentLimit(PEAK_AMPERAGE, TIMEOUT_MS);
        talon.configContinuousCurrentLimit(CONTINUOUS_AMPERAGE_LIMIT, TIMEOUT_MS);
        talon.enableCurrentLimit(true);

        talon.configVoltageCompSaturation(12);
        talon.enableVoltageCompensation(true);

        talon.configNominalOutputForward(0);
        talon.configNominalOutputReverse(0);
        talon.configPeakOutputForward(0.5);
        talon.configPeakOutputReverse(-0.5);

        talon.configMotionAcceleration(3000, TIMEOUT_MS);
        talon.configMotionCruiseVelocity(8000, TIMEOUT_MS);

        // Config TalonSRX Redline encoder
        talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, PID_LOOP_PRIMARY, TIMEOUT_MS);
        talon.setSensorPhase(sensorPhase);
        talon.setInverted(motorInvert);
        talon.configAllowableClosedloopError(0, PID_SLOT_0, TIMEOUT_MS);

        talon.config_kF(PID_SLOT_0, 0.7, TIMEOUT_MS);
        talon.config_kP(PID_SLOT_0, 0.0, TIMEOUT_MS);
        talon.config_kI(PID_SLOT_0, 0.0, TIMEOUT_MS);
        talon.config_kD(PID_SLOT_0, 0.0, TIMEOUT_MS);

        // Initialize current encoder position as zero
        talon.setSelectedSensorPosition(0, PID_LOOP_PRIMARY, TIMEOUT_MS);
        SensorCollection sensorCol2 = talon.getSensorCollection();
        int absolutePosition2 = sensorCol2.getPulseWidthPosition();
        absolutePosition2 &= 0xFFF;
        if (sensorPhase) absolutePosition2 *= -1;
        if (motorInvert) absolutePosition2 *= -1;
        // Set the quadrature (relative) sensor to match absolute
        talon.setSelectedSensorPosition(absolutePosition2, PID_LOOP_PRIMARY, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the shooter
    public void stop() {
        talonSrxShooterBottomWheel.stopMotor();
        talonSrxShooterTopWheel.stopMotor();
    }

    // Spin the bottom shooter wheel
    public void spinBottomWheel() {
        double velocity = ShooterBrain.getBottomWheelVelocity();
        double nativeVelocity = EncoderUtils.translateDistanceToTicks(velocity, 4, GEAR_RATIO) * 10;
        Logger.info("Shooter -> BottomWheel Velocity to:" + velocity);
        Logger.info("Shooter -> BottomWheel Ticks to:" + nativeVelocity);

        Logger.action("Shooter -> Setting bottom wheel velocity...");
        talonSrxShooterBottomWheel.set(ControlMode.Velocity, nativeVelocity);
    }

    // Spin the top shooter wheel
    public void spinTopWheel() {
        double velocity = ShooterBrain.getTopWheelVelocity();
        double nativeVelocity = EncoderUtils.translateDistanceToTicks(velocity, 4, GEAR_RATIO) * 10;
        Logger.info("Shooter -> TopWheel Velocity to:" + velocity);
        Logger.info("Shooter -> TopWheel Ticks to:" + nativeVelocity);

        Logger.action("Shooter -> Setting top wheel velocity...");
        talonSrxShooterTopWheel.set(ControlMode.Velocity, nativeVelocity);
    }

    // Get the current shooter bottom wheel motor velocity
    public int getBottomWheelVelocity() {
        int velocity = talonSrxShooterBottomWheel.getSelectedSensorVelocity();
        return velocity;
    }

    // Get the current shooter top wheel motor velocity
    public int getTopWheelVelocity() {
        int velocity = talonSrxShooterTopWheel.getSelectedSensorVelocity();
        return velocity;
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        talonSrxShooterBottomWheel.set(-0.2);
        talonSrxShooterTopWheel.set(-0.2);
    }

}

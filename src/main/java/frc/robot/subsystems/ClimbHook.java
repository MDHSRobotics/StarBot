
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.devices.DevTalonSRX;
import frc.robot.subsystems.utils.EncoderUtils;

import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.constants.TalonConstants.*;
import static frc.robot.subsystems.Devices.talonSrxClimbHook;
import static frc.robot.RobotManager.isReal;

// ClimbHook subsystem, for extending and retracting the climb hook.
public class ClimbHook extends SubsystemBase {

    // State variables
    public boolean hookIsAimed = false;

    // Position constants
    private final double GEAR_RATIO = 4;
    private final double SPOOL_DIAMETER = 4;
    private final double DISTANCE_AIM = 32;
    private final double DISTANCE_FORWARD = 64;

    // Encoder constants
    private final boolean SENSOR_PHASE_A = true;
    private final boolean MOTOR_INVERT_A = false;

    public ClimbHook() {
        Logger.setup("Constructing Subsystem: ClimbHook...");

        if (isReal) {
            // Configure devices
            configureTalon(talonSrxClimbHook, SENSOR_PHASE_A, MOTOR_INVERT_A);
        }
    }

    // Configure the given talon
    private void configureTalon(DevTalonSRX talon, boolean sensorPhase, boolean motorInvert) {
        if (!talon.isConnected) return;

        talon.configPeakCurrentDuration(PEAK_AMPERAGE_DURATION, TIMEOUT_MS);
        talon.configPeakCurrentLimit(PEAK_AMPERAGE, TIMEOUT_MS);
        talon.configContinuousCurrentLimit(CONTINUOUS_AMPERAGE_LIMIT, TIMEOUT_MS);

        talon.configNominalOutputForward(0);
        talon.configNominalOutputReverse(0);
        talon.configPeakOutputForward(0.5);
        talon.configPeakOutputReverse(-0.5);

        talon.configMotionAcceleration(10000, TIMEOUT_MS);
        talon.configMotionCruiseVelocity(20000, TIMEOUT_MS);

        // Config TalonSRX Redline encoder
        talon.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, PID_LOOP_PRIMARY, TIMEOUT_MS);
        talon.setSensorPhase(sensorPhase);
        talon.setInverted(motorInvert);
        talon.configAllowableClosedloopError(0, PID_LOOP_PRIMARY, TIMEOUT_MS);

        talon.config_kF(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);
        talon.config_kP(PID_LOOP_PRIMARY, 0.5, TIMEOUT_MS); //0.32
        talon.config_kI(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);
        talon.config_kD(PID_LOOP_PRIMARY, 0.0, TIMEOUT_MS);

        // Initialize current encoder position as zero
        talon.setSelectedSensorPosition(0, PID_LOOP_PRIMARY, TIMEOUT_MS);
        SensorCollection sensorCol = talon.getSensorCollection();
        int absolutePosition = sensorCol.getPulseWidthPosition();
        absolutePosition &= 0xFFF;
        if (SENSOR_PHASE_A) absolutePosition *= -1;
        if (MOTOR_INVERT_A) absolutePosition *= -1;
        // Set the quadrature (relative) sensor to match absolute
        talon.setSelectedSensorPosition(absolutePosition, PID_LOOP_PRIMARY, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Toggle the hook position
    public void toggleHookPosition() {
        hookIsAimed = !hookIsAimed;
    }

    // Stop the hook
    public void stop() {
        talonSrxClimbHook.stopMotor();
    }

    // Aim the hook before extending
    public void aimHook() {
        double ticks = EncoderUtils.translateDistanceToTicks(DISTANCE_AIM, SPOOL_DIAMETER, GEAR_RATIO);
        talonSrxClimbHook.set(ControlMode.MotionMagic, ticks);
    }

    // Fully extend the hook
    public void extendHook() {
        double ticks = EncoderUtils.translateDistanceToTicks(DISTANCE_FORWARD, SPOOL_DIAMETER, GEAR_RATIO);
        talonSrxClimbHook.set(ControlMode.MotionMagic, ticks);
    }

    // Retract the hook back to its starting position
    public void retractHook() {
        talonSrxClimbHook.set(ControlMode.MotionMagic, 0);
    }

    //---------//
    // Getters //
    //---------//

    // Get the current motor velocity
    public int getVelocity() {
        return talonSrxClimbHook.getSelectedSensorVelocity();
    }

    // Get the current motor position
    public int getPosition() {
        return talonSrxClimbHook.getSelectedSensorPosition();
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        talonSrxClimbHook.set(0.2);
    }

}

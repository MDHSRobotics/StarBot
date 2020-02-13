
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.utils.EncoderUtils;

import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.constants.TalonConstants.*;
import static frc.robot.subsystems.Devices.talonSrxClimbLegsA;
import static frc.robot.subsystems.Devices.talonSrxClimbLegsB;
import static frc.robot.RobotManager.isReal;

// ClimbLegsRed subsystem, for extending and retracting the climb legs with redline motors.
public class ClimbLegsRed extends SubsystemBase {

    // State variables
    public boolean legsAreRetracted = false;

    // Position constants
    private final double GEAR_RATIO = 52;
    private final double SPOOL_DIAMETER = 2.5;
    private final double DISTANCE = 8;

    // Encoder constants
    private final boolean SENSOR_PHASE_A = false;
    private final boolean MOTOR_INVERT_A = false;

    private final boolean SENSOR_PHASE_B = false;
    private final boolean MOTOR_INVERT_B = false;

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public ClimbLegsRed() {
        Logger.setup("Constructing Subsystem: ClimbLegsRed...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxClimbLegsA == null || talonSrxClimbLegsB == null);
        if (m_disabled) {
            Logger.problem("ClimbLegsRed devices not initialized! Disabling subsystem...");
            return;
        }

        if (isReal) {
            // Configure devices
            configureTalon(talonSrxClimbLegsA, SENSOR_PHASE_A, MOTOR_INVERT_A);
            configureTalon(talonSrxClimbLegsB, SENSOR_PHASE_B, MOTOR_INVERT_B);
        }
    }

    // Configure the given talon
    private void configureTalon(WPI_TalonSRX talon, boolean sensorPhase, boolean motorInvert) {
        talon.configFactoryDefault();

        talon.configPeakCurrentDuration(PEAK_AMPERAGE_DURATION, TIMEOUT_MS);
        talon.configPeakCurrentLimit(PEAK_AMPERAGE, TIMEOUT_MS);
        talon.configContinuousCurrentLimit(CONTINUOUS_AMPERAGE_LIMIT, TIMEOUT_MS);

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

    // Toggle the legs position
    public void toggleLegsPosition() {
        legsAreRetracted = !legsAreRetracted;
    }

    // Stop the legs
    public void stop() {
        if (m_disabled) return;
        talonSrxClimbLegsA.stopMotor();
        talonSrxClimbLegsB.stopMotor();
    }

    // Extend the legs
    public void extendLegs() {
        double ticks = EncoderUtils.translateDistanceToTicks(DISTANCE, SPOOL_DIAMETER, GEAR_RATIO);
        if (m_disabled) return;
        talonSrxClimbLegsA.setSelectedSensorPosition(0);
        talonSrxClimbLegsB.setSelectedSensorPosition(0);
        talonSrxClimbLegsA.set(ControlMode.MotionMagic, ticks);
        talonSrxClimbLegsB.set(ControlMode.MotionMagic, ticks);
    }

    // Retract the legs
    public void retractLegs() {
        if (m_disabled) return;
        talonSrxClimbLegsA.set(ControlMode.MotionMagic, 0);
        talonSrxClimbLegsB.set(ControlMode.MotionMagic, 0);
    }

    // Get the current motor velocity
    public int getVelocity() {
        if (m_disabled) return 0;
        return talonSrxClimbLegsA.getSelectedSensorVelocity();
    }

    // Get the current motor position
    public int getPosition() {
        if (m_disabled) return 0;
        return talonSrxClimbLegsA.getSelectedSensorPosition();
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        if (m_disabled) return;
        talonSrxClimbLegsB.set(0.2);
    }

}

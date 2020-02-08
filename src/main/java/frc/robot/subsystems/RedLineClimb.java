
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.constants.EncoderConstants;
import frc.robot.subsystems.constants.TalonConstants;
import frc.robot.subsystems.Devices;
import frc.robot.subsystems.utils.EncoderUtils;

// RedLineClimb subsystem, for grabbing and releasing hatches
public class RedLineClimb extends SubsystemBase {

    // The public property to determine the RedLineClimb's RedLineClimb state
    public boolean legsAreUp = false;

    // Position constants
    private final double GEAR_RATIO = 52;
    private final double spoolDiameter = 2.5;
    private final double distance = 8;

    // Encoder constants
    private final boolean SENSOR_PHASE = false; // So that Talon does not report sensor out of phase
    private final boolean MOTOR_INVERT = false; // Which direction you want to be positive; this does not affect motor invert

    private final boolean SENSOR_PHASE2 = false;
    private final boolean MOTOR_INVERT2 = false;

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public RedLineClimb() {
        Logger.setup("Constructing Subsystem: RedLineClimb...");

        // Determine whether or not to disable the subsystem
        m_disabled = (Devices.talonSrxRedLineClimbLeg == null || Devices.talonSrxRedLineClimbLeg2 == null);
        if (m_disabled) {
            Logger.problem("RedLineClimb devices not initialized! Disabling subsystem...");
            return;
        }

        //Configure the subsystem devices
        Devices.talonSrxRedLineClimbLeg.configFactoryDefault();

        Devices.talonSrxRedLineClimbLeg.configPeakCurrentDuration(TalonConstants.PEAK_AMPERAGE_DURATION,
                TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg.configPeakCurrentLimit(TalonConstants.PEAK_AMPERAGE, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg.configContinuousCurrentLimit(TalonConstants.CONTINUOUS_AMPERAGE_LIMIT,
                TalonConstants.TIMEOUT_MS);

        Devices.talonSrxRedLineClimbLeg.configNominalOutputForward(0);
        Devices.talonSrxRedLineClimbLeg.configNominalOutputReverse(0);
        Devices.talonSrxRedLineClimbLeg.configPeakOutputForward(0.5);
        Devices.talonSrxRedLineClimbLeg.configPeakOutputReverse(-0.5);

        Devices.talonSrxRedLineClimbLeg.configMotionAcceleration(3000, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg.configMotionCruiseVelocity(8000, TalonConstants.TIMEOUT_MS);

        // Config TalonSRX Redline encoder
        Devices.talonSrxRedLineClimbLeg.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,
                EncoderConstants.PID_LOOP_PRIMARY, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg.setSensorPhase(SENSOR_PHASE);
        Devices.talonSrxRedLineClimbLeg.setInverted(MOTOR_INVERT);
        Devices.talonSrxRedLineClimbLeg.configAllowableClosedloopError(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);

        Devices.talonSrxRedLineClimbLeg.config_kF(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg.config_kP(EncoderConstants.PID_LOOP_PRIMARY, 0.50, TalonConstants.TIMEOUT_MS); //0.32
        Devices.talonSrxRedLineClimbLeg.config_kI(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg.config_kD(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);

        // Initialize current encoder position as zero
        Devices.talonSrxRedLineClimbLeg.setSelectedSensorPosition(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);
        SensorCollection sensorCol = Devices.talonSrxRedLineClimbLeg.getSensorCollection();
        int absolutePosition = sensorCol.getPulseWidthPosition();
        absolutePosition &= 0xFFF;
        if (SENSOR_PHASE)
            absolutePosition *= -1;
        if (MOTOR_INVERT)
            absolutePosition *= -1;
        // Set the quadrature (relative) sensor to match absolute
        Devices.talonSrxRedLineClimbLeg.setSelectedSensorPosition(absolutePosition, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);

        // Second Motor configuration
        Devices.talonSrxRedLineClimbLeg2.configFactoryDefault();

        Devices.talonSrxRedLineClimbLeg2.configPeakCurrentDuration(TalonConstants.PEAK_AMPERAGE_DURATION,
                TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg2.configPeakCurrentLimit(TalonConstants.PEAK_AMPERAGE, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg2.configContinuousCurrentLimit(TalonConstants.CONTINUOUS_AMPERAGE_LIMIT,
                TalonConstants.TIMEOUT_MS);

        Devices.talonSrxRedLineClimbLeg2.configNominalOutputForward(0);
        Devices.talonSrxRedLineClimbLeg2.configNominalOutputReverse(0);
        Devices.talonSrxRedLineClimbLeg2.configPeakOutputForward(0.5);
        Devices.talonSrxRedLineClimbLeg2.configPeakOutputReverse(-0.5);

        Devices.talonSrxRedLineClimbLeg2.configMotionAcceleration(3000, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg2.configMotionCruiseVelocity(8000, TalonConstants.TIMEOUT_MS);

        // Config TalonSRX Redline encoder
        Devices.talonSrxRedLineClimbLeg2.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,
                EncoderConstants.PID_LOOP_PRIMARY, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg2.setSensorPhase(SENSOR_PHASE2);
        Devices.talonSrxRedLineClimbLeg2.setInverted(MOTOR_INVERT2);
        Devices.talonSrxRedLineClimbLeg2.configAllowableClosedloopError(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);

        Devices.talonSrxRedLineClimbLeg2.config_kF(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg2.config_kP(EncoderConstants.PID_LOOP_PRIMARY, 0.5, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg2.config_kI(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxRedLineClimbLeg2.config_kD(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);

        // Initialize current encoder position as zero
        Devices.talonSrxRedLineClimbLeg2.setSelectedSensorPosition(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);
        SensorCollection sensorCol2 = Devices.talonSrxRedLineClimbLeg2.getSensorCollection();
        int absolutePosition2 = sensorCol2.getPulseWidthPosition();
        absolutePosition2 &= 0xFFF;
        if (SENSOR_PHASE2)
            absolutePosition2 *= -1;
        if (MOTOR_INVERT2)
            absolutePosition2 *= -1;
        // Set the quadrature (relative) sensor to match absolute
        Devices.talonSrxRedLineClimbLeg2.setSelectedSensorPosition(absolutePosition2, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Toggle the RedLineClimbIsClosed state
    public void toggleLegsPosition() {
        legsAreUp = !legsAreUp;
    }

    // Stop the RedLineClimb RedLineClimb motor
    public void stop() {
        if (m_disabled)
            return;
        Devices.talonSrxRedLineClimbLeg.stopMotor();
        Devices.talonSrxRedLineClimbLeg2.stopMotor();
    }

    // Open the RedLineClimb
    public void raiseRedLineClimb() {
        double ticks = EncoderUtils.translateDistanceToTicks(distance, spoolDiameter, GEAR_RATIO);
        if (m_disabled)
            return;
        Devices.talonSrxRedLineClimbLeg.setSelectedSensorPosition(0);
        Devices.talonSrxRedLineClimbLeg2.setSelectedSensorPosition(0);
        Devices.talonSrxRedLineClimbLeg.set(ControlMode.MotionMagic, ticks);
        Devices.talonSrxRedLineClimbLeg2.set(ControlMode.MotionMagic, ticks);
    }

    // Close the RedLineClimb RedLineClimb
    public void lowerRedLineClimb() {
        if (m_disabled)
            return;
        Devices.talonSrxRedLineClimbLeg.set(ControlMode.MotionMagic, 0);
        Devices.talonSrxRedLineClimbLeg2.set(ControlMode.MotionMagic, 0);
    }

    // Get the current RedLineClimb RedLineClimb motor velocity
    public int getVelocity() {
        if (m_disabled)
            return 0;
        return Devices.talonSrxRedLineClimbLeg.getSelectedSensorVelocity();
    }

    // Get the current RedLineClimb RedLineClimb motor position
    public int getPosition() {
        if (m_disabled)
            return 0;
        return Devices.talonSrxRedLineClimbLeg.getSelectedSensorPosition();
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        if (m_disabled)
            return;
        Devices.talonSrxRedLineClimbLeg2.set(0.2);
    }

}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.Logger;
import frc.robot.Constants.EncoderConstants;
import frc.robot.Constants.TalonConstants;
import frc.robot.EncoderUtils;
import frc.robot.SubsystemDevices;

// Shooter subsystem, for grabbing and releasing hatches
public class Shooter extends SubsystemBase {

    // The public property to determine the Shooter's claw state
    public boolean clawIsClosed = false;

    // Position constants
    private final double GEAR_RATIO = 16;

    // Encoder constants
    private final boolean SENSOR_PHASE_TOP = false; // So that Talon does not report sensor out of phase
    private final boolean MOTOR_INVERT_TOP = true; // Which direction you want to be positive; this does not affect motor invert

    private final boolean SENSOR_PHASE_BOTTOM = true; // So that Talon does not report sensor out of phase
    private final boolean MOTOR_INVERT_BOTTOM = false; // Which direction you want to be positive; this does not affect motor invert

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.talonSRXShooterTopWheel == null || SubsystemDevices.talonSRXShooterBottomWheel == null);
        if (m_disabled) {
            Logger.error("Shooter devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure TalonSRX TopWheel device
        SubsystemDevices.talonSRXShooterTopWheel.configFactoryDefault();

        SubsystemDevices.talonSRXShooterTopWheel.configPeakCurrentDuration(TalonConstants.PEAK_AMPERAGE_DURATION,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterTopWheel.configPeakCurrentLimit(TalonConstants.PEAK_AMPERAGE,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterTopWheel.configContinuousCurrentLimit(TalonConstants.CONTINUOUS_AMPERAGE_LIMIT,
                TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSRXShooterTopWheel.configNominalOutputForward(0);
        SubsystemDevices.talonSRXShooterTopWheel.configNominalOutputReverse(0);
        SubsystemDevices.talonSRXShooterTopWheel.configPeakOutputForward(0.5);
        SubsystemDevices.talonSRXShooterTopWheel.configPeakOutputReverse(-0.5);

        SubsystemDevices.talonSRXShooterTopWheel.configMotionAcceleration(3000, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterTopWheel.configMotionCruiseVelocity(8000, TalonConstants.TIMEOUT_MS);

        // Config TalonSRX TopWheel Redline encoder
        SubsystemDevices.talonSRXShooterTopWheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,
                EncoderConstants.PID_LOOP_PRIMARY, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterTopWheel.setSensorPhase(SENSOR_PHASE_TOP);
        SubsystemDevices.talonSRXShooterTopWheel.setInverted(MOTOR_INVERT_TOP);
        SubsystemDevices.talonSRXShooterTopWheel.configAllowableClosedloopError(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSRXShooterTopWheel.config_kF(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterTopWheel.config_kP(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterTopWheel.config_kI(EncoderConstants.PID_LOOP_PRIMARY, 0.00025, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterTopWheel.config_kD(EncoderConstants.PID_LOOP_PRIMARY, 0.0, TalonConstants.TIMEOUT_MS);

        // Initialize current encoder position as zero
        SubsystemDevices.talonSRXShooterTopWheel.setSelectedSensorPosition(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);
        SensorCollection sensorCol = SubsystemDevices.talonSRXShooterTopWheel.getSensorCollection();
        int absolutePosition = sensorCol.getPulseWidthPosition();
        absolutePosition &= 0xFFF;
        if (SENSOR_PHASE_TOP)
            absolutePosition *= -1;
        if (MOTOR_INVERT_TOP)
            absolutePosition *= -1;
        // Set the quadrature (relative) sensor to match absolute
        SubsystemDevices.talonSRXShooterTopWheel.setSelectedSensorPosition(absolutePosition, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);


        // Configure TalonSRX BottomWheel device
        SubsystemDevices.talonSRXShooterBottomWheel.configFactoryDefault();

        SubsystemDevices.talonSRXShooterBottomWheel.configPeakCurrentDuration(TalonConstants.PEAK_AMPERAGE_DURATION,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterBottomWheel.configPeakCurrentLimit(TalonConstants.PEAK_AMPERAGE,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterBottomWheel
                .configContinuousCurrentLimit(TalonConstants.CONTINUOUS_AMPERAGE_LIMIT, TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSRXShooterBottomWheel.configNominalOutputForward(0);
        SubsystemDevices.talonSRXShooterBottomWheel.configNominalOutputReverse(0);
        SubsystemDevices.talonSRXShooterBottomWheel.configPeakOutputForward(0.5);
        SubsystemDevices.talonSRXShooterBottomWheel.configPeakOutputReverse(-0.5);

        SubsystemDevices.talonSRXShooterBottomWheel.configMotionAcceleration(3000, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterBottomWheel.configMotionCruiseVelocity(8000, TalonConstants.TIMEOUT_MS);

        // Config TalonSRX BottomWheel Redline encoder
        SubsystemDevices.talonSRXShooterBottomWheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder,
                EncoderConstants.PID_LOOP_PRIMARY, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterBottomWheel.setSensorPhase(SENSOR_PHASE_BOTTOM);
        SubsystemDevices.talonSRXShooterBottomWheel.setInverted(MOTOR_INVERT_BOTTOM);
        SubsystemDevices.talonSRXShooterBottomWheel.configAllowableClosedloopError(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSRXShooterBottomWheel.config_kF(EncoderConstants.PID_LOOP_PRIMARY, 0.0,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterBottomWheel.config_kP(EncoderConstants.PID_LOOP_PRIMARY, 0.0,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterBottomWheel.config_kI(EncoderConstants.PID_LOOP_PRIMARY, 0.00025,
                TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSRXShooterBottomWheel.config_kD(EncoderConstants.PID_LOOP_PRIMARY, 0.0,
                TalonConstants.TIMEOUT_MS);

        // Initialize current encoder position as zero
        SubsystemDevices.talonSRXShooterBottomWheel.setSelectedSensorPosition(0, EncoderConstants.PID_LOOP_PRIMARY,
                TalonConstants.TIMEOUT_MS);
        SensorCollection sensorCol2 = SubsystemDevices.talonSRXShooterBottomWheel.getSensorCollection();
        int absolutePosition2 = sensorCol2.getPulseWidthPosition();
        absolutePosition2 &= 0xFFF;
        if (SENSOR_PHASE_BOTTOM)
            absolutePosition2 *= -1;
        if (MOTOR_INVERT_BOTTOM)
            absolutePosition2 *= -1;
        // Set the quadrature (relative) sensor to match absolute
        SubsystemDevices.talonSRXShooterBottomWheel.setSelectedSensorPosition(absolutePosition2,
                EncoderConstants.PID_LOOP_PRIMARY, TalonConstants.TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the Shooter motors
    public void stop() {
        if (m_disabled)
            return;
        SubsystemDevices.talonSRXShooterTopWheel.stopMotor();
        SubsystemDevices.talonSRXShooterBottomWheel.stopMotor();
    }

    // Spin the top Shooter wheel
    public void spinTopWheel() {
        double velocity = ShooterBrain.getTopWheelVelocity();
        double nativeVelocity = EncoderUtils.translateRPSToTicksPerDecisecond(velocity, GEAR_RATIO);
        Logger.info("Shooter -> TopWheel Velocity to:" + velocity);

        if (m_disabled)
            return;
        SubsystemDevices.talonSRXShooterTopWheel.set(ControlMode.Velocity, nativeVelocity);
    }

    // Spin the bottom Shooter wheel
    public void spinBottomWheel() {
        double velocity = ShooterBrain.getBottomWheelVelocity();
        double nativeVelocity = EncoderUtils.translateRPSToTicksPerDecisecond(velocity, GEAR_RATIO);
        Logger.info("Shooter -> BottomWheel Velocity to:" + velocity);

        if (m_disabled)
            return;
        SubsystemDevices.talonSRXShooterBottomWheel.set(ControlMode.Velocity, nativeVelocity);
    }

    // Get the current Shooter TopWheel motor velocity
    public int getTopWheelVelocity() {
        if (m_disabled)
            return 0;
        return SubsystemDevices.talonSRXShooterTopWheel.getSelectedSensorVelocity();
    }

    // Get the current Shooter BottomWheel motor velocity
    public int getBottomWheelVelocity() {
        if (m_disabled)
            return 0;
        return SubsystemDevices.talonSRXShooterBottomWheel.getSelectedSensorVelocity();
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        if (m_disabled)
            return;
        SubsystemDevices.talonSRXShooterTopWheel.set(0.2);
        SubsystemDevices.talonSRXShooterBottomWheel.set(0.2);

    }

}
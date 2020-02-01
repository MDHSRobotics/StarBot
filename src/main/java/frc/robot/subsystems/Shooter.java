
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.RemoteSensorSource;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.SensorTerm;
import com.ctre.phoenix.motorcontrol.StatusFrame;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.utils.EncoderUtils;

import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.constants.TalonConstants.*;
import static frc.robot.subsystems.Devices.talonSrxShooterBottomWheel;
import static frc.robot.subsystems.Devices.talonSrxShooterTopWheel;

// Shooter subsystem, for shooting balls with two flywheels
public class Shooter extends SubsystemBase {

    // Mechanical constants
    private final double GEAR_RATIO = 1.0;
    private final double WHEEL_DIAMETER = 4.0;

    // Encoder constants
    private static final boolean SENSOR_PHASE_TOP = true;
    private static final boolean MOTOR_INVERT_TOP = true;

    private static final boolean SENSOR_PHASE_BOTTOM = false;
    private static final boolean MOTOR_INVERT_BOTTOM = false;

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxShooterBottomWheel == null || talonSrxShooterTopWheel == null);
        if (m_disabled) {
            Logger.problem("Shooter devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure TalonSRX devices
        configureTalon(talonSrxShooterBottomWheel);
        configureTalon(talonSrxShooterTopWheel);


        // Config TalonSRX Redline Master
        talonSrxShooterTopWheel.configRemoteFeedbackFilter(talonSrxShooterBottomWheel.getDeviceID(), RemoteSensorSource.TalonSRX_SelectedSensor, 1, TIMEOUT_MS);

        // Configure both top and bottom wheel encoders to use for summation feedback (feedback to reach target velocity)
        talonSrxShooterTopWheel.configSensorTerm(SensorTerm.Sum0, FeedbackDevice.RemoteSensor1, TIMEOUT_MS); // Quadrature Encoder of BottomWheel Talon
        talonSrxShooterTopWheel.configSensorTerm(SensorTerm.Sum1, FeedbackDevice.QuadEncoder, TIMEOUT_MS); // Quadrature Encoder of TopWheel Talon

        // Configure both top and bottom wheel encoders to use for difference feedback (feedback to minimize velocity header)
        talonSrxShooterTopWheel.configSensorTerm(SensorTerm.Diff1, FeedbackDevice.RemoteSensor1, TIMEOUT_MS); // Quadrature Encoder of BottomWheel Talon
        talonSrxShooterTopWheel.configSensorTerm(SensorTerm.Diff0, FeedbackDevice.QuadEncoder, TIMEOUT_MS); // Quadrature Encoder of TopWheelTalon

        talonSrxShooterTopWheel.configSelectedFeedbackSensor(FeedbackDevice.SensorSum, PID_LOOP_PRIMARY, TIMEOUT_MS); // Assign summation feedback to the primary PID loop
        talonSrxShooterTopWheel.configSelectedFeedbackCoefficient(0.5, PID_LOOP_PRIMARY, TIMEOUT_MS);

        talonSrxShooterTopWheel.configSelectedFeedbackSensor(FeedbackDevice.SensorDifference, PID_LOOP_AUXILIARY, TIMEOUT_MS); // Assign difference feedback to the auxiliary PID loop
        talonSrxShooterTopWheel.configSelectedFeedbackCoefficient(1, PID_LOOP_AUXILIARY, TIMEOUT_MS);

        talonSrxShooterTopWheel.setSensorPhase(SENSOR_PHASE_BOTTOM);
        talonSrxShooterTopWheel.setInverted(MOTOR_INVERT_BOTTOM);

        // Satus frames to ensure no stale values
        talonSrxShooterTopWheel.setStatusFramePeriod(StatusFrame.Status_12_Feedback1, 20, TIMEOUT_MS);
        talonSrxShooterTopWheel.setStatusFramePeriod(StatusFrame.Status_13_Base_PIDF0, 20, TIMEOUT_MS);
        talonSrxShooterTopWheel.setStatusFramePeriod(StatusFrame.Status_14_Turn_PIDF1, 20, TIMEOUT_MS);

        // PID configuration for target velocity
        talonSrxShooterTopWheel.config_kF(PID_SLOT_0, 0.1, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_kP(PID_SLOT_0, 0.0, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_kI(PID_SLOT_0, 0.0, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_kD(PID_SLOT_0, 0.0, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_IntegralZone(PID_SLOT_0, 300, TIMEOUT_MS);
        talonSrxShooterTopWheel.configClosedLoopPeakOutput(PID_SLOT_0, 1, TIMEOUT_MS);
        talonSrxShooterTopWheel.configAllowableClosedloopError(PID_SLOT_0, 0, TIMEOUT_MS);

        // PID configuration for velocity header
        talonSrxShooterTopWheel.config_kF(PID_SLOT_1, 0.1, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_kP(PID_SLOT_1, 0.0, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_kI(PID_SLOT_1, 0.0, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_kD(PID_SLOT_1, 0.0, TIMEOUT_MS);
        talonSrxShooterTopWheel.config_IntegralZone(PID_SLOT_1, 300, TIMEOUT_MS);
        talonSrxShooterTopWheel.configClosedLoopPeakOutput(PID_SLOT_1, 1, TIMEOUT_MS);
        talonSrxShooterTopWheel.configAllowableClosedloopError(PID_SLOT_1, 0, TIMEOUT_MS);

        talonSrxShooterTopWheel.configClosedLoopPeriod(PID_SLOT_0, CLOSED_LOOP_TIME_MS, TIMEOUT_MS);
        talonSrxShooterTopWheel.configClosedLoopPeriod(PID_SLOT_1, CLOSED_LOOP_TIME_MS, TIMEOUT_MS);

        talonSrxShooterTopWheel.configAuxPIDPolarity(false, TIMEOUT_MS);

        talonSrxShooterTopWheel.selectProfileSlot(PID_SLOT_0, PID_LOOP_PRIMARY);
        talonSrxShooterTopWheel.selectProfileSlot(PID_SLOT_1, PID_LOOP_AUXILIARY);

        zeroOutEncoder(talonSrxShooterTopWheel);


        // Config TalonSRX Redline Follower
        talonSrxShooterBottomWheel.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, PID_LOOP_PRIMARY, TIMEOUT_MS);
        talonSrxShooterBottomWheel.setSensorPhase(SENSOR_PHASE_TOP);
        talonSrxShooterBottomWheel.setInverted(MOTOR_INVERT_TOP);

        talonSrxShooterBottomWheel.setStatusFramePeriod(StatusFrame.Status_2_Feedback0, 5, TIMEOUT_MS);

        zeroOutEncoder(talonSrxShooterBottomWheel);
    }

    // Configure the TalonSRX for this subsystem
    private static void configureTalon(WPI_TalonSRX talon) {
        talon.configFactoryDefault();

        talon.configPeakCurrentDuration(PEAK_AMPERAGE_DURATION, TIMEOUT_MS);
        talon.configPeakCurrentLimit(PEAK_AMPERAGE, TIMEOUT_MS);
        talon.configContinuousCurrentLimit(CONTINUOUS_AMPERAGE_LIMIT, TIMEOUT_MS);
        talon.enableCurrentLimit(true);

        talon.configVoltageCompSaturation(12);
        talon.enableVoltageCompensation(true);

        talon.configNominalOutputForward(0);
        talon.configNominalOutputReverse(0);
        talon.configPeakOutputForward(1);
        talon.configPeakOutputReverse(-1);

        talon.configNeutralDeadband(NEUTRAL_DEADBAND, TIMEOUT_MS);

        talon.configMotionAcceleration(3000, TIMEOUT_MS);
        talon.configMotionCruiseVelocity(8000, TIMEOUT_MS);
    }

    private static void zeroOutEncoder(WPI_TalonSRX talon){
        // // Initialize current encoder position as zero
        // talon.setSelectedSensorPosition(0, PID_LOOP_PRIMARY, TIMEOUT_MS);
        // SensorCollection sensorCol = talon.getSensorCollection();
        // int absolutePosition = sensorCol.getPulseWidthPosition();
        // absolutePosition &= 0xFFF;
        // if (SENSOR_PHASE_TOP)
        //     absolutePosition *= -1;
        // if (MOTOR_INVERT_TOP)
        //     absolutePosition *= -1;
        // // Set the quadrature (relative) sensor to match absolute
        // talon.setSelectedSensorPosition(absolutePosition, PID_LOOP_PRIMARY, TIMEOUT_MS);

        SensorCollection sensorCol = talon.getSensorCollection();
        sensorCol.setQuadraturePosition(0, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the shooter
    public void stop() {
        if (m_disabled) return;
        talonSrxShooterBottomWheel.stopMotor();
        talonSrxShooterTopWheel.stopMotor();
    }

    // Spin the bottom shooter wheel
    public void spinBottomWheel() {
        if (m_disabled) return;
        talonSrxShooterBottomWheel.follow(talonSrxShooterTopWheel, FollowerType.AuxOutput1);

        Logger.info("------spinBottomWheel IS BEING CALLED");
    }

    // Spin the top shooter wheel
    public void spinTopWheel() {
        double velocity = ShooterBrain.getTopWheelVelocity();
        double nativeVelocity = EncoderUtils.translateFPSToTicksPerDecisecond(velocity, WHEEL_DIAMETER, GEAR_RATIO);
        double position = talonSrxShooterBottomWheel.getSelectedSensorPosition(PID_SLOT_1);
        Logger.info("Shooter -> FlyWheel Velocity to:" + velocity + " FPS");
        Logger.info("Shooter -> FlyWheel Native Velocity to:" + nativeVelocity + " TPDS");

        if (m_disabled) return;
        talonSrxShooterTopWheel.set(ControlMode.Velocity, nativeVelocity, DemandType.AuxPID, position);

        Logger.info("------spinTopWheel IS BEING CALLED");
    }

    // Get the current shooter bottom wheel motor velocity
    public int getBottomWheelVelocity() {
        if (m_disabled) return 0;
        int velocity = talonSrxShooterBottomWheel.getSelectedSensorVelocity();
        return velocity;
    }

    // Get the current shooter top wheel motor velocity
    public int getTopWheelVelocity() {
        if (m_disabled) return 0;
        int velocity = talonSrxShooterTopWheel.getSelectedSensorVelocity();
        return velocity;
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        if (m_disabled) return;
        talonSrxShooterBottomWheel.set(1.0);
        talonSrxShooterTopWheel.set(1.0);
    }

}

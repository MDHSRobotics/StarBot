package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.SensorCollection;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.DiffDriverBrain;
import frc.robot.consoles.Logger;
import frc.robot.sensors.DistanceSensor;
import frc.robot.sensors.Gyro;
import frc.robot.BotSensors;
import frc.robot.BotSubsystems;

import frc.robot.subsystems.constants.PathConstants;
import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.constants.TalonConstants.*;

import static frc.robot.subsystems.Devices.diffDrive;
import static frc.robot.subsystems.Devices.talonFxDiffWheelFrontLeft;
import static frc.robot.subsystems.Devices.talonFxDiffWheelFrontRight;
import static frc.robot.subsystems.Devices.talonFxDiffWheelRearLeft;
import static frc.robot.subsystems.Devices.talonFxDiffWheelRearRight;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;

// Differential driver subsystem
public class DiffDriver extends SubsystemBase {

    // The direction of forward/backward via the controller
    public boolean controlStickDirectionFlipped = false;

    // Motor constants
    private final double SECONDS_FROM_NEUTRAL_TO_FULL = 0;
    private final double AUTO_PERIOD_SPEED = 0.5;

    //Odometry class for tracking robot pose (PathWeaver)
    private DifferentialDriveOdometry m_odometry;

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public DiffDriver() {
        Logger.setup("Constructing Subsystem: DiffDriver...");

        // Determine whether or not to disable the subsystem
        m_disabled = (diffDrive == null);
        if (m_disabled) {
            Logger.problem("DiffDriver devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        // TODO: Investigate why these motor controllers have to be inverted.
        //       Are all TalonFx Motor Controllers backwards?
        talonFxDiffWheelFrontLeft.setInverted(true);
        talonFxDiffWheelFrontRight.setInverted(true);
        talonFxDiffWheelRearLeft.setInverted(true);
        talonFxDiffWheelRearRight.setInverted(true);
        talonFxDiffWheelRearLeft.follow(talonFxDiffWheelFrontLeft);
        talonFxDiffWheelRearRight.follow(talonFxDiffWheelFrontRight);

        talonFxDiffWheelFrontLeft.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        talonFxDiffWheelRearLeft.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        talonFxDiffWheelFrontRight.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        talonFxDiffWheelRearRight.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);

        m_odometry = new DifferentialDriveOdometry(Rotation2d.fromDegrees(getHeading()));

        configureTalon(talonFxDiffWheelFrontLeft, false, false);
        configureTalon(talonFxDiffWheelFrontRight, false, false);
        configureTalon(talonFxDiffWheelRearLeft, false, false);
        configureTalon(talonFxDiffWheelRearRight, false, false);
    }

    // Configure the talons for this subsystem
    private static void configureTalon(WPI_TalonFX talon, boolean sensorPhase, boolean motorInvert) {
        talon.configFactoryDefault();

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
        if (sensorPhase)
            absolutePosition2 *= -1;
        if (motorInvert)
            absolutePosition2 *= -1;
        // Set the quadrature (relative) sensor to match absolute
        talon.setSelectedSensorPosition(absolutePosition2, PID_LOOP_PRIMARY, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

        // Update the odometry in the periodic block
        m_odometry.update(Rotation2d.fromDegrees(getHeading()), talonFxDiffWheelFrontLeft.getSelectedSensorPosition(),
                talonFxDiffWheelFrontRight.getSelectedSensorPosition());
    }

    // Flip the control direction of the joystick in Y (or Y Left for Xbox thumbsticks)
    public Boolean flipControlStickDirection() {
        Logger.action("Toggling DiffDriver control stick direction...");

        controlStickDirectionFlipped = !controlStickDirectionFlipped;
        if (controlStickDirectionFlipped) {
            Logger.info("DiffDriver control stick direction is now flipped.");
        } else {
            Logger.info("DiffDriver control stick direction is now standard (not flipped).");
        }
        return controlStickDirectionFlipped;
    }

    // Stop all the drive motors
    public void stop() {
        if (m_disabled) return;
        diffDrive.stopMotor();
    }

    // Drive using the tank method
    public void driveTank(double leftSpeed, double rightSpeed) {
        if (m_disabled) return;
        // Logger.info("Left Speed: " + leftSpeed + "; Right Speed: " + rightSpeed);
        diffDrive.tankDrive(leftSpeed, rightSpeed);
    }

    // Drive forward at a set speed
    public void moveForwardAuto() {
        if (m_disabled) return;
        diffDrive.tankDrive(AUTO_PERIOD_SPEED, AUTO_PERIOD_SPEED); // drive towards heading 0
    }

    // Drive to center the robot perpendicular to the shoot target
    // based on the detected distance to the near side arena wall
    public void centerOnTarget() {
        double distance = DistanceSensor.getDistanceInMeters();
        double targetMaximum = 3;
        double targetMinimum = 2;
        if (distance > targetMinimum && distance < targetMaximum) {
            diffDrive.stopMotor();
            Logger.info("DiffDriver -> CenterOnTarget -> Distance: " + distance + " Target Reached!");
        } else if (distance > targetMaximum) {
            diffDrive.arcadeDrive(.4, 0);
            Logger.info("DiffDriver -> CenterOnTarget -> Distance: " + distance + " Too far from the target!");
        } else if (distance < targetMinimum) {
            diffDrive.arcadeDrive(.4, 0);
            Logger.info("DiffDriver -> CenterOnTarget -> Distance: " + distance + " Too close to the target!");
        }
    }

    // Drive to align the robot to a detected line at the given yaw
    public void driveAlign(double targetYaw) {
        // Get the correction yaw needed to align the Robot with the target yaw
        double yaw = BotSensors.gyro.getYaw();
        double correction = targetYaw - yaw;
        if (correction > 180) correction = correction - 360;
        if (correction < -180) correction = correction + 360;
        Logger.info("DiffDriver -> Gyro -> Target Yaw: " + targetYaw + "; Current Yaw: " + yaw + "; Correction: " + correction);

        // Get the rotation speed to align the robot with the target gyro yaw
        double zRotation = (correction / 180) * DiffDriverBrain.getAlignZSensitivity();
        boolean isCloseEnough = Math.abs(correction) < DiffDriverBrain.getAlignZTolerance();
        if (!isCloseEnough) {
            double alignZSpeedMinimum = DiffDriverBrain.getAlignZSpeedMinimum();
            if (0 < zRotation && zRotation < alignZSpeedMinimum) zRotation = alignZSpeedMinimum;
            if (0 > zRotation && zRotation > -alignZSpeedMinimum) zRotation = -alignZSpeedMinimum;
        }

        Logger.action("DiffDriver -> Drive Tank: " + zRotation);
        if (m_disabled) return;
        diffDrive.arcadeDrive(0, zRotation);
    }

    // TODO: Use this to indicate to the driver that the robot is aligned with the target (lights? Shuffleboard?)
    public boolean isAligned(double targetAngle) {
        boolean straight = Gyro.isYawAligned(targetAngle);
        if (!straight) return false;

        Logger.info("DiffDriver -> Robot is fully aligned!");
        return true;
    }

    //---PathWeaver methods---//

    // returns the heading of the robot
    public double getHeading() {
        return Math.IEEEremainder(
            BotSensors.gyro.getAngle(), 360) * (PathConstants.kGyroReversed ? -1.0 : 1.0
        );
    }

    // returns the turn rate of the robot
    public Pose2d getPose() {
        return m_odometry.getPoseMeters();
    }

    // Returns the current wheel speeds of the robot.
    public DifferentialDriveWheelSpeeds getWheelSpeeds() {
        return new DifferentialDriveWheelSpeeds(talonFxDiffWheelFrontLeft.getRate(),
                talonFxDiffWheelFrontLeft.getRate());
    }

    // Resets the drive encoders to currently read a position of 0
    public void resetEncoders() {
        talonFxDiffWheelFrontLeft.setSelectedSensorPosition(0, 0, TIMEOUT_MS);
        talonFxDiffWheelFrontLeft.setSelectedSensorPosition(0, 0, TIMEOUT_MS);
    }

    // Resets the odometry to the specified pose.
    public void resetOdometry(Pose2d pose) {
        resetEncoders();
        m_odometry.resetPosition(pose, Rotation2d.fromDegrees(getHeading()));
    }

    /**
     * Controls the left and right sides of the drive directly with voltages. Uses
     * setVoltage() rather than set(), as this will automatically compensate
     * for battery “voltage sag” during operation.
     */
    public void tankDriveVolts(double leftVolts, double rightVolts) {
        talonFxDiffWheelFrontLeft.setVoltage(leftVolts);
        talonFxDiffWheelFrontRight.setVoltage(-rightVolts);
        BotSubsystems.diffDriver.feed();
    }

}



package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.DiffDriverBrain;
import frc.robot.consoles.Logger;
import frc.robot.devices.DevTalonFX;
import frc.robot.sensors.DistanceSensor;
import frc.robot.sensors.Gyro;
import frc.robot.BotSensors;

import static frc.robot.subsystems.Devices.diffDrive;
import static frc.robot.subsystems.Devices.talonFxDiffWheelFrontLeft;
import static frc.robot.subsystems.Devices.talonFxDiffWheelFrontRight;
import static frc.robot.subsystems.Devices.talonFxDiffWheelRearLeft;
import static frc.robot.subsystems.Devices.talonFxDiffWheelRearRight;
import static frc.robot.RobotManager.isReal;

// Differential driver subsystem.
public class DiffDriver extends SubsystemBase {

    // The direction of forward/backward via the controller
    public boolean controlStickDirectionFlipped = false;

    // Motor constants
    private final double SECONDS_FROM_NEUTRAL_TO_FULL = 0;
    private final int TIMEOUT_MS = 10;
    private final double AUTO_PERIOD_SPEED = 0.5;

    public DiffDriver() {
        Logger.setup("Constructing Subsystem: DiffDriver...");

        if (isReal) {
            // Configure the subsystem devices
            configureTalon(talonFxDiffWheelFrontLeft);
            configureTalon(talonFxDiffWheelFrontRight);
            configureTalon(talonFxDiffWheelRearLeft);
            configureTalon(talonFxDiffWheelRearRight);
            talonFxDiffWheelRearLeft.follow(talonFxDiffWheelFrontLeft);
            talonFxDiffWheelRearRight.follow(talonFxDiffWheelFrontRight);
        }
    }

    // Configure the given talon
    private void configureTalon(DevTalonFX talon) {
        if (!talon.isConnected) return;

        // TODO: Investigate why these motor controllers have to be inverted.
        talon.setInverted(true);
        talon.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
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
        diffDrive.stopMotor();
    }

    // Drive using the tank method
    public void driveTank(double leftSpeed, double rightSpeed) {
        // Logger.info("Left Speed: " + leftSpeed + "; Right Speed: " + rightSpeed);
        diffDrive.tankDrive(leftSpeed, rightSpeed);
    }

    // Drive forward at a set speed
    public void moveForwardAuto() {
        diffDrive.tankDrive(AUTO_PERIOD_SPEED, AUTO_PERIOD_SPEED); // drive towards heading 0
    }

    // Drive to within the given range based on the given distance sensor
    public void driveToWithinRange(AnalogInput distanceSensor, double targetMinimum, double targetMaximum) {
        double distance = DistanceSensor.getDistanceInMeters(distanceSensor);
        if (distance > targetMinimum && distance < targetMaximum) {
            diffDrive.stopMotor();
            Logger.info("DiffDriver -> DriveToWithinRange -> Distance: " + distance + " -> Target Reached!");
        } else if (distance > targetMaximum) {
            diffDrive.arcadeDrive(.4, 0);
            Logger.info("DiffDriver -> DriveToWithinRange -> Distance: " + distance + " -> Too far from the target!");
        } else if (distance < targetMinimum) {
            diffDrive.arcadeDrive(.4, 0);
            Logger.info("DiffDriver -> DriveToWithinRange -> Distance: " + distance + " -> Too close to the target!");
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
        diffDrive.arcadeDrive(0, zRotation);
    }

    // TODO: Use this to indicate to the driver that the robot is aligned with the target (lights? Shuffleboard?)
    public static boolean isAligned(double targetAngle) {
        boolean straight = Gyro.isYawAligned(targetAngle);
        if (!straight) return false;

        Logger.info("DiffDriver -> Robot is fully aligned!");
        return true;
    }

}


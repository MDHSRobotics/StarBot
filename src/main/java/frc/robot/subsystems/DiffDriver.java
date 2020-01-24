
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.diffDrive;
import static frc.robot.subsystems.Devices.talonFxDiffWheelFrontLeft;
import static frc.robot.subsystems.Devices.talonFxDiffWheelFrontRight;
import static frc.robot.subsystems.Devices.talonFxDiffWheelRearLeft;
import static frc.robot.subsystems.Devices.talonFxDiffWheelRearRight;

// Differential driver subsystem
public class DiffDriver extends SubsystemBase {

    // The direction of forward/backward via the controller
    public boolean controlStickDirectionFlipped = false;

    // Motor constants
    private final double SECONDS_FROM_NEUTRAL_TO_FULL = 0;
    private final int TIMEOUT_MS = 10;
    private final double AUTO_PERIOD_SPEED = 0.5;

    // If any of the devices are null, this should be true
    private boolean m_disabled = false;

    public DiffDriver() {
        Logger.setup("Constructing Subsystem: DiffDriver...");

        // Determine whether or not to disable the subsystem
        m_disabled = (Devices.diffDrive == null);
        if (m_disabled) {
            Logger.error("DiffDriver devices not initialized! Disabling subsystem...");
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
        if (m_disabled) return;

        diffDrive.stopMotor();
    }

    // Drive using the tank method
    public void driveTank(double leftSpeed, double rightSpeed) {
        if (m_disabled) return;

        // Logger.info("Leftspeed = " + leftSpeed + "; Rightspeed = " + rightSpeed);
        diffDrive.tankDrive(leftSpeed, rightSpeed);
    }

    // Test drive: move forward
    public void moveForwardAuto() {
        diffDrive.tankDrive(AUTO_PERIOD_SPEED, AUTO_PERIOD_SPEED); // drive towards heading 0
    }
}

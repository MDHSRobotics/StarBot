package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

// Lighter subsystem, for turning lights on and off.
public class Autonomous extends SubsystemBase {

    //private boolean m_autoDriveDisabled;

    public Autonomous() {
        Logger.setup("Constructing Subsystem: Autonomous...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

//         while (isAutonomous() && isEnabled()) {
//              double angle = gyro.getAngle();
//              myDrive.arcadeDrive(-1.0, -angle * Kp);
//              Timer.delay(0.01);
//          }

    }

    // public void stopDrive() {
    //     if (m_autoDriveDisabled.getDiffDriver) {
    //         SubsystemDevices.diffDrive.feed();
    //         return;
    //     }

    //     SubsystemDevices.diffDrive.stopMotor();
    // }
}

/*
// The direction of forward/backward via the controller
    public boolean controlStickDirectionFlipped = false;

    // Motor constants
    private final double SECONDS_FROM_NEUTRAL_TO_FULL = 0;
    private final int TIMEOUT_MS = 10;

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public DiffDriver() {
        Logger.setup("Constructing Subsystem: DiffDriver...");


        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.diffDrive == null);
        if (m_disabled) {
            Logger.error("DiffDriver devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        // TODO: Investigate why these motor controllers have to be inverted. Are all
        // TalonFx Motor Controllers backwards?
        SubsystemDevices.talonFxDiffWheelFrontLeft.setInverted(true);
        SubsystemDevices.talonFxDiffWheelFrontRight.setInverted(true);
        SubsystemDevices.talonFxDiffWheelRearLeft.setInverted(true);
        SubsystemDevices.talonFxDiffWheelRearRight.setInverted(true);
        SubsystemDevices.talonFxDiffWheelRearLeft.follow(SubsystemDevices.talonFxDiffWheelFrontLeft);
        SubsystemDevices.talonFxDiffWheelRearRight.follow(SubsystemDevices.talonFxDiffWheelFrontRight);

        SubsystemDevices.talonFxDiffWheelFrontLeft.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        SubsystemDevices.talonFxDiffWheelRearLeft.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        SubsystemDevices.talonFxDiffWheelFrontRight.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
        SubsystemDevices.talonFxDiffWheelRearRight.configOpenloopRamp(SECONDS_FROM_NEUTRAL_TO_FULL, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Flip the control direction of the joystick in Y (or Y Left for Xbox
    // thumbsticks)
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
        if (m_disabled) {
            SubsystemDevices.diffDrive.feed();
            return;
        }

        SubsystemDevices.diffDrive.stopMotor();
    }

    // Drive using the tank method
    public void driveTank(double leftSpeed, double rightSpeed) {
        if (m_disabled) {
            SubsystemDevices.diffDrive.feed();
            return;
        }

        // Logger.info("Leftspeed = " + leftSpeed + "; Rightspeed = " + rightSpeed);
        SubsystemDevices.diffDrive.tankDrive(leftSpeed, rightSpeed);
    }

}
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

// Lighter subsystem, for turning lights on and off.
public class Autonomous extends SubsystemBase {

    // private boolean m_autoDriveDisabled;

    public static final String DiffDriver = null;

	public Autonomous() {
        Logger.setup("Constructing Subsystem: Autonomous...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void stopDrive() {
    //     if (m_autoDriveDisabled.getDiffDriver) {
    //         SubsystemDevices.diffDrive.feed();
    //         return;
    //     }

    //     SubsystemDevices.diffDrive.stopMotor();
    }
}

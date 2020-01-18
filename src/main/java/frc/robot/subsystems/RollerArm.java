
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Arm subsystem for the Roller, for raising and lowering the Roller
public class RollerArm extends SubsystemBase {

    // The public property to determine the RollerArm's state
    public boolean armIsUp = true;

    // If not all the Compressors are initialized, this should be true
    private boolean m_disabled = false;

    public RollerArm() {
        Logger.setup("Constructing Subsystem: RollerArm...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.compressorRollerArm == null ||
                      SubsystemDevices.solenoidRollerArm == null);
        if (m_disabled) {
            Logger.error("RollerArm devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        SubsystemDevices.compressorRollerArm.setClosedLoopControl(true);
        SubsystemDevices.solenoidRollerArm.set(false);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Get the current being used by the roller arm compressor
    public int getCurrent() {
        if (m_disabled) return 0;
        return (int)SubsystemDevices.compressorRollerArm.getCompressorCurrent();
    }

    // Lower the roller arm
    public void lowerArm() {
        if (m_disabled) return;
        SubsystemDevices.solenoidRollerArm.set(true);
    }

    // Raise the roller arm
    public void raiseArm() {
        if (m_disabled) return;
        SubsystemDevices.solenoidRollerArm.set(false);
    }

    // Toggle the position of the roller arm
    public void toggleArmPosition() {
        armIsUp = !armIsUp;
    }

}

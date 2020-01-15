
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Roller Subsytem, for sucking in balls
public class Roller extends SubsystemBase {

    private final double POWER = 0.2;

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Roller() {
         Logger.setup("Constructing Subsystem: Roller...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.talonSrxRoller == null);
        if (m_disabled) {
            Logger.error("Roller devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        SubsystemDevices.talonSrxRoller.configFactoryDefault();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the roller motor
    public void stop() {
        if (m_disabled) return;
        SubsystemDevices.talonSrxRoller.stopMotor();
    }

    // Spin the roller motor
    public void spin() {
        if (m_disabled) return;
        SubsystemDevices.talonSrxRoller.set(POWER);
    }

}

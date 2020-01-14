
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import frc.robot.BotSubsystems;
import frc.robot.SubsystemDevices;
import frc.robot.commands.roller.RollerSpin;

// TestPneumatic subsystem, for testing solenoid actuation and compressors
public class PickUpPneumatic extends SubsystemBase {

    private boolean m_pcmIsNotConnected = false;

    // The public property to determine the PickUp's state
    public boolean pickUpIsUp = false;

    // If not all the Compressors are initialized, this should be true
    private boolean m_disabled = false;

    public PickUpPneumatic() {
        Logger.setup("Constructing Subsystem: PickUpPneumatic...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.pcm.getClosedLoopControl() == false);
        if (m_disabled) {
            Logger.error("Pneumatic devices not initialized! Disabling subsystem...");
            return;
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Toggle the state of the PickUp system
    public void togglePickUpPosition() {
        pickUpIsUp = !pickUpIsUp;
    }
    //----------// Compressor

    // Stop the compressor
    public void stop() {
        if (m_pcmIsNotConnected)
            return;
        SubsystemDevices.pcm.stop();
    }

    // Start the compressor
    public void start() {
        if (m_pcmIsNotConnected)
            return;
        SubsystemDevices.pcm.start();
    }

    //----------// Single Solenoids

    // Extend solenoid1
    public void openSolenoid() {
        if (m_pcmIsNotConnected)
            return;
        SubsystemDevices.testSolenoid.set(true);
    }

    // Retract solenoid1
    public void closeSolenoid() {
        if (m_pcmIsNotConnected)
            return;
        SubsystemDevices.testSolenoid.set(false);
    }

    public boolean isUnderPressure() {
        return SubsystemDevices.pcm.getPressureSwitchValue();
    }
}
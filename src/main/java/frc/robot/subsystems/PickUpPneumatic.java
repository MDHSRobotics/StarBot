
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import frc.robot.BotSubsystems;
import frc.robot.SubsystemDevices;
import frc.robot.commands.roller.RollerSpin;

// TestPneumatic subsystem, for testing solenoid actuation and compressors
public class PickUpPneumatic extends BotSubsystems {

    private boolean m_pcmIsNotConnected = false;

    // The public property to determine the PickUp's state
    public boolean pickUpIsUp = false;

    public PickUpPneumatic() {

        m_pcmIsNotConnected = SubsystemDevices.pcm.getCompressorNotConnectedFault();

        if (m_pcmIsNotConnected) {
            Logger.error("PickUpPneumatic compressor is not connected! Disabling PickUpPneumatic...");

            SubsystemDevices.pcm.setClosedLoopControl(false);
        } else {
            Logger.setup("Constructing Subsystem: PickUpPneumatic...");

            SubsystemDevices.pcm.setClosedLoopControl(true);
        }
    }

    // @Override
    // public void periodic() {
    //     // This method will be called once per scheduler run
    // }

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

    // Extend the solenoid2
    // public void openSolenoid2() {
    //     if (m_pcmIsNotConnected)
    //         return;
    //     Devices.testSolenoid2.set(true);
    // }

    // Retract the solenoid2
    public void closeSolenoid2() {
        if (m_pcmIsNotConnected)
            return;
        SubsystemDevices.testSolenoid2.set(false);
    }

    //----------// Double Solenoid

    // Extend solenoid1 and retract solenoid2
    // public void openDoubleSolenoid() {
    //     if (m_pcmIsNotConnected)
    //         return;
    //     Devices.testDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    // }

    // Extend solenoid2 and restract solenoid1
    // public void closeDoubleSolenoid() {
    //     if (m_pcmIsNotConnected)
    //         return;
    //     Devices.testDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    // }

    //----------// Sensors

    public boolean isUnderPressure() {
        return SubsystemDevices.pcm.getPressureSwitchValue();
    }
}
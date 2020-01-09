
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Lighter subsystem, for turning lights on and off.
public class Lighter extends SubsystemBase {

    public Lighter() {
        Logger.setup("Constructing Subsystem: Lighter...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void turnOnBoth() {
        SubsystemDevices.relayLighter.set(Relay.Value.kOn);
    }

    public void turnOffBoth() {
        SubsystemDevices.relayLighter.set(Relay.Value.kOff);
    }

    public void turnOnWhiteOnly() {
        SubsystemDevices.relayLighter.set(Relay.Value.kForward);
    }

    public void turnOnRedOnly() {
        SubsystemDevices.relayLighter.set(Relay.Value.kReverse);
    }

}


package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;

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
        Devices.relayLighter.set(Relay.Value.kOn);
    }

    public void turnOffBoth() {
        Devices.relayLighter.set(Relay.Value.kOff);
    }

    public void turnOnWhiteOnly() {
        Devices.relayLighter.set(Relay.Value.kForward);
    }

    public void turnOnRedOnly() {
        Devices.relayLighter.set(Relay.Value.kReverse);
    }

}


package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import static frc.robot.subsystems.Devices.relayLighter;

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
        relayLighter.set(Relay.Value.kOn);
    }

    public void turnOffBoth() {
        relayLighter.set(Relay.Value.kOff);
    }

    public void turnOnWhiteOnly() {
        relayLighter.set(Relay.Value.kForward);
    }

    public void turnOnRedOnly() {
        relayLighter.set(Relay.Value.kReverse);
    }

}

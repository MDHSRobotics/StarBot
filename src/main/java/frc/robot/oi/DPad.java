
package frc.robot.oi;

import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj.GenericHID;

// Represents the directional pad on an xbox controller (or equivalent on another device).
public class DPad extends Button {

    public GenericHID device;

    public DPad(final GenericHID humanInterfaceDevice) {
        this.device = humanInterfaceDevice;
    }

    @Override
    public boolean get() {
        final int angle = device.getPOV(0);
        return (angle != -1);
    }

}

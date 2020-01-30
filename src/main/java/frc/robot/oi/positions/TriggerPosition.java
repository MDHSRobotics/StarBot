
package frc.robot.oi.positions;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.oi.ControlDevices;

// The position values obtained from Xbox Triggers
public class TriggerPosition {

    public double leftTriggerPosition = 0;
    public double rightTriggerPosition = 0;

    public TriggerPosition() {
    }

    public TriggerPosition(double leftTrigger, double rightTrigger) {
        leftTriggerPosition = leftTrigger;
        rightTriggerPosition = rightTrigger;
    }

    // Gets the xbox trigger positions
    public static TriggerPosition getTriggerPosition(XboxController xbox) {
        int port = xbox.getPort();
        boolean xboxIsConnected = ControlDevices.isStickConnected(port);
        if (!xboxIsConnected) {
            return new TriggerPosition();
        }

        double leftTriggerAxis = xbox.getTriggerAxis(Hand.kLeft);
        double rightTriggerAxis = xbox.getTriggerAxis(Hand.kRight);

        TriggerPosition pos = new TriggerPosition(leftTriggerAxis, rightTriggerAxis);
        return pos;
    }

}

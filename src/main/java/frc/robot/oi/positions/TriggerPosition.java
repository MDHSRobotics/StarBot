
package frc.robot.oi.positions;

import frc.robot.oi.controllers.XboxControllerContainer;

// The position values obtained from xbox triggers
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
    public static TriggerPosition getTriggerPositions(XboxControllerContainer controller) {
        TriggerPosition pos = controller.getTriggerPositions();
        return pos;
    }

}

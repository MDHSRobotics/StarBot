
package frc.robot.oi.movements;

import frc.robot.oi.controllers.XboxControllerContainer;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.positions.TriggerPosition;

// This class contains the methods needed to determine conveyor speed.
public class ConveyMovement {

    // Determines speed of conveyor belt from the right thumbstick and trigger
    public static double getConveySpeed(XboxControllerContainer xbox) {
        ThumbstickPosition thumbPos = ThumbstickPosition.getPositions(xbox, false);
        double thumbstick = thumbPos.rightSideToSidePosition;

        TriggerPosition triggerPos = TriggerPosition.getTriggerPositions(xbox);
        double trigger = triggerPos.rightTriggerPosition;

        return thumbstick - trigger;
    }

}

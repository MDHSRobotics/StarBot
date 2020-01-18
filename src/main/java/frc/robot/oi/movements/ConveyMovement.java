
package frc.robot.oi.movements;

import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.positions.TriggerPosition;

import edu.wpi.first.wpilibj.XboxController;

// The values needed to front wheel drive
public class ConveyMovement {

    public double conveySpeed = 0;

    public ConveyMovement() {
    }

    public ConveyMovement(double speed) {
        conveySpeed = speed;
    }

    //determines speed of conveyor belt from the right thumbstick
    public static double getConveySpeed(XboxController xbox) {
        double thumbstick = ThumbstickPosition.getThumbstickPosition(xbox, false).rightSideToSidePosition;
        double trigger = TriggerPosition.getTriggerPosition(xbox).rightTriggerPosition;

        return thumbstick - trigger;
    }

}

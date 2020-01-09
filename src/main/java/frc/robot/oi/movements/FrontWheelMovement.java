
package frc.robot.oi.movements;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;

// The values needed to front wheel drive
public class FrontWheelMovement {

    public double straightSpeed = 0;

    public FrontWheelMovement() {
    }

    public FrontWheelMovement(double straight) {
        straightSpeed = straight;
    }

    // Determines the front wheel drive movement (straight speed)
    // from the current xbox left-hand trigger axis
    public static double getFrontWheelDriveSpeed(XboxController xbox) {
        double triggerAxis = xbox.getTriggerAxis(Hand.kLeft);
        return triggerAxis;
    }

}


package frc.robot.oi.movements;

import edu.wpi.first.wpilibj.XboxController;

import frc.robot.brains.ControlStickBrain;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.ControlDevices;
import frc.robot.oi.ControlDevices.ControlStick;

// The values needed to drive using tank mode
public class TankMovement {

    public double leftSpeed = 0; // x left Forward & Backward
    public double rightSpeed = 0; // x right Forward & Backward

    public TankMovement() {
    }

    public TankMovement(double xLeftSpeed, double xRightSpeed) {
        leftSpeed = xLeftSpeed;
        rightSpeed = xRightSpeed;
    }

    // Determines the tank movement (up or down for Left, up or down for Right)
    // from the active control stick position(s)
    public static TankMovement getTankMovement(boolean isYflipped) {
        ControlStick cStick = ControlStickBrain.getControlStick();
        switch (cStick) {
            case XBOX:
                return getTankMovementFromThumbsticks(ControlDevices.driveXbox, isYflipped);
            default:
                return null;
        }
    }

    // Determines the tank movement (left-side straight speed, right-side straight speed)
    // from the current xbox thumbstick positions
    public static TankMovement getTankMovementFromThumbsticks(XboxController xbox, boolean isYflipped) {
        ThumbstickPosition pos = ThumbstickPosition.getThumbstickPosition(xbox, isYflipped);
        TankMovement move = new TankMovement(pos.leftForwardBackPosition, pos.rightForwardBackPosition);
        //Logger.info("Xbox Tank Movement: " + pos.leftForwardBackPosition + ", " + pos.rightForwardBackPosition);
        return move;
    }

}
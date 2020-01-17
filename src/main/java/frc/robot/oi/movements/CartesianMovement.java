
package frc.robot.oi.movements;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.brains.ControlStickBrain;
import frc.robot.oi.positions.JoystickPosition;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.ControlDevices;
import frc.robot.oi.ControlDevices.ControlStick;

// The values needed to drive using cartesian coordinates
public class CartesianMovement {

    public double strafeSpeed = 0; // y Side to Side
    public double straightSpeed = 0; // x Forward & Backward
    public double rotationSpeed = 0; // z Rotate

    public CartesianMovement() {
    }

    public CartesianMovement(double yStrafeSpeed, double xStraightSpeed, double zRotationSpeed) {
        strafeSpeed = yStrafeSpeed;
        straightSpeed = xStraightSpeed;
        rotationSpeed = zRotationSpeed;
    }

    // Determines the cartesian movement (forward/backward speed, side to side speed, rotation speed)
    // from the active control stick position(s)
    public static CartesianMovement getCartesianMovement(boolean isYflipped) {
        ControlStick cStick = ControlStickBrain.getControlStick();
        switch (cStick) {
            case JOYSTICK:
                return getCartesianMovementFromJoystick(ControlDevices.jstick, isYflipped);
            case XBOX:
                return getCartesianMovementFromThumbsticks(ControlDevices.driveXbox, isYflipped);
            default:
                return null;
        }
    }

    // Determines the cartesian movement (straight speed, strafe speed, rotation speed)
    // from the current joystick position
    public static CartesianMovement getCartesianMovementFromJoystick(Joystick jstick, boolean isYflipped) {
        JoystickPosition pos = JoystickPosition.getJoystickPosition(jstick, isYflipped);
        CartesianMovement move = new CartesianMovement(pos.sideToSidePosition, pos.forwardBackPosition, pos.rotationPosition);
        // Logger.info("Joystick Cartesian Movement: " + pos.sideToSidePosition + ", " + pos.forwardBackPosition + ", " + pos.rotationPosition);
        return move;
    }

    // Determines the cartesian movement (straight speed, strafe speed, rotation speed)
    // from the current xbox thumbstick positions
    public static CartesianMovement getCartesianMovementFromThumbsticks(XboxController xbox, boolean isYleftFlipped) {
        ThumbstickPosition pos = ThumbstickPosition.getThumbstickPosition(xbox, isYleftFlipped);
        CartesianMovement move = new CartesianMovement(pos.leftSideToSidePosition, pos.leftForwardBackPosition, pos.rightSideToSidePosition);
        // Logger.info("Xbox Cartesian Movement: " + pos.leftSideToSidePosition + ", " + pos.leftForwardBackPosition + ", " + pos.rightSideToSidePosition);
        return move;
    }

}

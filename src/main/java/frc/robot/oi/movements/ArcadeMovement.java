
package frc.robot.oi.movements;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.brains.ControlStickBrain;
import frc.robot.oi.positions.JoystickPosition;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.ControlDevices;
import frc.robot.oi.ControlDevices.ControlStick;

// The values needed to drive using arcade mode
public class ArcadeMovement {

    public double straightSpeed = 0; // x Forward & Backward
    public double rotationSpeed = 0; // z Rotate
    public double strafeSpeed = 0; // y Side to Side

    public ArcadeMovement() {
    }

    public ArcadeMovement(double xStraightSpeed, double zRotationSpeed, double yStrafeSpeed) {
        straightSpeed = xStraightSpeed;
        rotationSpeed = zRotationSpeed;
        strafeSpeed = yStrafeSpeed;
    }

    // Determines the arcade movement (forward/backward speed, rotation speed, square inputs)
    // from the active control stick position(s)
    public static ArcadeMovement getArcadeMovement(boolean isYflipped) {
        ControlStick cStick = ControlStickBrain.getControlStick();
        switch (cStick) {
            case JOYSTICK:
                return getArcadeMovementFromJoystick(ControlDevices.jstick, isYflipped);
            case XBOX:
                return getArcadeMovementFromThumbsticks(ControlDevices.driveXbox, isYflipped);
            default:
                return null;
        }
    }

    // Determines the arcade movement (straight speed, rotation speed, square inputs, strafe speed)
    // from the current joystick position
    public static ArcadeMovement getArcadeMovementFromJoystick(Joystick jstick, boolean isYflipped) {
        JoystickPosition pos = JoystickPosition.getJoystickPosition(ControlDevices.jstick, isYflipped);
        ArcadeMovement move = new ArcadeMovement(pos.forwardBackPosition, pos.rotationPosition, pos.sideToSidePosition);
        // Logger.info("Joystick Arcade Movement: " + pos.forwardBackPosition + ", " + pos.rotationPosition + ", " + pos.sideToSidePosition);
        return move;
    }

    // Determines the arcade movement (straight speed, rotation speed, square inputs, strafe speed)
    // from the current xbox thumbstick positions
    public static ArcadeMovement getArcadeMovementFromThumbsticks(XboxController xbox, boolean isYleftFlipped) {
        ThumbstickPosition pos = ThumbstickPosition.getThumbstickPosition(ControlDevices.driveXbox, isYleftFlipped);
        ArcadeMovement move = new ArcadeMovement(pos.leftForwardBackPosition, pos.leftSideToSidePosition, pos.rightSideToSidePosition);
        // Logger.info("Xbox Arcade Movement: " + pos.leftForwardBackPosition + ", " + pos.leftSideToSidePosition + ", " + pos.rightSideToSidePosition);
        return move;
    }

}

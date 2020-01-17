
package frc.robot.oi.movements;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

import frc.robot.brains.ControlStickBrain;
import frc.robot.oi.positions.JoystickPosition;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.ControlDevices;
import frc.robot.oi.ControlDevices.ControlStick;

// The values (magnitude, angle, rotation) needed to drive using polar coordinates
public class PolarMovement {

    public double angleSpeed = 0;
    public double angleDegrees = 0;
    public double rotationSpeed = 0;

    public PolarMovement() {
    }

    public PolarMovement(double xStraightSpeed, double yStrafeSpeed, double zRotationSpeed) {
        angleSpeed = PolarMovement.calculateMagnitude(xStraightSpeed, yStrafeSpeed);
        angleDegrees = PolarMovement.calculateAngle(xStraightSpeed, yStrafeSpeed);
        rotationSpeed = zRotationSpeed;
    }

    public static double calculateMagnitude(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static double calculateAngle(double x, double y) {
        return Math.atan2(x, y);
    }

    // Determines the polar movement (magnitude, angle, rotation)
    // from the active control stick position(s)
    public static PolarMovement getPolarMovement(boolean isYflipped) {
        ControlStick cStick = ControlStickBrain.getControlStick();
        switch (cStick) {
            case JOYSTICK:
                return getPolarMovementFromJoystick(ControlDevices.jstick, isYflipped);
            case XBOX:
                return getPolarMovementFromThumbsticks(ControlDevices.driveXbox, isYflipped);
            default:
                return null;
        }
    }

    // Determines the polar movement (angle speed, angle degrees, rotation speed)
    // from the current joystick position
    public static PolarMovement getPolarMovementFromJoystick(Joystick jstick, boolean isYflipped) {
        JoystickPosition pos = JoystickPosition.getJoystickPosition(jstick, isYflipped);
        PolarMovement move = new PolarMovement(pos.forwardBackPosition, pos.sideToSidePosition, pos.rotationPosition);
        // Logger.info("Joystick Polar Movement: " + pos.forwardBackPosition + ", " + pos.sideToSidePosition + ", " + pos.rotationPosition);
        return move;
    }

    // Determines the polar movement (angle speed, angle degrees, rotation speed)
    // from the current xbox thumbstick positions
    public static PolarMovement getPolarMovementFromThumbsticks(XboxController xbox, boolean isYleftFlipped) {
        ThumbstickPosition pos = ThumbstickPosition.getThumbstickPosition(xbox, isYleftFlipped);
        PolarMovement move = new PolarMovement(pos.leftForwardBackPosition, pos.leftSideToSidePosition, pos.rightSideToSidePosition);
        // Logger.info("Xbox Polar Movement: " + pos.leftForwardBackPosition + ", " + pos.leftSideToSidePosition + ", " + pos.rightSideToSidePosition);
        return move;
    }

}

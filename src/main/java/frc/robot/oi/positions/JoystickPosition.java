
package frc.robot.oi.positions;

import edu.wpi.first.wpilibj.Joystick;

import frc.robot.brains.JoystickBrain;

// The position values obtained from a Joystick
public class JoystickPosition {

    public double forwardBackPosition = 0; // y Forward & Backward
    public double sideToSidePosition = 0; // x Side to Side
    public double rotationPosition = 0; // z Rotate

    public JoystickPosition() {
    }

    public JoystickPosition(double forwardBack, double sideToSide, double rotation) {
        forwardBackPosition = forwardBack;
        sideToSidePosition = sideToSide;
        rotationPosition = rotation;
    }

    // Gets the joystick position and applies user-determined orientation, deadzones, and sensitivity
    public static JoystickPosition getJoystickPosition(Joystick jstick, boolean isYflipped) {
        double y = jstick.getY(); // Forward & backward, flipped
        double x = jstick.getX(); // Side to side
        double z = jstick.getZ(); // Rotate, flipped?

        // Forward/backward and rotation directions are both reversed from what is intuitive, so flip them
        y = -y;
        z = -z; // TODO: Low priority, but check to see if this should be deleted, like we did for thumbsticks

        // User-determined flipping of forward/backward orientation
        if (isYflipped) {
            y = -y;
        }

        // Deadzones
        double yDeadZone = JoystickBrain.getYdeadZone();
        double xDeadZone = JoystickBrain.getXdeadZone();
        double zDeadZone = JoystickBrain.getZdeadZone();

        if (Math.abs(y) <= yDeadZone)
            y = 0;
        if (Math.abs(x) <= xDeadZone)
            x = 0;
        if (Math.abs(z) <= zDeadZone)
            z = 0;

        if (y > 0)
            y = y - yDeadZone;
        if (y < 0)
            y = y + yDeadZone;
        if (x > 0)
            x = x - xDeadZone;
        if (x < 0)
            x = x + xDeadZone;
        if (z > 0)
            z = z - zDeadZone;
        if (z < 0)
            z = z + zDeadZone;

        // Sensitivity
        double ySensitivity = JoystickBrain.getYsensitivity();
        double xSensitivity = JoystickBrain.getXsensitivity();
        double zSensitivity = JoystickBrain.getXsensitivity();

        y = y * ySensitivity;
        x = x * xSensitivity;
        z = z * zSensitivity;

        JoystickPosition pos = new JoystickPosition(y, x, z);
        return pos;
    }

}

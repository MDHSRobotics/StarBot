
package frc.robot.oi.controllers;

import frc.robot.oi.positions.JoystickPosition;

// Classes that implement this interface must define methods
// for obtaining xbox thumbstick and trigger axis position data.
public interface JoystickPositionAccessible {

    public JoystickPosition getJoystickPosition(boolean isYflipped);

}
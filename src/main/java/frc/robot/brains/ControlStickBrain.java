
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

import frc.robot.oi.ControlDevices.ControlStick;

// This class contains all the shared NetworkTableEntries for the Control Stick,
// their default values, and methods for retrieving their current values
public class ControlStickBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static ControlStick controlStickDefault = ControlStick.XBOX;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry controlStickEntry;

    //---------//
    // Setters //
    //---------//

    public static void setControlStick(ControlStick stick) {
        String value = stick.toString();
        controlStickEntry.setValue(value);
    }

    //---------//
    // Getters //
    //---------//

    public static ControlStick getControlStick() {
        String defaultString = controlStickDefault.toString();
        String stickString = controlStickEntry.getString(defaultString);
        return ControlStick.valueOf(stickString);
    }

}


package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Xbox Controller,
// their default values, and methods for retrieving their current values.
public class XboxBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double yLeftDeadZoneDefault = .001;
    public static double xLeftDeadZoneDefault = .001;
    public static double yRightDeadZoneDefault = .001;
    public static double xRightDeadZoneDefault = .001;
    public static double yLeftSensitivityDefault = .6;
    public static double xLeftSensitivityDefault = .6;
    public static double yRightSensitivityDefault = .6;
    public static double xRightSensitivityDefault = .6;

    //------------------//
    // Alternate Values //
    //------------------//

    public static double yLeftDeadZoneAlt = .1;
    public static double xLeftDeadZoneAlt = .1;
    public static double yRightDeadZoneAlt = .1;
    public static double xRightDeadZoneAlt = .1;
    public static double yLeftSensitivityAlt = .4;
    public static double xLeftSensitivityAlt = .4;
    public static double yRightSensitivityAlt = .4;
    public static double xRightSensitivityAlt = .4;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry yLeftDeadZoneEntry;
    public static NetworkTableEntry xLeftDeadZoneEntry;
    public static NetworkTableEntry yRightDeadZoneEntry;
    public static NetworkTableEntry xRightDeadZoneEntry;
    public static NetworkTableEntry yLeftSensitivityEntry;
    public static NetworkTableEntry xLeftSensitivityEntry;
    public static NetworkTableEntry yRightSensitivityEntry;
    public static NetworkTableEntry xRightSensitivityEntry;

    //---------//
    // Setters //
    //---------//

    //---- default setters ----//
    public static void setYleftDeadZoneDefault() {
        yLeftDeadZoneEntry.setDouble(yLeftDeadZoneDefault);
    }

    public static void setXleftDeadZoneDefault() {
        xLeftDeadZoneEntry.setDouble(xLeftDeadZoneDefault);
    }

    public static void setYrightDeadZoneDefault() {
        yRightDeadZoneEntry.setDouble(yRightDeadZoneDefault);
    }

    public static void setXrightDeadZoneDefault() {
        xRightDeadZoneEntry.setDouble(xRightDeadZoneDefault);
    }

    public static void setYleftSensitivityDefault() {
        yLeftSensitivityEntry.setDouble(yLeftSensitivityDefault);
    }

    public static void setXleftSensitivityDefault() {
        xLeftSensitivityEntry.setDouble(xLeftSensitivityDefault);
    }

    public static void setYrightSensitivityDefault() {
        yRightSensitivityEntry.setDouble(yRightSensitivityDefault);
    }

    public static void setXrightSensitivityDefault() {
        xRightSensitivityEntry.setDouble(xRightSensitivityDefault);
    }

    //---- alternate setters ----//
    public static void setYleftDeadZoneAlt() {
        yLeftDeadZoneEntry.setDouble(yLeftDeadZoneAlt);
    }

    public static void setXleftDeadZoneAlt() {
        xLeftDeadZoneEntry.setDouble(xLeftDeadZoneAlt);
    }

    public static void setYrightDeadZoneAlt() {
        yRightDeadZoneEntry.setDouble(yRightDeadZoneAlt);
    }

    public static void setXrightDeadZoneAlt() {
        xRightDeadZoneEntry.setDouble(xRightDeadZoneAlt);
    }

    public static void setYleftSensitivityAlt() {
        yLeftSensitivityEntry.setDouble(yLeftSensitivityAlt);
    }

    public static void setXleftSensitivityAlt() {
        xLeftSensitivityEntry.setDouble(xLeftSensitivityAlt);
    }

    public static void setYrightSensitivityAlt() {
        yRightSensitivityEntry.setDouble(yRightSensitivityAlt);
    }

    public static void setXrightSensitivityAlt() {
        xRightSensitivityEntry.setDouble(xRightSensitivityAlt);
    }

    //---------//
    // Getters //
    //---------//

    public static double getYleftDeadZone() {
        return yLeftDeadZoneEntry.getDouble(yLeftDeadZoneDefault);
    }

    public static double getXleftDeadZone() {
        return xLeftDeadZoneEntry.getDouble(xLeftDeadZoneDefault);
    }

    public static double getYrightDeadZone() {
        return yRightDeadZoneEntry.getDouble(yRightDeadZoneDefault);
    }

    public static double getXrightDeadZone() {
        return xRightDeadZoneEntry.getDouble(xRightDeadZoneDefault);
    }

    public static double getYleftSensitivity() {
        return yLeftSensitivityEntry.getDouble(yLeftSensitivityDefault);
    }

    public static double getXleftSensitivity() {
        return xLeftSensitivityEntry.getDouble(xLeftSensitivityDefault);
    }

    public static double getYrightSensitivity() {
        return yRightSensitivityEntry.getDouble(yRightSensitivityDefault);
    }

    public static double getXrightSensitivity() {
        return xRightSensitivityEntry.getDouble(xRightSensitivityDefault);
    }

}


package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for Line Detection,
// their default values, and methods for retrieving their current values.
public class LineDetectionBrain {

    //----------------//
    // Default Values //
    //----------------//

    // Hue, Saturation, Value
    public static double hueMinDefault = 0;
    public static double hueMaxDefault = 180;
    public static double saturationMinDefault = 0;
    public static double saturationMaxDefault = 170;
    public static double valueMinDefault = 115;
    public static double valueMaxDefault = 255;

    // Area, Angle, Position
    public static double lineAreaDefault = 0;
    public static double lineAngleDefault = 0;
    public static double lineXcenterDefault = 0;
    public static double lineYcenterDefault = 0;

    // State
    public static boolean lineDetectedDefault = false;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    // Hue, Saturation, Value
    public static NetworkTableEntry hueMinEntry;
    public static NetworkTableEntry hueMaxEntry;
    public static NetworkTableEntry saturationMinEntry;
    public static NetworkTableEntry saturationMaxEntry;
    public static NetworkTableEntry valueMinEntry;
    public static NetworkTableEntry valueMaxEntry;

    // Area, Angle, Position
    public static NetworkTableEntry lineAreaEntry;
    public static NetworkTableEntry lineAngleEntry;
    public static NetworkTableEntry lineXcenterEntry;
    public static NetworkTableEntry lineYcenterEntry;

    // State
    public static NetworkTableEntry lineDetectedEntry;

    //---------//
    // Setters //
    //---------//

    // Area, Angle, Position
    public static void setLineArea(double value) {
        lineAreaEntry.setDouble(value);
    }

    public static void setLineAngle(double value) {
        lineAngleEntry.setDouble(value);
    }

    public static void setLineXcenter(double value) {
        lineXcenterEntry.setDouble(value);
    }

    public static void setLineYcenter(double value) {
        lineYcenterEntry.setDouble(value);
    }

    //---------//
    // Getters //
    //---------//

    // Hue, Saturation, Value
    public static double getHueMin() {
        return hueMinEntry.getDouble(hueMinDefault);
    }

    public static double getHueMax() {
        return hueMaxEntry.getDouble(hueMaxDefault);
    }

    public static double getSaturationMin() {
        return saturationMinEntry.getDouble(saturationMinDefault);
    }

    public static double getSaturationMax() {
        return saturationMaxEntry.getDouble(saturationMaxDefault);
    }

    public static double getValueMin() {
        return valueMinEntry.getDouble(valueMinDefault);
    }

    public static double getValueMax() {
        return valueMaxEntry.getDouble(valueMaxDefault);
    }

    // Area, Angle, Position
    public static double getLineArea() {
        return lineAreaEntry.getDouble(lineAreaDefault);
    }

    public static double getLineAngle() {
        return lineAngleEntry.getDouble(lineAngleDefault);
    }

    public static double getLineXcenter() {
        return lineXcenterEntry.getDouble(lineXcenterDefault);
    }

    public static double getLineYcenter() {
        return lineYcenterEntry.getDouble(lineYcenterDefault);
    }

}

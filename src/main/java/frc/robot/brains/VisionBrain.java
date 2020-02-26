package frc.robot.brains;

import edu.wpi.first.networktables.*;

public class VisionBrain {

// Vision - Line Pipeline
    public static double hueMinDefault = 0;
    public static double hueMaxDefault = 180;
    public static double saturationMinDefault = 0;
    public static double saturationMaxDefault = 170;
    public static double valueMinDefault = 115;
    public static double valueMaxDefault = 255;

    // Vision - Front Line
    public static double frontLineAreaDefault = 0;
    public static double frontLineAngleDefault = 0;
    public static double frontLineXcenterDefault = 0;
    public static double frontLineYcenterDefault = 0;
    public static boolean frontLineDetectedDefault = false;

    // Vision - Line Pipeline
    public static NetworkTableEntry hueMinEntry;
    public static NetworkTableEntry hueMaxEntry;
    public static NetworkTableEntry saturationMinEntry;
    public static NetworkTableEntry saturationMaxEntry;
    public static NetworkTableEntry valueMinEntry;
    public static NetworkTableEntry valueMaxEntry;

    // Vision - Front Line
    public static NetworkTableEntry frontLineAreaEntry;
    public static NetworkTableEntry frontLineAngleEntry;
    public static NetworkTableEntry frontLineXcenterEntry;
    public static NetworkTableEntry frontLineYcenterEntry;
    public static NetworkTableEntry frontLineDetectedEntry;

    // Distance
    public static NetworkTableEntry distanceEntry;

    // Vision - Front Line
    public static void setFrontLineArea(double value) {
        frontLineAreaEntry.setDouble(value);
    }

    public static void setFrontLineAngle(double value) {
        frontLineAngleEntry.setDouble(value);
    }

    public static void setFrontLineXcenter(double value) {
        frontLineXcenterEntry.setDouble(value);
    }

    public static void setFrontLineYcenter(double value) {
        frontLineYcenterEntry.setDouble(value);
    }

    // Vision - Line Pipeline
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

    // Vision - Front Line
    public static double getFrontLineArea() {
        return frontLineAreaEntry.getDouble(frontLineAreaDefault);
    }

    public static double getFrontLineAngle() {
        return frontLineAngleEntry.getDouble(frontLineAngleDefault);
    }

    public static double getFrontLineXcenter() {
        return frontLineXcenterEntry.getDouble(frontLineXcenterDefault);
    }

    public static double getFrontLineYcenter() {
        return frontLineYcenterEntry.getDouble(frontLineYcenterDefault);
    }

}
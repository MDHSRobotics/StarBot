package frc.robot.brains;

import edu.wpi.first.networktables.*;

public class VisionAlignBrain {

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

    // Vision - Left Line
    public static double leftLineAreaDefault = 0;
    public static double leftLineAngleDefault = 0;
    public static double leftLineXcenterDefault = 0;
    public static double leftLineYcenterDefault = 0;
    public static boolean leftLineDetectedDefault = false;

    // Vision - Right Line
    public static double rightLineAreaDefault = 0;
    public static double rightLineAngleDefault = 0;
    public static double rightLineXcenterDefault = 0;
    public static double rightLineYcenterDefault = 0;
    public static boolean rightLineDetectedDefault = false;

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

    // Vision - Left Line
    public static NetworkTableEntry leftLineAreaEntry;
    public static NetworkTableEntry leftLineAngleEntry;
    public static NetworkTableEntry leftLineXcenterEntry;
    public static NetworkTableEntry leftLineYcenterEntry;
    public static NetworkTableEntry leftLineDetectedEntry;

    // Vision - Right Line
    public static NetworkTableEntry rightLineAreaEntry;
    public static NetworkTableEntry rightLineAngleEntry;
    public static NetworkTableEntry rightLineXcenterEntry;
    public static NetworkTableEntry rightLineYcenterEntry;
    public static NetworkTableEntry rightLineDetectedEntry;

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

    // Vision - Left Line
    public static void setLeftLineArea(double value) {
        leftLineAreaEntry.setDouble(value);
    }

    public static void setLeftLineAngle(double value) {
        leftLineAngleEntry.setDouble(value);
    }

    public static void setLeftLineXcenter(double value) {
        leftLineXcenterEntry.setDouble(value);
    }

    public static void setLeftLineYcenter(double value) {
        leftLineYcenterEntry.setDouble(value);
    }

    // Vision - Right Line
    public static void setRightLineArea(double value) {
        rightLineAreaEntry.setDouble(value);
    }

    public static void setRightLineAngle(double value) {
        rightLineAngleEntry.setDouble(value);
    }

    public static void setRightLineXcenter(double value) {
        rightLineXcenterEntry.setDouble(value);
    }

    public static void setRightLineYcenter(double value) {
        rightLineYcenterEntry.setDouble(value);
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

    // Vision - Left Line
    public static double getLeftLineArea() {
        return leftLineAreaEntry.getDouble(leftLineAreaDefault);
    }

    public static double getLeftLineAngle() {
        return leftLineAngleEntry.getDouble(leftLineAngleDefault);
    }

    public static double getLeftLineXcenter() {
        return leftLineXcenterEntry.getDouble(leftLineXcenterDefault);
    }

    public static double getLeftLineYcenter() {
        return leftLineYcenterEntry.getDouble(leftLineYcenterDefault);
    }

    // Vision - Right Line
    public static double getRightLineArea() {
        return rightLineAreaEntry.getDouble(rightLineAreaDefault);
    }

    public static double getRightLineAngle() {
        return rightLineAngleEntry.getDouble(rightLineAngleDefault);
    }

    public static double getRightLineXcenter() {
        return rightLineXcenterEntry.getDouble(rightLineXcenterDefault);
    }

    public static double getRightLineYcenter() {
        return rightLineYcenterEntry.getDouble(rightLineYcenterDefault);
    }

}
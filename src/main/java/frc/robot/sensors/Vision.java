package frc.robot.sensors;

import frc.robot.brains.*;

public class Vision {

    public static final int CAM_RESOLUTION_WIDTH = 320;
    public static final int CAM_RESOLUTION_HEIGHT = 240;

    private static final double MINIMUM_AREA = (CAM_RESOLUTION_HEIGHT / 3) ^ 2;

    // private static final double ANGLE_TARGET = 90;
    // private static final double ANGLE_THRESHOLD = 5;

    private static final double CENTER_X_TARGET = CAM_RESOLUTION_WIDTH / 2;
    private static final double CENTER_X_THRESHOLD = CAM_RESOLUTION_WIDTH / 64;

    public static boolean frontLineDetected() {
        double area = VisionBrain.getFrontLineArea();
        boolean detected = lineDetected(area);
        return detected;
    }

    public static boolean lineDetected(double area) {
        boolean detected = area >= MINIMUM_AREA;
        return detected;
    }

    public static boolean isFrontCentered() {
        double centerX = VisionBrain.getFrontLineXcenter();
        boolean centered = isCentered(centerX);
        return centered;
    }

    public static boolean isCentered(double centerX) {
        boolean centered = (CENTER_X_TARGET - CENTER_X_THRESHOLD <= centerX
                && centerX <= CENTER_X_TARGET + CENTER_X_THRESHOLD);
        return centered;
    }

    public static double getFrontCorrectedX() {
        double centerX = VisionBrain.getFrontLineXcenter();
        double x = getCorrectedX(centerX);
        return x;
    }

    public static double getCorrectedX(double centerX) {
        double x = CENTER_X_TARGET - centerX;
        return x;
    }

}
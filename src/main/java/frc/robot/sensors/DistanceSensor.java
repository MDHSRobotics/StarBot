
package frc.robot.sensors;

import frc.robot.brains.DistanceBrain;

public class DistanceSensor {

    private static final double TARGET_DISTANCE = 3;

    public static boolean distanceReached() {
        double distance = DistanceBrain.getDistance();
        boolean isDistancedReached = (distance == TARGET_DISTANCE);
        return isDistancedReached;
    }

}
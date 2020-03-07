
package frc.robot.sensors;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.util.Set;

import frc.robot.consoles.Logger;

// This class contains methods for retrieving Limelight data.
public class Limelight {

    private static double cameraHeight = 10.5; // height of lens (in)
    private static double targetHeight = 89.75; // height to the center of the target (in)
    private static double cameraAngle = 0; // angle of the camera (deg)

    private static NetworkTable m_limelight = NetworkTableInstance.getDefault().getTable("/limelight");
    private static NetworkTableEntry m_tx = m_limelight.getEntry("tx");
    private static NetworkTableEntry m_ty = m_limelight.getEntry("ty");
    private static NetworkTableEntry m_ta = m_limelight.getEntry("ta");

    public static double getXOffset() {
        return m_tx.getDouble(0.0);
    }

    public static double getYOffset() {
        return m_ty.getDouble(0.0);
    }

    public static double getArea() {
        return m_ta.getDouble(0.0);
    }

    public static void printKeys() {
        Set<String> keys = m_limelight.getKeys();
        int numOfKeys = keys.size();
        Logger.info("Limelight -> Number of keys: " + numOfKeys);
    }

    // 3 equals on
    public static void ledOn() {
        m_limelight.getEntry("ledMode").setNumber(3);
    }

    // 1 equals off
    public static void ledOff() {
        m_limelight.getEntry("ledMode").setNumber(1);
    }

    // Uses the limelight to find the distance in inches
    public static void calculateDistanceToTarget() {
        double yOffset = getYOffset();
        double angleInRadians = ((yOffset + cameraAngle)/180.) * Math.PI;

        double distance = (targetHeight - cameraHeight)/
                Math.tan(angleInRadians);
    }
}

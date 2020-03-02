
package frc.robot.sensors;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import java.util.Set;

import frc.robot.consoles.Logger;

// This class contains methods for retrieving Limelight data.
public class Limelight {

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

}

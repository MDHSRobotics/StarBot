
package frc.robot.brains;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

// This class contains all the shared NetworkTableEntries for the Limelight,
// its default values, and methods for retrieving its current values
public class LimelightBrain {

    // ----------------//
    // Default Values //
    // ----------------//

    public static double x = 0.0; //x offset from target, in degrees
    public static double y = 0.0; //y offset from target, in degrees

    // value from 0-100, measures target area in relation to total image area
    public static double area = 0.0;

    // ---------------------//
    // NetworkTableEntries //
    // ---------------------//

    public static NetworkTableEntry tx;
    public static NetworkTableEntry ty;
    public static NetworkTableEntry ta;

    // ---------//
    // Setters //
    // ---------//

    public static void setXOffset() {
        x = tx.getDouble(0.0);
        SmartDashboard.putNumber("LimelightX", x);
    }

    public static void setYOffset() {
        y = ty.getDouble(0.0);
        SmartDashboard.putNumber("LimelightY", y);
    }

    public static void setArea() {
        area = ta.getDouble(0.0);
        SmartDashboard.putNumber("LimelightArea", area);
    }

    // ---------//
    // Getters //
    // ---------//

    public double getXOffset() {
        return x;
    }

    public double getYOffset() {
        return y;
    }

    public double getArea() {
        return area;
    }

}

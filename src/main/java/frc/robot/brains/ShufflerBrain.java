
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;

// This class contains all the shared NetworkTableEntries for the Shuffler,
// their default values, and methods for retrieving their current values
public class ShufflerBrain {

    //----------------//
    // Default Values //
    //----------------//

    // Main Tab
    public static double matchTimeDefault = 0;

    // Drive Tab
    public static double driveTargetDistanceDefault = 2.0;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    // Main Tab
    public static NetworkTableEntry matchTimeEntry;

    // Drive Tab
    public static NetworkTableEntry driveTargetDistanceEntry;

    //---------//
    // Setters //
    //---------//

    // Main Tab
    public static void setMatchTime() {
        DriverStation ds = DriverStation.getInstance();
        double matchTime = ds.getMatchTime();
        matchTimeEntry.setDouble(matchTime);
    }

    //---------//
    // Getters //
    //---------//

    // Main Tab
    public static double getMatchTime() {
        return matchTimeEntry.getDouble(matchTimeDefault);
    }

    // Drive Tab
    public static double getTargetDriveDistance() {
        return driveTargetDistanceEntry.getDouble(driveTargetDistanceDefault);
    }

}

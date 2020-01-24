
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;


// This class contains all the shared NetworkTableEntries for the MecDriver Subsystem,
// their default values, and methods for retrieving their current values
public class DiffDriverBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double alignZSensitivityDefault = .7;
    public static double alignZSpeedMinimumDefault = .25;
    public static double alignZToleranceDefault = 10;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry alignZSensitivityEntry;
    public static NetworkTableEntry alignZSpeedMinimumEntry;
    public static NetworkTableEntry alignZToleranceEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getAlignZSensitivity() {
        return alignZSensitivityEntry.getDouble(alignZSensitivityDefault);
    }

    public static double getAlignZSpeedMinimum() {
        return alignZSpeedMinimumEntry.getDouble(alignZSpeedMinimumDefault);
    }

    public static double getAlignZTolerance() {
        return alignZToleranceEntry.getDouble(alignZToleranceDefault);
    }

}
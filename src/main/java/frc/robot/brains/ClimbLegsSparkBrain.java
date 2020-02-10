
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the ClimbLegsSpark Subsystem,
// their default values, and methods for retrieving their current values.
public class ClimbLegsSparkBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double rotationsDefault = 50;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry rotations;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getRotations() {
        return rotations.getDouble(rotationsDefault);
    }

}

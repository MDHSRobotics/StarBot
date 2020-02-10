
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Distance Sensor,
// their default values, and methods for retrieving their current values.
public class DistanceBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double distanceDefault = -1;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry distanceEntry;

    //---------//
    // Setters //
    //---------//



    //---------//
    // Getters //
    //---------//

    public static double getDistance() {
        return distanceEntry.getDouble(distanceDefault);
    }

}

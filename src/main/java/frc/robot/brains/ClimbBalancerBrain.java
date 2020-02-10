
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the ClimbBalancer Subsystem,
// their default values, and methods for retrieving their current values.
public class ClimbBalancerBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double powerDefault = 0.2;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry powerEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getPower() {
        return powerEntry.getDouble(powerDefault);
    }

}

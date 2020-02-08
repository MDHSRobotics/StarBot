
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Roller Subsystem,
// their default values, and methods for retrieving their current values
public class ClimbBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double climbRotationDefault = 50;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry climbRotation;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getClimbRotation() {
        return climbRotation.getDouble(climbRotationDefault);
    }

}

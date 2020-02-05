
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Roller Subsystem,
// their default values, and methods for retrieving their current values
public class ClimbRollerBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double climbRollerPowerDefault = 0.20;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry climbRollerPowerEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getClimbRollerPower() {
        return climbRollerPowerEntry.getDouble(climbRollerPowerDefault);
    }

}

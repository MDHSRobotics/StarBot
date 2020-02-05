
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Roller Subsystem,
// their default values, and methods for retrieving their current values
public class ClimbArmBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double climbArmPowerDefault = 0.20;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry climbArmPowerEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getClimbArmPower() {
        return climbArmPowerEntry.getDouble(climbArmPowerDefault);
    }

}

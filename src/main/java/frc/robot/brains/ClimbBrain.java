
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the ClimbBalancer Subsystem,
// their default values, and methods for retrieving their current values.
public class ClimbBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double balancerPowerDefault = 0.2;
    public static double hookPowerDefault = 0.2;
    public static double legRotationsDefault = 50;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry balancerPowerEntry;
    public static NetworkTableEntry hookPowerEntry;
    public static NetworkTableEntry legRotationsEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getBalancerPower() {
        return balancerPowerEntry.getDouble(balancerPowerDefault);
    }

    public static double getHookPower() {
        return hookPowerEntry.getDouble(hookPowerDefault);
    }

    public static double getLegRotations() {
        return legRotationsEntry.getDouble(legRotationsDefault);
    }

}

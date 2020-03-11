
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Climb Subsystems,
// their default values, and methods for retrieving their current values.
public class ClimbBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double balancerPowerDefault = 0.2;
    public static double hookPowerDefault = 0.2;
    public static double legRotationsDefault = 50;

    public static double brightnessDefault = 40;
    public static double exposureDefault = 30;
    public static double whiteBalanceDefault = 4500;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry balancerPowerEntry;
    public static NetworkTableEntry hookPowerEntry;
    public static NetworkTableEntry legRotationsEntry;

    public static NetworkTableEntry brightnessEntry;
    public static NetworkTableEntry exposureEntry;
    public static NetworkTableEntry whiteBalanceEntry;

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

    public static double getBrightness() {
        return brightnessEntry.getDouble(brightnessDefault);
    }

    public static double getExposure() {
        return exposureEntry.getDouble(exposureDefault);
    }

    public static double getWhiteBalance() {
        return whiteBalanceEntry.getDouble(whiteBalanceDefault);
    }

}

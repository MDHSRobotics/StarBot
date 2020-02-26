
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Shooter Subsystem,
// their default values, and methods for retrieving their current values.
public class ShooterBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double shootBottomWheelTargetVelocityDefault = 1;
    public static double shootTopWheelTargetVelocityDefault = 1;

    public static double shootTopWheelCurrentVelocityDefault = 0;
    public static double shootBottomWheelCurrentVelocityDefault = 0;

    public static double shootBottomWheelCurrentVelocityFPSDefault = 0;
    public static double shootTopWheelCurrentVelocityFPSDefault = 0;

    public static double shootBottomWheelMaxVelocityDefault = 0;
    public static double shootBottomWheelMinVelocityDefault = 1000000;
    public static double shootTopWheelMaxVelocityDefault = 0;
    public static double shootTopWheelMinVelocityDefault = 1000000;

    public static double shootDistanceDefault = 0;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry shootBottomWheelTargetVelocityEntry;
    public static NetworkTableEntry shootTopWheelTargetVelocityEntry;

    public static NetworkTableEntry shootBottomWheelCurrentVelocityEntry;
    public static NetworkTableEntry shootTopWheelCurrentVelocityEntry;

    public static NetworkTableEntry shootBottomWheelCurrentVelocityFPSEntry;
    public static NetworkTableEntry shootTopWheelCurrentVelocityFPSEntry;

    public static NetworkTableEntry shootBottomWheelMaxVelocityEntry;
    public static NetworkTableEntry shootBottomWheelMinVelocityEntry;
    public static NetworkTableEntry shootTopWheelMaxVelocityEntry;
    public static NetworkTableEntry shootTopWheelMinVelocityEntry;

    public static NetworkTableEntry shootDistanceEntry;

    //---------//
    // Setters //
    //---------//

    public static void setTopWheelCurrentVelocity(double value) {
        shootTopWheelCurrentVelocityEntry.setDouble(value);
    }

    public static void setBottomWheelCurrentVelocity(double value) {
        shootBottomWheelCurrentVelocityEntry.setDouble(value);
    }

    public static void setTopWheelCurrentVelocityFPS(double value) {
        shootTopWheelCurrentVelocityFPSEntry.setDouble(value);
    }

    public static void setBottomWheelCurrentVelocityFPS(double value) {
        shootBottomWheelCurrentVelocityFPSEntry.setDouble(value);
    }

    public static void setBottomWheelMaxVelocity(double value) {
        shootBottomWheelMaxVelocityEntry.setDouble(value);
    }

    public static void setBottomWheelMinVelocity(double value) {
        shootBottomWheelMinVelocityEntry.setDouble(value);
    }

    public static void setTopWheelMaxVelocity(double value) {
        shootTopWheelMaxVelocityEntry.setDouble(value);
    }

    public static void setTopWheelMinVelocity(double value) {
        shootTopWheelMinVelocityEntry.setDouble(value);
    }

    public static void setShootDistance(double value) {
        shootDistanceEntry.setDouble(value);
    }


    //---------//
    // Getters //
    //---------//

    public static double getBottomWheelVelocity() {
        return shootBottomWheelTargetVelocityEntry.getDouble(shootBottomWheelTargetVelocityDefault);
    }

    public static double getTopWheelVelocity() {
        return shootTopWheelTargetVelocityEntry.getDouble(shootTopWheelTargetVelocityDefault);
    }

}

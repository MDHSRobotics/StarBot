
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

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry shootBottomWheelTargetVelocityEntry;
    public static NetworkTableEntry shootTopWheelTargetVelocityEntry;

    public static NetworkTableEntry shootBottomWheelCurrentVelocityEntry;
    public static NetworkTableEntry shootTopWheelCurrentVelocityEntry;

    //---------//
    // Setters //
    //---------//

    public static void setTopWheelCurrentVelocity(double value) {
        shootTopWheelCurrentVelocityEntry.setDouble(value);
    }

    public static void setBottomWheelCurrentVelocity(double value) {
        shootBottomWheelCurrentVelocityEntry.setDouble(value);
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

package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Hatcher Subsystem,
// their default values, and methods for retrieving their current values
public class ShooterBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double shootTopWheelVelocityDefault = 1;
    public static double shootBottomWheelVelocityDefault = 1;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry shootTopWheelVelocityEntry;
    public static NetworkTableEntry shootBottomWheelVelocityEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getTopWheelVelocity() {
        return shootTopWheelVelocityEntry.getDouble(shootTopWheelVelocityDefault);
    }

    public static double getBottomWheelVelocity() {
        return shootBottomWheelVelocityEntry.getDouble(shootBottomWheelVelocityDefault);
    }

}
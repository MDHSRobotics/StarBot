
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;

// This class contains all the shared NetworkTableEntries for the Shooter Subsystem,
// their default values, and methods for retrieving their current values.
public class ShooterBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static double bottomWheelVelocityDefault = 1;
    public static double topWheelVelocityDefault = 1;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry bottomWheelVelocityEntry;
    public static NetworkTableEntry topWheelVelocityEntry;

    //---------//
    // Setters //
    //---------//

    //---------//
    // Getters //
    //---------//

    public static double getBottomWheelVelocity() {
        return bottomWheelVelocityEntry.getDouble(bottomWheelVelocityDefault);
    }

    public static double getTopWheelVelocity() {
        return topWheelVelocityEntry.getDouble(topWheelVelocityDefault);
    }

}

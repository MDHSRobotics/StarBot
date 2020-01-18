
package frc.robot.brains;

import edu.wpi.first.networktables.NetworkTableEntry;
import frc.robot.commands.rollerarm.LogRollerArmCurrent;
import frc.robot.subsystems.Roller;
import frc.robot.subsystems.RollerArm;
import frc.robot.SubsystemDevices;

// This class contains all the shared NetworkTableEntries for the RollerArm Subsystem,
// their default values, and methods for retrieving their current values
public class RollerArmBrain {

    //----------------//
    // Default Values //
    //----------------//

    public static boolean compressorState = false;

    //---------------------//
    // NetworkTableEntries //
    //---------------------//

    public static NetworkTableEntry compressorStateEntry;

    //---------//
    // Setters //
    //---------//

    public static void setCompressorState(Boolean value) {
        compressorStateEntry.setBoolean(value);
    }

    //---------//
    // Getters //
    //---------//

    public boolean getCompressorState() {
        return compressorStateEntry.getBoolean(compressorState);
    }

}

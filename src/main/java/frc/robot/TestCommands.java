
package frc.robot;

import frc.robot.commands.diffdriver.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the test commands on the robot.
public class TestCommands {

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static DriveDiffTank driveDiffTank;

    // Initialize all test commands
    public static void initializeCommands() {
        Logger.setup("Initializing TestCommands...");

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver, VirtualControllers.primary.xbox);
        driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, VirtualControllers.primary);
    }

}

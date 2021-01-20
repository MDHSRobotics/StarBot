
package frc.robot;
import frc.robot.commands.diffdriver.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the test commands on the robot.
public class TestCommands {

    // DiffDriver
    public static RotateToDpadDirection rotateToDpadDirection;
    public static DriveDiffTank driveDiffTank;

    // Initialize all test commands
    public static void initializeCommands() {
        Logger.setup("Initializing TestCommands...");

        // DiffDriver
        rotateToDpadDirection = new RotateToDpadDirection(BotSubsystems.diffDriver, VirtualControllers.primary.xbox);

    }

}

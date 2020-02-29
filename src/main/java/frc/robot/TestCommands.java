
package frc.robot;

//import frc.robot.commands.climb.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the test commands on the robot.
public class TestCommands {

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static DriveDiffTank driveDiffTank;

    // Climb
    // public static HookForward hookForward;
    // public static HookReverse hookReverse;
    // public static LiftRobot liftRobot;
    // public static LowerRobot lowerRobot;
    // public static RollerForward rollerForward;
    // public static RollerReverse rollerReverse;
    // public static StandStop standStop;
    // public static ToggleHook toggleHook;
    // public static ToggleLegs toggleLegs;

    // Initialize all test commands
    public static void initializeCommands() {
        Logger.setup("Initializing TestCommands...");

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver, VirtualControllers.primary.xbox);
        //driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, VirtualControllers.primary);
    }

}

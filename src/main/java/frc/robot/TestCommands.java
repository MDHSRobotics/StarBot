
package frc.robot;

//import frc.robot.commands.climb.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.roller.SpinRoller;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the test commands on the robot.
public class TestCommands {

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static CenterDiffDriveOnTarget centerDiffDriveOnTarget;
    public static DriveDiffArcade driveDiffArcade;
    public static DriveDiffTank driveDiffTank;

    //Roller
    public static SpinRoller spinRoller;

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
        centerDiffDriveOnTarget = new CenterDiffDriveOnTarget(BotSubsystems.diffDriver);
        // TODO: Change this to driveDiffArcade
        //driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, VirtualControllers.primary);

        //Roller
        spinRoller = new SpinRoller(BotSubsystems.roller, BotSubsystems.conveyor);
    }

}

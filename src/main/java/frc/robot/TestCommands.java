
package frc.robot;

import frc.robot.commands.diffdriver.*;
import frc.robot.commands.roller.*;
import frc.robot.commands.rollerarm.*;

import frc.robot.consoles.Logger;

// Contains singleton instances of all the test commands on the robot.
public class TestCommands {

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static CenterDiffDriveOnTarget centerDiffDriveOnTarget;
    public static DriveDiffTank driveDiffTank;

    // Roller
    public static SpinRoller spinRoller;
    public static StopRoller stopRoller;

    // RollerArm
    public static LowerRollerArm lowerRollerArm;

    // Initialize all test commands
    public static void initializeCommands() {
        Logger.setup("Initializing TestCommands...");

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver, VirtualControllers.primary.xbox);
        centerDiffDriveOnTarget = new CenterDiffDriveOnTarget(BotSubsystems.diffDriver);
        driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, VirtualControllers.primary);

        // Roller
        spinRoller = new SpinRoller(BotSubsystems.roller, BotSubsystems.conveyor);
        stopRoller = new StopRoller(BotSubsystems.roller);

        // RollerArm
        lowerRollerArm = new LowerRollerArm(BotSubsystems.rollerArm);
    }

}

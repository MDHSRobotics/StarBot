
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.auto.*;
import frc.robot.commands.climb.*;
import frc.robot.commands.conveyor.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.lighter.*;
import frc.robot.commands.roller.*;
import frc.robot.commands.rollerarm.*;
import frc.robot.commands.shooter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Autonomous
    public static AutoDriveForward autoDriveForward;
    public static AutoDriveForwardShoot autoDriveForwardShoot;

    // Climb
    public static StandStop standStop;

    // Climb Hook
    public static HookForward hookForward;
    public static HookReverse hookReverse;
    public static ToggleHook toggleHook;

    // Climb Legs
    public static LiftRobot liftRobot;
    public static LowerRobot lowerRobot;
    public static ToggleLegs toggleLegs;

    // Climb Roller
    public static RollerForward rollerForward;
    public static RollerReverse rollerReverse;

    // Conveyor
    public static ForwardConveyor forwardConveyor;
    public static ReverseConveyor reverseConveyor;
    public static StopConveyor stopConveyor;

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static DriveDiffTank driveDiffTank;

    // Lighter
    public static TestCycleLights testCycleLights;

    // Roller
    public static SpinRoller spinRoller;
    public static StopRoller stopRoller;

    // RollerArm
    public static LowerRollerArm lowerRollerArm;
    public static RaiseRollerArm raiseRollerArm;
    public static ToggleRollerArm toggleRollerArm;

    // Shooter
    public static Shoot shoot;
    public static StopShooter stopShooter;
    public static ReverseConveyorAndShoot reverseConveyorAndShoot;
    public static StopConveyorAndShooter stopConveyorAndShooter;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        autoDriveForward = new AutoDriveForward(BotSubsystems.diffDriver);
        autoDriveForwardShoot = new AutoDriveForwardShoot(BotSubsystems.diffDriver);

        // Climb
        standStop = new StandStop(BotSubsystems.climb);

        // Climb Hook
        hookForward = new HookForward(BotSubsystems.climb);
        hookReverse = new HookReverse(BotSubsystems.climb);
        toggleHook = new ToggleHook(BotSubsystems.climb);

        // Climb Legs
        liftRobot = new LiftRobot(BotSubsystems.climb);
        lowerRobot = new LowerRobot(BotSubsystems.climb);
        toggleLegs = new ToggleLegs(BotSubsystems.climb);

        // Climb Roller
        rollerForward = new RollerForward(BotSubsystems.climb);
        rollerReverse = new RollerReverse(BotSubsystems.climb);

        // Conveyor
        forwardConveyor = new ForwardConveyor(BotSubsystems.conveyor);
        reverseConveyor = new ReverseConveyor(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver);
        driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver);

        // Lighter
        testCycleLights = new TestCycleLights(BotSubsystems.lighter);

        // Roller
        spinRoller = new SpinRoller(BotSubsystems.roller, BotSubsystems.conveyor);
        stopRoller = new StopRoller(BotSubsystems.roller);

        // RollerArm
        lowerRollerArm = new LowerRollerArm(BotSubsystems.rollerArm);
        raiseRollerArm = new RaiseRollerArm(BotSubsystems.rollerArm);
        toggleRollerArm = new ToggleRollerArm(BotSubsystems.rollerArm);

        // Shooter
        shoot = new Shoot(BotSubsystems.shooter, BotSubsystems.conveyor);
        stopShooter = new StopShooter(BotSubsystems.shooter);
        reverseConveyorAndShoot = new ReverseConveyorAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);
        stopConveyorAndShooter = new StopConveyorAndShooter(BotSubsystems.conveyor, BotSubsystems.shooter);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return autoDriveForward;
        //return autoDriveForwardShoot;
    }

}

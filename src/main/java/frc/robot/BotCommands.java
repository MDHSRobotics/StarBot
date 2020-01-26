
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
    public static Convey convey;

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static DriveDifferentialTank driveDifferentialTank;

    // Lighter
    public static CycleLights cycleLights;

    // Roller
    public static SpinRoller rollerSpin;
    public static StopRoller rollerStop;

    // RollerArm
    public static LowerRollerArm lowerRollerArm;
    public static RaiseRollerArm raiseRollerArm;
    public static ToggleRollerArm toggleRollerArm;

    // Shooter
    public static Shoot shoot;
    public static StopShoot stopShoot;

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
        convey = new Convey(BotSubsystems.conveyor);

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver);
        driveDifferentialTank = new DriveDifferentialTank(BotSubsystems.diffDriver);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Roller
        rollerSpin = new SpinRoller(BotSubsystems.roller);
        rollerStop = new StopRoller(BotSubsystems.roller);

        // RollerArm
        lowerRollerArm = new LowerRollerArm(BotSubsystems.rollerArm);
        raiseRollerArm = new RaiseRollerArm(BotSubsystems.rollerArm);
        toggleRollerArm = new ToggleRollerArm(BotSubsystems.rollerArm);

        // Shooter
        shoot = new Shoot(BotSubsystems.shooter);
        stopShoot = new StopShoot(BotSubsystems.shooter);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return autoDriveForward;
        //return autoDriveForwardShoot;
    }

}


package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.auto.*;
import frc.robot.commands.sparkmaxclimb.*;
import frc.robot.commands.climbarm.*;
import frc.robot.commands.climbroller.RollerForward;
import frc.robot.commands.climbroller.RollerReverse;
import frc.robot.commands.climbroller.StopClimbRoller;
import frc.robot.commands.conveyor.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.lighter.*;
import frc.robot.commands.redlineclimb.LowerClimb;
import frc.robot.commands.redlineclimb.RaiseClimb;
import frc.robot.commands.redlineclimb.ToggleClimb;
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

    // Climb Arm
    public static TurnArm turnArm;
    public static RetractArm retractArm;
    public static ToggleClimbArm toggleClimbArm;
    public static StopClimbArm stopClimbArm;

    // Climb Roller
    public static RollerForward rollerForward;
    public static RollerReverse rollerReverse;
    public static StopClimbRoller stopClimbRoller;

    // RedLineClimb Legs
    public static RaiseClimb raiseClimb;
    public static LowerClimb lowerClimb;
    public static ToggleClimb toggleClimb;

    // SparkMaxClimb Legs
    public static LiftRobot liftRobot;
    public static LowerRobot lowerRobot;
    public static ToggleLegs toggleLegs;

    // Conveyor
    public static ForwardConveyor forwardConveyor;
    public static ReverseConveyor reverseConveyor;
    public static StopConveyor stopConveyor;

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static CenterDiffDriveOnTarget centerDiffDriveOnTarget;
    public static DriveDiffTank driveDiffTank;

    // Lighter
    public static CycleLights cycleLights;

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
        standStop = new StandStop(BotSubsystems.sparkMaxClimb);

        // Climb Arm
        turnArm = new TurnArm(BotSubsystems.climbArm);
        retractArm = new RetractArm(BotSubsystems.climbArm);
        toggleClimbArm = new ToggleClimbArm(BotSubsystems.climbArm);
        stopClimbArm = new StopClimbArm(BotSubsystems.climbArm);

        // Climb Roller
        rollerForward = new RollerForward(BotSubsystems.climbRoller);
        rollerReverse = new RollerReverse(BotSubsystems.climbRoller);
        stopClimbRoller = new StopClimbRoller(BotSubsystems.climbRoller);

        // RedLineClimb Legs
        raiseClimb = new RaiseClimb(BotSubsystems.redLineClimb);
        lowerClimb = new LowerClimb(BotSubsystems.redLineClimb);
        toggleClimb = new ToggleClimb(BotSubsystems.redLineClimb);

        // SparkMaxClimb Legs
        liftRobot = new LiftRobot(BotSubsystems.sparkMaxClimb);
        lowerRobot = new LowerRobot(BotSubsystems.sparkMaxClimb);
        toggleLegs = new ToggleLegs(BotSubsystems.sparkMaxClimb);

        // Conveyor
        forwardConveyor = new ForwardConveyor(BotSubsystems.conveyor);
        reverseConveyor = new ReverseConveyor(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver, BotControllers.primary.xbox);
        driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, BotControllers.primary);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

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

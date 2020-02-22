
package frc.robot;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.auto.*;
import frc.robot.commands.climbbalancer.*;
import frc.robot.commands.climbhook.*;
//import frc.robot.commands.climblegs.*;
import frc.robot.commands.climblegsred.*;
import frc.robot.commands.climblegsspark.*;
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
    public static AutoDriveToTarget firstAutoDriveToTarget;
    public static AutoDriveToTarget secondAutoDriveToTarget;
    public static AutoLineUpAndShoot autoLineUpAndShoot;
    public static AutoRotate autoRotate;
    public static AutoWait autoWait;

    // Climb Balancer
    public static BalanceLeft balanceLeft;
    public static BalanceRight balanceRight;
    public static StopBalancer stopBalancer;

    // Climb Hook
    public static MoveHookBackward moveHookBackward;
    public static MoveHookForward moveHookForward;
    public static StopHook stopHook;
    public static ToggleHook toggleHook;

    // Climb Legs Red
    public static ExtendRedLegs extendRedLegs;
    public static RetractRedLegs retractRedLegs;
    public static ToggleRedLegs toggleRedLegs;

    // Climb Legs Spark
    public static ExtendSparkLegs extendSparkLegs;
    public static RetractSparkLegs retractSparkLegs;
    public static StopSparkLegs stopSparkLegs;
    public static ToggleSparkLegs toggleSparkLegs;

    // Conveyor
    public static ForwardConveyor forwardConveyor;
    public static ReverseConveyor reverseConveyor;
    public static ReverseConveyorCG reverseConveyorCG;
    public static StopConveyor stopConveyor;
    public static StopConveyorCG stopConveyorCG;

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static AlignDiffDriveToGyroCG alignDiffDriveToGyroCG;
    public static AlignDiffDriveToTarget alignDiffDriveToTarget;
    public static CenterDiffDriveOnTargetCG centerDiffDriveOnTargetCG;
    public static DriveDiffTank driveDiffTank;
    public static DriveDiffToWithinRange driveDiffToWithinRangeFront;
    public static DriveDiffToWithinRange driveDiffToWithinRangeTop;
    public static DriveDiffTankCG driveDiffTankCG;

    // DiffDriverAlternate
    public static StopDiffDrive stopDiffDrive;

    // Lighter
    public static CycleLights cycleLights;

    // Roller
    public static SpinRollerAndConveyor spinRollerAndConveyor;
    public static StopRoller stopRoller;

    // RollerArm
    public static LowerRollerArm lowerRollerArm;
    public static RaiseRollerArm raiseRollerArm;
    public static ToggleRollerArm toggleRollerArm;

    // Shooter
    public static ConveyAndShoot conveyAndShoot;
    public static ResetShoot resetShoot;
    public static ReverseConveyorAndShoot reverseConveyorAndShoot;
    public static Shoot shoot;
    public static ShootCG shootCG;
    public static StopConveyorAndShooter stopConveyorAndShooter;
    public static StopShooter stopShooter;
    public static StopShooterCG stopShooterCG;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        autoDriveForward = new AutoDriveForward(BotSubsystems.diffDriver);
        firstAutoDriveToTarget = new AutoDriveToTarget(BotSubsystems.diffDriver, 1.0, 1.5);
        autoRotate = new AutoRotate(BotSubsystems.diffDriver);
        secondAutoDriveToTarget = new AutoDriveToTarget(BotSubsystems.diffDriver, 0.5, 1.0);
        autoLineUpAndShoot = new AutoLineUpAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter, BotSubsystems.diffDriver);
        autoWait = new AutoWait();

        // Climb Balancer
        balanceRight = new BalanceRight(BotSubsystems.climbBalancer);
        balanceLeft = new BalanceLeft(BotSubsystems.climbBalancer);
        stopBalancer = new StopBalancer(BotSubsystems.climbBalancer);

        // Climb Hook
        moveHookBackward = new MoveHookBackward(BotSubsystems.climbHook);
        moveHookForward = new MoveHookForward(BotSubsystems.climbHook);
        toggleHook = new ToggleHook(BotSubsystems.climbHook);
        stopHook = new StopHook(BotSubsystems.climbHook);

        // Climb Legs Red
        extendRedLegs = new ExtendRedLegs(BotSubsystems.climbLegsRed);
        retractRedLegs = new RetractRedLegs(BotSubsystems.climbLegsRed);
        toggleRedLegs = new ToggleRedLegs(BotSubsystems.climbLegsRed);

        // Climb Legs Spark
        extendSparkLegs = new ExtendSparkLegs(BotSubsystems.climbLegsSpark);
        retractSparkLegs = new RetractSparkLegs(BotSubsystems.climbLegsSpark);
        stopSparkLegs = new StopSparkLegs(BotSubsystems.climbLegsSpark);
        toggleSparkLegs = new ToggleSparkLegs(BotSubsystems.climbLegsSpark);

        // Conveyor
        forwardConveyor = new ForwardConveyor(BotSubsystems.conveyor);
        reverseConveyor = new ReverseConveyor(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);
        stopConveyorCG = new StopConveyorCG(BotSubsystems.conveyor);

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver, BotControllers.primary.xbox);
        alignDiffDriveToTarget = new AlignDiffDriveToTarget(BotSubsystems.diffDriver);
        driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, BotControllers.primary);
        driveDiffToWithinRangeFront = new DriveDiffToWithinRange(BotSubsystems.diffDriver, BotSensors.distanceSensorFront, 2, 3);
        driveDiffToWithinRangeTop = new DriveDiffToWithinRange(BotSubsystems.diffDriver, BotSensors.distanceSensorTop, 2, 3);

        // DiffDriverAlternate
        stopDiffDrive = new StopDiffDrive(BotSubsystems.diffDriverAlternate);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Roller
        spinRollerAndConveyor = new SpinRollerAndConveyor(BotSubsystems.roller, BotSubsystems.conveyor);
        stopRoller = new StopRoller(BotSubsystems.roller);

        // RollerArm
        lowerRollerArm = new LowerRollerArm(BotSubsystems.rollerArm);
        raiseRollerArm = new RaiseRollerArm(BotSubsystems.rollerArm);
        toggleRollerArm = new ToggleRollerArm(BotSubsystems.rollerArm);

        // Shooter
        conveyAndShoot = new ConveyAndShoot(BotSubsystems.shooter, BotSubsystems.conveyor);
        resetShoot = new ResetShoot(BotSubsystems.shooter);
        reverseConveyorAndShoot = new ReverseConveyorAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);
        shoot = new Shoot(BotSubsystems.shooter);
        stopConveyorAndShooter = new StopConveyorAndShooter(BotSubsystems.conveyor, BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);
        stopShooterCG = new StopShooterCG(BotSubsystems.shooter);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return autoDriveForward;
        //return autoDriveForwardShoot;
    }

}


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
    public static AutoDriveForward autoDriveForwardS1;
    public static AutoDriveForward autoDriveForwardS2;
    public static AutoDriveFromWall autoDriveFromWallS1;
    public static AutoDriveFromWall autoDriveFromWallS2;
    public static AutoDriveFromPickUp autoDriveFromPickUpS1;
    public static AutoDriveFromPickUp autoDriveFromPickUpS2;
    public static AutoDriveToPickUp autoDriveToPickUpS1;
    public static AutoDriveToPickUp autoDriveToPickUpS2;
    public static AutoDriveToWall autoDriveToWallS1;
    public static AutoDriveToWall autoDriveToWallS2;
    public static AutoLineUpAndShootS1 autoLineUpAndShootS1; // Red target, robot face field
    public static AutoLineUpAndShootS2 autoLineUpAndShootS2; // Blue target, robot face field
    public static AutoRotateLeft autoRotateLeftS1;
    public static AutoRotateLeft autoRotateLeftS2;
    public static AutoRotateRight autoRotateRightS1;
    public static AutoRotateRight autoRotateRightS2;
    public static AutoWait autoWaitS1;
    public static AutoWait autoWaitS2;


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
    public static ReverseConveyorCG reverseConveyorCGS1;
    public static ReverseConveyorCG reverseConveyorCGS2;
    public static StopConveyor stopConveyor;
    public static StopConveyorCG stopConveyorCGS1;
    public static StopConveyorCG stopConveyorCGS2;

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
    public static SpinRollerAndConveyorCG spinRollerAndConveyorCG;
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
    public static ShootCG shootCGS1;
    public static ShootCG shootCGS2;
    public static StopConveyorAndShooter stopConveyorAndShooter;
    public static StopShooter stopShooter;
    public static StopShooterCG stopShooterCGS1;
    public static StopShooterCG stopShooterCGS2;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        autoDriveForwardS1 = new AutoDriveForward(BotSubsystems.diffDriver);
        autoDriveForwardS2 = new AutoDriveForward(BotSubsystems.diffDriver);
        autoRotateLeftS1 = new AutoRotateLeft(BotSubsystems.diffDriver);
        autoRotateLeftS2 = new AutoRotateLeft(BotSubsystems.diffDriver);
        firstAutoDriveToTargetS1 = new AutoDriveToWall(BotSubsystems.diffDriver, 1.0, 1.5);
        firstAutoDriveToTargetS2 = new AutoDriveToWall(BotSubsystems.diffDriver, 1.0, 1.5);
        autoRotateRightS1 = new AutoRotateRight(BotSubsystems.diffDriver);
        autoRotateRightS2 = new AutoRotateRight(BotSubsystems.diffDriver);
        secondAutoDriveToTargetS1 = new AutoDriveToWall(BotSubsystems.diffDriver, 0.5, 1.0);
        secondAutoDriveToTargetS2 = new AutoDriveToWall(BotSubsystems.diffDriver, 0.5, 1.0);
        autoWaitS1 = new AutoWait();
        autoWaitS2 = new AutoWait();
        autoDriveToPickUp = new AutoDriveToPickUp(BotSubsystems.diffDriver);
        autoDriveToShoot = new AutoDriveToShoot(BotSubsystems.diffDriver);

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
        reverseConveyorCGS1 = new ReverseConveyorCG(BotSubsystems.conveyor);
        reverseConveyorCGS2 = new ReverseConveyorCG(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);
        stopConveyorCGS1 = new StopConveyorCG(BotSubsystems.conveyor);
        stopConveyorCGS2 = new StopConveyorCG(BotSubsystems.conveyor);

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
        spinRollerAndConveyorCG = new SpinRollerAndConveyorCG(BotSubsystems.roller, BotSubsystems.conveyor);
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
        shootCGS1 = new ShootCG(BotSubsystems.shooter);
        shootCGS2 = new ShootCG(BotSubsystems.shooter);
        stopConveyorAndShooter = new StopConveyorAndShooter(BotSubsystems.conveyor, BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);
        stopShooterCGS1 = new StopShooterCG(BotSubsystems.shooter);
        stopShooterCGS2 = new StopShooterCG(BotSubsystems.shooter);

        // Autonomous Command Group
        autoLineUpAndShootS1 = new AutoLineUpAndShootS1(BotSubsystems.conveyor, BotSubsystems.shooter, BotSubsystems.diffDriver);
        autoLineUpAndShootS2 = new AutoLineUpAndShootS2(BotSubsystems.conveyor, BotSubsystems.shooter, BotSubsystems.diffDriver);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return autoLineUpAndShootS1;
        //return autoLineUpAndShootS2;
        //return autoDriveForwardShoot;
    }

}

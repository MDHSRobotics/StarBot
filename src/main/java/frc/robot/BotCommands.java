
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
    public static AutoAlign firstAutoAlignS1;
    public static AutoAlign secondAutoAlignS1;
    public static AutoAlign autoAlignS2;
    public static AutoDriveAndPickUp autoDriveAndPickUp;
    public static AutoDriveForward autoDriveForwardS1;
    public static AutoDriveForward autoDriveForwardS2;
    public static AutoDriveFromPickUp autoDriveFromPickUp;
    public static AutoDriveToPickUp autoDriveToPickUp;
    public static AutoDriveToShoot autoDriveToShoot;
    public static AutoLineUpAndShootS1 autoLineUpAndShootS1; // Advanced
    public static AutoLineUpAndShootS2 autoLineUpAndShootS2; // Basic
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
    public static ForwardConveyorCG forwardConveyorCG;
    public static ReverseConveyor reverseConveyor;
    public static ReverseConveyorCG firstReverseConveyorCGS1;
    public static ReverseConveyorCG secondReverseConveyorCGS1;
    public static ReverseConveyorCG reverseConveyorCGS2;
    public static StopConveyor stopConveyor;
    public static StopConveyorCG firstStopConveyorCGS1;
    public static StopConveyorCG secondStopConveyorCGS1;
    public static StopConveyorCG stopConveyorwithRollerCGS1;
    public static StopConveyorCG stopConveyorCGS2;

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static AlignDiffDriveToTarget alignDiffDriveToTarget;
    public static DriveDiffTank driveDiffTank;
    public static DriveDiffToWithinRange driveDiffToWithinRangeFront;
    public static DriveDiffToWithinRange driveDiffToWithinRangeTop;

    // DiffDriverAlternate
    public static StopDiffDrive stopDiffDrive;

    // Lighter
    public static CycleLights cycleLights;

    // Roller
    public static SpinRoller spinRoller;
    public static SpinRollerCG spinRollerCG;
    public static SpinRollerAndConveyor spinRollerAndConveyor;
    public static StopRoller stopRoller;
    public static StopRollerCG stopRollerCG;

    // RollerArm
    public static LowerRollerArm lowerRollerArm;
    public static RaiseRollerArm raiseRollerArm;
    public static ToggleRollerArm toggleRollerArm;

    // Shooter
    public static ConveyAndShoot conveyAndShoot;
    public static ResetShoot resetShoot;
    public static ReverseConveyorAndShoot reverseConveyorAndShoot;
    public static Shoot shoot;
    public static ShootCG firstShootCGS1;
    public static ShootCG secondShootCGS1;
    public static ShootCG shootCGS2;
    public static StopConveyorAndShooter stopConveyorAndShooter;
    public static StopShooter stopShooter;
    public static StopShooterCG firstStopShooterCGS1;
    public static StopShooterCG secondStopShooterCGS1;
    public static StopShooterCG stopShooterCGS2;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        firstAutoAlignS1 = new AutoAlign(BotSubsystems.diffDriver);
        secondAutoAlignS1 = new AutoAlign(BotSubsystems.diffDriver);
        autoAlignS2 = new AutoAlign(BotSubsystems.diffDriver);
        autoDriveForwardS1 = new AutoDriveForward(BotSubsystems.diffDriver);
        autoDriveForwardS2 = new AutoDriveForward(BotSubsystems.diffDriver);
        autoDriveFromPickUp = new AutoDriveFromPickUp(BotSubsystems.diffDriver);
        autoDriveToPickUp = new AutoDriveToPickUp(BotSubsystems.diffDriver);
        autoDriveToShoot = new AutoDriveToShoot(BotSubsystems.diffDriver);
        autoRotateLeftS1 = new AutoRotateLeft(BotSubsystems.diffDriver);
        autoRotateLeftS2 = new AutoRotateLeft(BotSubsystems.diffDriver);
        autoRotateRightS1 = new AutoRotateRight(BotSubsystems.diffDriver);
        autoRotateRightS2 = new AutoRotateRight(BotSubsystems.diffDriver);
        autoWaitS1 = new AutoWait();
        autoWaitS2 = new AutoWait();

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
        forwardConveyorCG = new ForwardConveyorCG(BotSubsystems.conveyor);
        reverseConveyor = new ReverseConveyor(BotSubsystems.conveyor);
        firstReverseConveyorCGS1 = new ReverseConveyorCG(BotSubsystems.conveyor);
        secondReverseConveyorCGS1 = new ReverseConveyorCG(BotSubsystems.conveyor);
        stopConveyorwithRollerCGS1 = new StopConveyorCG(BotSubsystems.conveyor);
        reverseConveyorCGS2 = new ReverseConveyorCG(BotSubsystems.conveyor);
        stopConveyor = new StopConveyor(BotSubsystems.conveyor);
        firstStopConveyorCGS1 = new StopConveyorCG(BotSubsystems.conveyor);
        secondStopConveyorCGS1 = new StopConveyorCG(BotSubsystems.conveyor);
        stopConveyorwithRollerCGS1 = new StopConveyorCG(BotSubsystems.conveyor);
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
        spinRoller = new SpinRoller(BotSubsystems.roller);
        spinRollerCG = new SpinRollerCG(BotSubsystems.roller);
        stopRoller = new StopRoller(BotSubsystems.roller);
        stopRollerCG = new StopRollerCG(BotSubsystems.roller);

        // RollerArm
        lowerRollerArm = new LowerRollerArm(BotSubsystems.rollerArm);
        raiseRollerArm = new RaiseRollerArm(BotSubsystems.rollerArm);
        toggleRollerArm = new ToggleRollerArm(BotSubsystems.rollerArm);

        // Shooter
        conveyAndShoot = new ConveyAndShoot(BotSubsystems.shooter, BotSubsystems.conveyor);
        resetShoot = new ResetShoot(BotSubsystems.shooter);
        reverseConveyorAndShoot = new ReverseConveyorAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);
        shoot = new Shoot(BotSubsystems.shooter);
        firstShootCGS1 = new ShootCG(BotSubsystems.shooter);
        secondShootCGS1 = new ShootCG(BotSubsystems.shooter);
        shootCGS2 = new ShootCG(BotSubsystems.shooter);
        stopConveyorAndShooter = new StopConveyorAndShooter(BotSubsystems.conveyor, BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);
        firstStopShooterCGS1 = new StopShooterCG(BotSubsystems.shooter);
        secondStopShooterCGS1 = new StopShooterCG(BotSubsystems.shooter);
        stopShooterCGS2 = new StopShooterCG(BotSubsystems.shooter);

        // Autonomous Command Group
        autoDriveAndPickUp = new AutoDriveAndPickUp(BotSubsystems.conveyor, BotSubsystems.diffDriver, BotSubsystems.roller);
        autoLineUpAndShootS1 = new AutoLineUpAndShootS1(BotSubsystems.conveyor, BotSubsystems.shooter, BotSubsystems.diffDriver);
        autoLineUpAndShootS2 = new AutoLineUpAndShootS2(BotSubsystems.conveyor, BotSubsystems.shooter, BotSubsystems.diffDriver);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return autoLineUpAndShootS1;
        //return autoLineUpAndShootS2;
    }

}


package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.auto.*;
import frc.robot.commands.climbbalancer.*;
import frc.robot.commands.climbhook.*;
import frc.robot.commands.climblegs.*;
import frc.robot.commands.conveyor.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.lighter.*;
import frc.robot.commands.roller.*;
import frc.robot.commands.rollerarm.*;
import frc.robot.commands.sensors.*;
import frc.robot.commands.shooter.*;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbBalancer.BalanceDirection;
import frc.robot.subsystems.ClimbHook.HookPosition;
import frc.robot.subsystems.Conveyor.ConveyorDirection;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Autonomous
    public static AutoDriveToPickUp autoDriveToPickUp;
    public static AutoLineUpAndShootS1 autoLineUpAndShootS1; // Advanced
    public static AutoLineUpAndShootS2 autoLineUpAndShootS2; // Basic
    public static AutoRotateLeft autoRotateLeftS1;
    public static AutoRotateLeft autoRotateLeftS2;
    public static AutoRotateRight autoRotateRightS1;
    public static AutoRotateRight autoRotateRightS2;

    // Climb Balancer
    public static Balance balanceRight;
    public static Balance balanceLeft;
    public static StopBalancer stopBalancer;

    // Climb Hook
    public static ChangeHookPosition extendHook;
    public static ChangeHookPosition retractHook;
    public static ChangeHookPosition aimHook;
    public static StopHook stopHook;
    public static ToggleHook toggleHook;

    // Climb Legs
    public static ExtendLegs extendLegs;
    public static RetractLegs retractLegs;
    public static StopLegs stopLegs;
    public static ToggleLegs toggleLegs;

    // Conveyor
    public static SpinConveyor spinConveyorForward;
    public static SpinConveyor spinConveyorBackward;
    public static SpinConveyor spinConveyorBackwardBurst;
    public static StopConveyor stopConveyor;
    public static SpinConveyorCG firstSpinConveyorForwardCGS1;
    public static SpinConveyorCG secondSpinConveyorForwardCGS1;
    public static SpinConveyorCG firstSpinConveyorBackwardCGS1;


    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static AlignDiffDriveToTarget alignDiffDriveToTarget;
    public static DriveDiffArcade driveDiffArcade;
    public static DriveDiffTank driveDiffTank;
    public static DriveDiffToWithinRange driveDiffToWithinRangeFront;
    public static DriveDiffToWithinRange driveDiffToWithinRangeTop;
    public static RotateTowardsLevel rotateTowardsLeftLevel;
    public static RotateTowardsLevel rotateTowardsRightLevel;

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

    // Sensors
    public static TurnOffLimelightArray turnOffLimelightArray;

    // Shooter
    public static ConveyAndShoot conveyAndShoot;
    public static ResetShoot resetShoot;
    public static ReverseConveyorAndShoot reverseConveyorAndShoot;
    public static Shoot shoot;
    public static StopConveyorAndShooter stopConveyorAndShooter;
    public static StopShooter stopShooter;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        autoDriveToPickUp = new AutoDriveToPickUp(BotSubsystems.diffDriver);
        autoRotateLeftS1 = new AutoRotateLeft(BotSubsystems.diffDriver);
        autoRotateLeftS2 = new AutoRotateLeft(BotSubsystems.diffDriver);
        autoRotateRightS1 = new AutoRotateRight(BotSubsystems.diffDriver);
        autoRotateRightS2 = new AutoRotateRight(BotSubsystems.diffDriver);

        // Climb Balancer
        balanceRight = new Balance(BotSubsystems.climbBalancer, BalanceDirection.right);
        balanceLeft = new Balance(BotSubsystems.climbBalancer, BalanceDirection.left);
        stopBalancer = new StopBalancer(BotSubsystems.climbBalancer);

        // Climb Hook
        aimHook = new ChangeHookPosition(BotSubsystems.climbHook, HookPosition.aim);
        extendHook = new ChangeHookPosition(BotSubsystems.climbHook, HookPosition.extend);
        retractHook = new ChangeHookPosition(BotSubsystems.climbHook, HookPosition.retract);
        toggleHook = new ToggleHook(BotSubsystems.climbHook);
        stopHook = new StopHook(BotSubsystems.climbHook);

        // Climb Legs
        extendLegs = new ExtendLegs(BotSubsystems.climbLegs);
        retractLegs = new RetractLegs(BotSubsystems.climbLegs);
        stopLegs = new StopLegs(BotSubsystems.climbLegs);
        toggleLegs = new ToggleLegs(BotSubsystems.climbLegs);

        // Conveyor
        spinConveyorForward = new SpinConveyor(BotSubsystems.conveyor, ConveyorDirection.forward);
        spinConveyorBackward = new SpinConveyor(BotSubsystems.conveyor, ConveyorDirection.backward);
        spinConveyorBackwardBurst = new SpinConveyor(BotSubsystems.conveyor, ConveyorDirection.backward);
        firstSpinConveyorForwardCGS1 = new SpinConveyorCG(BotSubsystems.conveyor, ConveyorDirection.forward);
        secondSpinConveyorForwardCGS1 = new SpinConveyorCG(BotSubsystems.conveyor, ConveyorDirection.forward);
        firstSpinConveyorBackwardCGS1 = new SpinConveyorCG(BotSubsystems.conveyor, ConveyorDirection.backward);

        stopConveyor = new StopConveyor(BotSubsystems.conveyor);

        // DiffDriver
        // alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver, BotControllers.xbox);
        alignDiffDriveToTarget = new AlignDiffDriveToTarget(BotSubsystems.diffDriver);
        rotateTowardsLeftLevel = new RotateTowardsLevel(BotSubsystems.diffDriver, -112.48);
        rotateTowardsRightLevel = new RotateTowardsLevel(BotSubsystems.diffDriver, 67.52);
        driveDiffArcade = new DriveDiffArcade(BotSubsystems.diffDriver, BotControllers.jstick);
        driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, BotControllers.xbox);
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

        // Sensors
        turnOffLimelightArray = new TurnOffLimelightArray();

        // Shooter
        conveyAndShoot = new ConveyAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);
        resetShoot = new ResetShoot(BotSubsystems.shooter);
        reverseConveyorAndShoot = new ReverseConveyorAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);
        shoot = new Shoot(BotSubsystems.shooter);
        stopConveyorAndShooter = new StopConveyorAndShooter(BotSubsystems.conveyor, BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);

        // Autonomous Command Group
        autoLineUpAndShootS1 = new AutoLineUpAndShootS1(BotSubsystems.conveyor, BotSubsystems.shooter, BotSubsystems.diffDriver);
        autoLineUpAndShootS2 = new AutoLineUpAndShootS2(BotSubsystems.conveyor, BotSubsystems.shooter, BotSubsystems.diffDriver);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {

        // Find the currently selected auto command in Shuffleboard and return it
        Command autoCommand = RobotManager.autoCommandChooser.getSelected();
        return autoCommand;
    }

}

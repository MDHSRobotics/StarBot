
package frc.robot;

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
import frc.robot.subsystems.constants.PathConstants;

import java.nio.file.Path;
import java.io.IOException;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Autonomous
    public static AutoDriveForward autoDriveForward;
    public static AutoDriveForwardShoot autoDriveForwardShoot;

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
    public static StopConveyor stopConveyor;

    // DiffDriver
    public static AlignDiffDriveToGyro alignDiffDriveToGyro;
    public static CenterDiffDriveOnTarget centerDiffDriveOnTarget;
    public static DriveDiffTank driveDiffTank;

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
    public static ReverseConveyorAndShoot reverseConveyorAndShoot;
    public static StopConveyorAndShooter stopConveyorAndShooter;
    public static StopShooter stopShooter;

    //PathWeaver
    private static Path m_trajectoryPath;
    private static Trajectory m_trajectory;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Autonomous
        autoDriveForward = new AutoDriveForward(BotSubsystems.diffDriver);
        autoDriveForwardShoot = new AutoDriveForwardShoot(BotSubsystems.diffDriver);

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

        // DiffDriver
        alignDiffDriveToGyro = new AlignDiffDriveToGyro(BotSubsystems.diffDriver, BotControllers.primary.xbox);
        driveDiffTank = new DriveDiffTank(BotSubsystems.diffDriver, BotControllers.primary);

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
        reverseConveyorAndShoot = new ReverseConveyorAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);
        stopConveyorAndShooter = new StopConveyorAndShooter(BotSubsystems.conveyor, BotSubsystems.shooter);
        stopShooter = new StopShooter(BotSubsystems.shooter);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {

        String trajectoryJSON = "paths/testScenario.wpilib.json";

        try {
            m_trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
            m_trajectory = TrajectoryUtil.fromPathweaverJson(m_trajectoryPath);

            Logger.info("Trajectory created.");
        }

        catch (IOException ex) {
            DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
        }

        RamseteController ramseteController;
        ramseteController = new RamseteController(PathConstants.AutoConstants.kRamseteB,
                PathConstants.AutoConstants.kRamseteZeta);

        SimpleMotorFeedforward simpleMotorFeedforward;
        simpleMotorFeedforward = new SimpleMotorFeedforward(PathConstants.ksVolts, PathConstants.kvVoltSecondsPerMeter,
                PathConstants.kaVoltSecondsSquaredPerMeter);

        PIDController leftPIDController;
        leftPIDController = new PIDController(PathConstants.kPDriveVel, 0, 0);

        PIDController rightPIDController;
        rightPIDController = new PIDController(PathConstants.kPDriveVel, 0, 0);

        RamseteCommand ramseteCommand = new RamseteCommand(
                m_trajectory,
                BotSubsystems.diffDriver::getPose,
                ramseteController,
                simpleMotorFeedforward,
                PathConstants.kDriveKinematics,
                BotSubsystems.diffDriver::getWheelSpeeds,
                leftPIDController,
                rightPIDController,
                // RamseteCommand passes volts to the callback
                BotSubsystems.diffDriver::tankDriveVolts,
                BotSubsystems.diffDriver
        );

        return ramseteCommand.andThen(() -> BotSubsystems.diffDriver.tankDriveVolts(0, 0));

    }

}


package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static ClimbBalancer climbBalancer;
    public static ClimbHook climbHook;
    public static ClimbLegsRedLine climbLegsRedLine;
    public static ClimbLegsSparkMax climbLegsSparkMax;
    public static Conveyor conveyor;
    public static DiffDriver diffDriver;
    public static Lighter lighter;
    public static Roller roller;
    public static RollerArm rollerArm;
    public static Shooter shooter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        climbBalancer = new ClimbBalancer();
        climbHook = new ClimbHook();
        climbLegsRedLine = new ClimbLegsRedLine();
        climbLegsSparkMax = new ClimbLegsSparkMax();
        conveyor = new Conveyor();
        diffDriver = new DiffDriver();
        lighter = new Lighter();
        roller = new Roller();
        rollerArm = new RollerArm();
        shooter = new Shooter();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {
        // Climb Balancer
        Logger.setup("ClimbBalancer Default Command -> StopBalancer...");
        climbBalancer.setDefaultCommand(BotCommands.stopBalancer);

        // Climb Hook
        Logger.setup("ClimbHook Default Command -> StopHook...");
        climbHook.setDefaultCommand(BotCommands.stopHook);

        // Climb Legs Redline
        Logger.setup("ClimbLegsRedLine Default Command -> StopRedlineLegs...");
        climbLegsRedLine.setDefaultCommand(BotCommands.stopRedlineLegs);

        // Climb Legs SparkMax
        Logger.setup("ClimbLegsSparkMax Default Command -> StopSparkLegs...");
        climbLegsSparkMax.setDefaultCommand(BotCommands.stopSparkLegs);

        // Conveyor
        Logger.setup("Conveyor Default Command -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        // DiffDriver
        Logger.setup("DiffDriver Teleop Default Command -> DriveDiffTank...");
        diffDriver.setDefaultCommand(BotCommands.driveDiffTank);

        // Roller
        Logger.setup("Roller Default Command -> StopRoller...");
        roller.setDefaultCommand(BotCommands.stopRoller);

        // Shooter
        Logger.setup("Shooter Default Command -> StopShooter");
        shooter.setDefaultCommand(BotCommands.stopShooter);
    }

    // Set all the subsystem "test" default commands
    public static void setTestDefaultCommands() {
        Logger.setup("DiffDriver Test Default Command -> DriveDiffTank...");
        diffDriver.setDefaultCommand(TestCommands.driveDiffTank);
    }

}

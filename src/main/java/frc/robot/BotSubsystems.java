
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static ClimbBalancer climbBalancer;
    public static ClimbHook climbHook;
    public static ClimbLegsRed climbLegsRed;
    public static ClimbLegsSpark climbLegsSpark;
    public static Conveyor conveyor;
    public static DiffDriverTalon diffDriverTalon;
    public static DiffDriverSpark diffDriverSpark;
    public static Lighter lighter;
    public static Roller roller;
    public static RollerArm rollerArm;
    public static Shooter shooter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        climbBalancer = new ClimbBalancer();
        climbHook = new ClimbHook();
        climbLegsRed = new ClimbLegsRed();
        climbLegsSpark = new ClimbLegsSpark();
        conveyor = new Conveyor();
        diffDriverTalon = new DiffDriverTalon();
        diffDriverSpark = new DiffDriverSpark();
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

        // Climb Legs Red
        Logger.setup("ClimbLegsRed Default Command -> StopRedLegs...");
        // climbLegsRed.setDefaultCommand(BotCommands.stopRedLegs);

        // Climb Legs Spark
        Logger.setup("ClimbLegsSpark Default Command -> StopSparkLegs...");
        climbLegsSpark.setDefaultCommand(BotCommands.stopSparkLegs);

        // Conveyor
        Logger.setup("Conveyor Default Command -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        // DiffDriverTalon
        Logger.setup("DiffDriver Teleop Default Command -> DriveDiffTank...");
        diffDriverTalon.setDefaultCommand(BotCommands.driveDiffTank);

        // DiffDriverSpark
        Logger.setup("DiffDriverSPark Teleop Default Command -> DriveDiffTank...");
        diffDriverSpark.setDefaultCommand(BotCommands.driveDiffTankSpark);

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
        diffDriverSpark.setDefaultCommand(TestCommands.driveDiffTank);
    }

}

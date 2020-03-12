
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static ClimbBalancer climbBalancer;
    public static ClimbHook climbHook;
    public static ClimbLegs climbLegs;
    public static Conveyor conveyor;
    public static DiffDriver diffDriver;
    public static DiffDriver diffDriverAlternate;
    public static Lighter lighter;
    public static Roller roller;
    public static RollerArm rollerArm;
    public static Shooter shooter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        climbBalancer = new ClimbBalancer();
        climbHook = new ClimbHook();
        climbLegs = new ClimbLegs();
        conveyor = new Conveyor();
        diffDriver = new DiffDriverTalon(); // Swap the diffDrivers if changed on the robot
        diffDriverAlternate = new DiffDriverSpark();
        lighter = new Lighter();
        roller = new Roller();
        rollerArm = new RollerArm();
        shooter = new Shooter();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {
        // Climb Balancer
        Logger.setup("ClimbBalancer Teleop Default Command -> StopBalancer...");
        climbBalancer.setDefaultCommand(BotCommands.stopBalancer);

        // Climb Hook
        Logger.setup("ClimbHook Teleop Default Command -> StopHook...");
        climbHook.setDefaultCommand(BotCommands.stopHook);

        // Climb Legs
        Logger.setup("ClimbLegs Teleop Default Command -> StopLegs...");
        climbLegs.setDefaultCommand(BotCommands.stopLegs);

        // Conveyor
        Logger.setup("Conveyor Teleop Default Command -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        // DiffDriver
        Logger.setup("DiffDriver Teleop Default Command -> DriveDiffArcade...");
        diffDriver.setDefaultCommand(BotCommands.driveDiffArcade);

        // DiffDriverAlternate
        Logger.setup("DiffDriverAlternate Teleop Default Command -> StopDiffDrive...");
        diffDriverAlternate.setDefaultCommand(BotCommands.stopDiffDrive);

        // Roller
        Logger.setup("Roller Teleop Default Command -> StopRoller...");
        roller.setDefaultCommand(BotCommands.stopRoller);

        // Shooter
        Logger.setup("Shooter Teleop Default Command -> StopShooter...");
        shooter.setDefaultCommand(BotCommands.stopShooter);
    }

    // Set all the subsystem "test" default commands
    public static void setTestDefaultCommands() {
        Logger.setup("DiffDriver Test Default Command -> DriveDiffArcade...");
        diffDriver.setDefaultCommand(TestCommands.driveDiffArcade);
    }

}

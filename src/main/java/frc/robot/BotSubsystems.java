
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
public class BotSubsystems {

    public static SparkMaxClimb sparkMaxClimb;
    public static RedLineClimb redLineClimb;
    public static Conveyor conveyor;
    public static DiffDriver diffDriver;
    public static Lighter lighter;
    public static Roller roller;
    public static RollerArm rollerArm;
    public static Shooter shooter;
    public static ClimbArm climbArm;
    public static ClimbRoller climbRoller;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        sparkMaxClimb = new SparkMaxClimb();
        redLineClimb = new RedLineClimb();
        conveyor = new Conveyor();
        diffDriver = new DiffDriver();
        lighter = new Lighter();
        roller = new Roller();
        rollerArm = new RollerArm();
        shooter = new Shooter();
        climbArm = new ClimbArm();
        climbRoller = new ClimbRoller();
    }

    // Set all the subsystem "teleop" default commands
    public static void setTeleopDefaultCommands() {
        Logger.setup("SparkMaxClimb Default Command -> StandStop...");
        sparkMaxClimb.setDefaultCommand(BotCommands.standStop);

        Logger.setup("RedLineClimb Default Command -> StandStop...");
        redLineClimb.setDefaultCommand(BotCommands.standStop);

        Logger.setup("Conveyor Default Command -> StopClimbRoller...");
        climbRoller.setDefaultCommand(BotCommands.stopClimbRoller);

        Logger.setup("Conveyor Default Command -> StopConveyor...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        Logger.setup("DiffDriver Teleop Default Command -> DriveDiffTank...");
        diffDriver.setDefaultCommand(BotCommands.driveDiffTank);

        Logger.setup("Roller Default Command -> StopRoller...");
        roller.setDefaultCommand(BotCommands.stopRoller);

        Logger.setup("Shooter Default Command -> StopShooter");
        shooter.setDefaultCommand(BotCommands.stopShooter);
    }

    // Set all the subsystem "test" default commands
    public static void setTestDefaultCommands() {
        Logger.setup("DiffDriver Test Default Command -> DriveDiffTank...");
        diffDriver.setDefaultCommand(TestCommands.driveDiffTank);
    }

}

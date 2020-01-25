
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static Climb climb;
    public static Conveyor conveyor;
    public static DiffDriver diffDriver;
    public static Lighter lighter;
    public static Roller roller;
    public static RollerArm rollerArm;
    public static Shooter shooter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        climb = new Climb();
        conveyor = new Conveyor();
        diffDriver = new DiffDriver();
        lighter = new Lighter();
        roller = new Roller();
        rollerArm = new RollerArm();
        shooter = new Shooter();
    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        Logger.setup("Climb DefaultCommand -> StandStop...");
        climb.setDefaultCommand(BotCommands.standStop);

        Logger.setup("Conveyor DefaultCommand -> Convey...");
        conveyor.setDefaultCommand(BotCommands.stopConveyor);

        Logger.setup("DiffDriver DefaultCommand -> DriveDifferentialTank...");
        diffDriver.setDefaultCommand(BotCommands.driveDifferentialTank);

        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);

        Logger.setup("Roller DefaultCommand -> RollerStop...");
        roller.setDefaultCommand(BotCommands.rollerStop);

        Logger.setup("Shooter DefaultCommand -> StopShoot");
        shooter.setDefaultCommand(BotCommands.stopShoot);
    }

}


package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static Lighter lighter;
    public static Roller roller;
    public static RollerArm rollerArm;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        lighter = new Lighter();
        rollerArm = new RollerArm();
        roller = new Roller();
    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);

        Logger.setup("Roller DefaultCommand -> RollerStop...");
        roller.setDefaultCommand(BotCommands.rollerStop);

        Logger.setup("RollerArm DefaultCommand -> StopRollerArm...");
        rollerArm.setDefaultCommand(BotCommands.stopRollerArm);
    }

}


package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static Lighter lighter;
    public static Roller roller;
    public static PickUpPneumatic pickUpPneumatic;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        lighter = new Lighter();
        roller = new Roller();
        pickUpPneumatic = new PickUpPneumatic();

    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        // Lighter Initial Default Command
        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);

        // Roller Intitial Default Command
        Logger.setup("Roller DefaultCommand -> RollerStop...");
        roller.setDefaultCommand(BotCommands.rollerStop);

        // PickUp Initial Default Command
        Logger.setup("PickUp DefaultCommand -> StopPickUp...");
        pickUpPneumatic.setDefaultCommand(BotCommands.stopPickUp);
    }

}

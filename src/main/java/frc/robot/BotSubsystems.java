
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static Lighter lighter;
    public static Climb climb;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        lighter = new Lighter();
        climb = new Climb();
    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);
    }

}

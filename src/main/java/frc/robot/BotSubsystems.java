
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.*;

// Contains singleton instances of all the subsystems on the robot.
// IMPORTANT: When you make a new subsystem, you need to also set a default command.
public class BotSubsystems {

    public static Climb climb;
    public static Lighter lighter;

    // Initialize all robot subsystems
    public static void initializeSubsystems() {
        Logger.setup("Initializing BotSubsystems...");

        climb = new Climb();
        lighter = new Lighter();
    }

    // Set all the subsystem default commands
    public static void setDefaultCommands() {
        Logger.setup("Climb DefaultCommand -> StandStop...");
        climb.setDefaultCommand(BotCommands.standStop);

        Logger.setup("Lighter DefaultCommand -> CycleLights...");
        lighter.setDefaultCommand(BotCommands.cycleLights);
    }

}

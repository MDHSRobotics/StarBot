
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.climb.StandStop;
import frc.robot.commands.lighter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    public static CycleLights cycleLights;
    public static StandStop standStop;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        cycleLights = new CycleLights(BotSubsystems.lighter);
        standStop = new StandStop(BotSubsystems.climb);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}

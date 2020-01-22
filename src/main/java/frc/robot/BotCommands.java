
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.lighter.*;
import frc.robot.commands.climb.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Lighter
    public static CycleLights cycleLights;

    // Climb
    public static StandStop standStop;
    public static RollerForward rollerForward;
    public static RollerReverse rollerReverse;
    public static HookForward hookForward;
    public static HookReverse hookReverse;
    public static LiftRobot liftRobot;
    public static LowerRobot lowerRobot;
    public static ToggleHook toggleHook;
    public static ToggleLegs toggleLegs;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Climb
        standStop = new StandStop(BotSubsystems.climb);
        rollerForward = new RollerForward(BotSubsystems.climb);
        rollerReverse = new RollerReverse(BotSubsystems.climb);
        hookForward = new HookForward(BotSubsystems.climb);
        hookReverse = new HookReverse(BotSubsystems.climb);
        liftRobot = new LiftRobot(BotSubsystems.climb);
        lowerRobot = new LowerRobot(BotSubsystems.climb);
        toggleHook = new ToggleHook(BotSubsystems.climb);
        toggleLegs = new ToggleLegs(BotSubsystems.climb);

    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}

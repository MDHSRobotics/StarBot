
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.climb.*;
import frc.robot.commands.lighter.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Climb
    public static StandStop standStop;

    // Climb Hook
    public static HookForward hookForward;
    public static HookReverse hookReverse;
    public static ToggleHook toggleHook;

    // Climb Legs
    public static LiftRobot liftRobot;
    public static LowerRobot lowerRobot;
    public static ToggleLegs toggleLegs;

    // Climb Roller
    public static RollerForward rollerForward;
    public static RollerReverse rollerReverse;

    // Lighter
    public static CycleLights cycleLights;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Climb
        standStop = new StandStop(BotSubsystems.climb);

        // Climb Hook
        hookForward = new HookForward(BotSubsystems.climb);
        hookReverse = new HookReverse(BotSubsystems.climb);
        toggleHook = new ToggleHook(BotSubsystems.climb);

        // Climb Legs
        liftRobot = new LiftRobot(BotSubsystems.climb);
        lowerRobot = new LowerRobot(BotSubsystems.climb);
        toggleLegs = new ToggleLegs(BotSubsystems.climb);

        // Climb Roller
        rollerForward = new RollerForward(BotSubsystems.climb);
        rollerReverse = new RollerReverse(BotSubsystems.climb);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}

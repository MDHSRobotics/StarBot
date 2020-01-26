
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;
import frc.robot.BotCommands;

// Toggles the position of the climb hook
public class ToggleHook extends InstantCommand {

    private Climb m_climb;

    public ToggleHook(Climb climb) {
        Logger.setup("Constructing InstantCommand: ToggleHook...");

        m_climb = climb;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleHook...");

        if (m_climb.hookIsOut) {
            Logger.action("ToggleHook -> Moving the climb hook BACK...");
            BotCommands.hookReverse.schedule();
        } else {
            Logger.action("ToggleHook -> Moving the climb hook FORWARD...");
            BotCommands.hookForward.schedule();
        }
        m_climb.toggleHookPosition();
    }

}

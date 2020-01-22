
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;
import frc.robot.BotCommands;

// Toggles the position of the Hatcher Claw
public class ToggleHook extends InstantCommand {

    private Climb m_climb;

    public ToggleHook(Climb climb) {
        Logger.setup("Constructing InstantCommand: ToggleHook...");

        m_climb = climb;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleHatchClawPosition...");

        if (m_climb.hookIsOut) {
            Logger.action("Hatcher -> Moving to OPEN...");
            BotCommands.hookReverse.schedule();
        } else {
            Logger.action("Hatcher -> Moving to CLOSED...");
            BotCommands.hookForward.schedule();
        }
        m_climb.toggleHookPosition();
    }

}

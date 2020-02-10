
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;
import frc.robot.BotCommands;

// Toggles the position of the climb hook.
public class ToggleHook extends InstantCommand {

    private ClimbHook m_climbHook;

    public ToggleHook(ClimbHook climbHook) {
        Logger.setup("Constructing InstantCommand: ToggleHook...");

        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleHook...");

        if (m_climbHook.hookIsBack) {
            Logger.action("ClimbHook -> Moving Forward...");
            BotCommands.moveHookForward.schedule();
        } else {
            Logger.action("ClimbHook -> Moving Backward...");
            BotCommands.moveHookBackward.schedule();
        }
        m_climbHook.toggleHookPosition();
    }

}
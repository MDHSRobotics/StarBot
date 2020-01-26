
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;

// This command moves the climb hook backwards
public class HookReverse extends InstantCommand {

    private Climb m_climb;

    public HookReverse(Climb climb) {
        Logger.setup("Constructing Command: HookReverse...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: HookReverse...");
        m_climb.hookReverse();
    }

}

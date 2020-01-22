
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;

// This command starts the Climb motors
public class HookForward extends InstantCommand {

    private Climb m_climb;

    public HookForward(Climb climb) {
        Logger.setup("Constructing Command: HookForward...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: HookForward...");
        m_climb.hookForward();
    }
}
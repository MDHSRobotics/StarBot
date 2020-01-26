
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;

// This command rolls the climbing robot forwards?
public class RollerForward extends InstantCommand {

    private Climb m_climb;

    public RollerForward(Climb climb) {
        Logger.setup("Constructing Command: RollerForward...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RollerForward...");
        m_climb.rollerForward();
    }
}

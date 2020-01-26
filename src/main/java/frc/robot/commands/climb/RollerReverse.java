
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;

// This command rolls the climbing robot backwards?
public class RollerReverse extends InstantCommand {

    private Climb m_climb;

    public RollerReverse(Climb climb) {
        Logger.setup("Constructing Command: StandReverse...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StandReverse...");
        m_climb.rollerReverse();
    }

}

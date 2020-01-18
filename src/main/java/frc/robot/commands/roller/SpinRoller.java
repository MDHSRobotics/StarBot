
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Roller;

// This command spins the Roller
public class SpinRoller extends InstantCommand {

    private Roller m_roller;

    public SpinRoller(Roller roller) {
        Logger.setup("Constructing InstantCommand: SpinRoller...");

        // Add given subsystem requirements
        m_roller = roller;
        addRequirements(m_roller);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing InstantCommand: SpinRoller...");

        m_roller.spin();
    }

}

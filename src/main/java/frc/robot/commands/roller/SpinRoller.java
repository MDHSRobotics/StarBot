
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Roller;
import frc.robot.subsystems.Conveyor;

// This command spins the Roller
public class SpinRoller extends InstantCommand {

    private Roller m_roller;
    private Conveyor m_conveyor;

    public SpinRoller(Roller roller, Conveyor conveyor) {
        Logger.setup("Constructing InstantCommand: SpinRoller...");

        // Add given subsystem requirements
        m_roller = roller;
        m_conveyor = conveyor;
        addRequirements(m_roller);
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing InstantCommand: SpinRoller...");

        m_roller.spin();
        m_conveyor.spin();
    }

}

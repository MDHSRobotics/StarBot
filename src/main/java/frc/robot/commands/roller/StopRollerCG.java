
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Roller;

// This command stops the Roller.
public class StopRollerCG extends CommandBase {

    private Roller m_roller;

    public StopRollerCG(Roller roller) {
        Logger.setup("Constructing Command: StopRollerCG...");

        // Add given subsystem requirements
        m_roller = roller;
        addRequirements(m_roller);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopRollerCG...");
    }

    @Override
    public void execute() {
        m_roller.stop();
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: StopRollerCG...");
        } else {
            Logger.ending("Ending Command: StopRollerCG...");
        }
        m_roller.stop();
    }

}

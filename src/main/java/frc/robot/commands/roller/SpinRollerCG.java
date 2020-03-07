
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Roller;

// This command spins the Roller and moves the Conveyor forward.
public class SpinRollerCG extends CommandBase {

    private Roller m_roller;

    public SpinRollerCG(Roller roller) {
        Logger.setup("Constructing Command: SpinRollerCG...");

        // Add given subsystem requirements
        m_roller = roller;
        addRequirements(m_roller);

    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinRollerCG...");
    }

    @Override
    public void execute() {
        m_roller.spin();
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
            Logger.ending("Interrupting Command: SpinRollerCG...");
        } else {
            Logger.ending("Ending Command: SpinRollerCG...");
        }
    }

}

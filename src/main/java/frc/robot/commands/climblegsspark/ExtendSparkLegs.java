
package frc.robot.commands.climblegsspark;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsSpark;

// This command extends the climb legs.
public class ExtendSparkLegs extends CommandBase {

    private ClimbLegsSpark m_climbLegsSpark;

    public ExtendSparkLegs(ClimbLegsSpark climbLegsSpark) {
        Logger.setup("Constructing Command: ExtendSparkLegs...");

        // Add given subsystem requirements
        m_climbLegsSpark = climbLegsSpark;
        addRequirements(m_climbLegsSpark);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ExtendSparkLegs...");

        m_climbLegsSpark.extendLegs();
    }

    @Override
    public void execute() {
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
            Logger.ending("Interrupting Command: ExtendSparkLegs...");
        } else {
            Logger.ending("Ending Command: ExtendSparkLegs...");
        }
        m_climbLegsSpark.stop();
    }

}

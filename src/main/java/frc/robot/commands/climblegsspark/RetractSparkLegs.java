
package frc.robot.commands.climblegsspark;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsSpark;

// This command retracts the climb legs.
public class RetractSparkLegs extends CommandBase {

    private ClimbLegsSpark m_climbLegsSpark;

    public RetractSparkLegs(ClimbLegsSpark climbLegsSpark) {
        Logger.setup("Constructing Command: RetractSparkLegs...");

        // Add given subsystem requirements
        m_climbLegsSpark = climbLegsSpark;
        addRequirements(m_climbLegsSpark);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RetractSparkLegs...");

        m_climbLegsSpark.retractLegs();
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
            Logger.ending("Interrupting Command: RetractSparkLegs...");
        } else {
            Logger.ending("Ending Command: RetractSparkLegs...");
        }
        m_climbLegsSpark.stop();
    }

}

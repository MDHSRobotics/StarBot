
package frc.robot.commands.climblegsspark;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsSpark;

// This command stops the climb legs.
public class StopSparkLegs extends CommandBase {

    private ClimbLegsSpark m_climbLegsSpark;

    public StopSparkLegs(ClimbLegsSpark climbLegsSpark) {
        Logger.setup("Constructing Command: StopSparkLegs...");

        // Add given subsystem requirements
        m_climbLegsSpark = climbLegsSpark;
        addRequirements(m_climbLegsSpark);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopSparkLegs...");
    }

    @Override
    public void execute() {
        m_climbLegsSpark.stop();
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
            Logger.ending("Interrupting Command: StopSparkLegs...");
        } else {
            Logger.ending("Ending Command: StopSparkLegs...");
        }
        m_climbLegsSpark.stop();
    }

}

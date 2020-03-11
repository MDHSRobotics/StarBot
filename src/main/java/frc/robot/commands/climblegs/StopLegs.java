
package frc.robot.commands.climblegs;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegs;

// This command stops the climb legs.
public class StopLegs extends CommandBase {

    private ClimbLegs m_climbLegs;

    public StopLegs(ClimbLegs climbLegs) {
        Logger.setup("Constructing Command: StopLegs...");

        // Add given subsystem requirements
        m_climbLegs = climbLegs;
        addRequirements(m_climbLegs);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopLegs...");
    }

    @Override
    public void execute() {
        m_climbLegs.stop();
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
            Logger.ending("Interrupting Command: StopLegs...");
        } else {
            Logger.ending("Ending Command: StopLegs...");
        }
        m_climbLegs.stop();
    }

}

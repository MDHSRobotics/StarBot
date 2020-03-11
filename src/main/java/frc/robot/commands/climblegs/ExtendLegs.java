
package frc.robot.commands.climblegs;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegs;

// This command extends the climb legs.
public class ExtendLegs extends CommandBase {

    private ClimbLegs m_climbLegs;

    public ExtendLegs(ClimbLegs climbLegs) {
        Logger.setup("Constructing Command: ExtendLegs...");

        // Add given subsystem requirements
        m_climbLegs = climbLegs;
        addRequirements(m_climbLegs);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ExtendLegs...");

        m_climbLegs.extendLegs();
    }

    @Override
    public void execute() {
        //System.out.println("ClimbLegs Position: " + m_climbLegs.getPosition());
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
            Logger.ending("Interrupting Command: ExtendLegs...");
        } else {
            Logger.ending("Ending Command: ExtendLegs...");
        }
        m_climbLegs.stop();
    }

}

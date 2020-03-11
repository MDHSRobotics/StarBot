
package frc.robot.commands.climblegs;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegs;

// This command retracts the climb legs.
public class RetractLegs extends CommandBase {

    private ClimbLegs m_climbLegs;

    public RetractLegs(ClimbLegs climbLegs) {
        Logger.setup("Constructing Command: RetractLegs...");

        // Add given subsystem requirements
        m_climbLegs = climbLegs;
        addRequirements(m_climbLegs);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RetractLegs...");

        m_climbLegs.retractLegs();
    }

    @Override
    public void execute() {
        //System.out.println("ClimbLegs Position: " + m_climbLegs.getPosition());
    }

    // This command continues until its position is between -100 and 100.
    @Override
    public boolean isFinished() {
        int position = m_climbLegs.getPosition();
        boolean finished = (position <= 100 && position >= -100);
        return finished;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: RetractLegs...");
        } else {
            Logger.ending("Ending Command: RetractLegs...");
        }
        m_climbLegs.stop();
    }

}

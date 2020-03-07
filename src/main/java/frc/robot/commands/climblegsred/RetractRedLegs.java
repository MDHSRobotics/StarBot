
package frc.robot.commands.climblegsred;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsRed;

// This command retracts the climb legs.
public class RetractRedLegs extends CommandBase {

    private ClimbLegsRed m_climbLegsRed;

    public RetractRedLegs(ClimbLegsRed climbLegsRed) {
        Logger.setup("Constructing Command: RetractRedLegs...");

        // Add given subsystem requirements
        m_climbLegsRed = climbLegsRed;
        addRequirements(m_climbLegsRed);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RetractRedLegs...");

        m_climbLegsRed.retractLegs();
    }

    @Override
    public void execute() {
        //System.out.println("ClimbLegsRed Position: " + m_climbLegsRed.getPosition());
    }

    // This command continues until its position is between -100 and 100.
    @Override
    public boolean isFinished() {
        int position = m_climbLegsRed.getPosition();
        boolean finished = (position <= 100 && position >= -100);
        return finished;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: RetractRedLegs...");
        } else {
            Logger.ending("Ending Command: RetractRedLegs...");
        }
        m_climbLegsRed.stop();
    }

}

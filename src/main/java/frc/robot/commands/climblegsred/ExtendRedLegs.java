
package frc.robot.commands.climblegsred;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsRed;

// This command extends the climb legs.
public class ExtendRedLegs extends CommandBase {

    private ClimbLegsRed m_climbLegsRed;

    public ExtendRedLegs(ClimbLegsRed climbLegsRed) {
        Logger.setup("Constructing Command: ExtendRedLegs...");

        // Add given subsystem requirements
        m_climbLegsRed = climbLegsRed;
        addRequirements(m_climbLegsRed);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ExtendRedLegs...");

        m_climbLegsRed.extendLegs();
    }

    @Override
    public void execute() {
        System.out.println("ClimbLegsRed Position: " + m_climbLegsRed.getPosition());
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
            Logger.ending("Interrupting Command: ExtendRedLegs...");
        } else {
            Logger.ending("Ending Command: ExtendRedLegs...");
        }
        m_climbLegsRed.stop();
    }

}

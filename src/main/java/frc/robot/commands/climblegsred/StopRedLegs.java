
package frc.robot.commands.climblegsred;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsRed;

// This command stops the climb legs.
public class StopRedLegs extends CommandBase {

    private ClimbLegsRed m_climbLegsRed;

    public StopRedLegs(ClimbLegsRed climbLegsRed) {
        Logger.setup("Constructing Command: StopRedLegs...");

        // Add given subsystem requirements
        m_climbLegsRed = climbLegsRed;
        addRequirements(m_climbLegsRed);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopRedLegs...");
    }

    @Override
    public void execute() {
        m_climbLegsRed.stop();
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
            Logger.ending("Interrupting Command: StopRedLegs...");
        } else {
            Logger.ending("Ending Command: StopRedLegs...");
        }
        m_climbLegsRed.stop();
    }

}

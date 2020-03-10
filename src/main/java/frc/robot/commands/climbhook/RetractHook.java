
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;

// This command fully retracts the climb hook.
public class RetractHook extends CommandBase {

    private ClimbHook m_climbHook;

    public RetractHook(ClimbHook climbHook) {
        Logger.setup("Constructing Command: RetractHook...");

        // Add given subsystem requirements
        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RetractHook...");

        m_climbHook.retractHook();
    }

    @Override
    public void execute() {
    }

    // This command continues until its position is between -100 and 100.
    @Override
    public boolean isFinished() {
        int position = m_climbHook.getPosition();
        boolean finished = (position <= 100 && position >= -100);
        return finished;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: RetractHook...");
        } else {
            Logger.ending("Ending Command: RetractHook...");
        }
        m_climbHook.stop();
    }

}


package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;

// This command fully extends the climb hook.
public class ExtendHook extends CommandBase {

    private ClimbHook m_climbHook;

    public ExtendHook(ClimbHook climbHook) {
        Logger.setup("Constructing Command: ExtendHook...");

        // Add given subsystem requirements
        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ExtendHook...");

        m_climbHook.extendHook();
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
            Logger.ending("Interrupting Command: ExtendHook...");
        } else {
            Logger.ending("Ending Command: ExtendHook...");
        }
        m_climbHook.stop();
    }

}

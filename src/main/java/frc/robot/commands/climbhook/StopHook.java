
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;

// This command stops the ClimbHook.
public class StopHook extends CommandBase {

    private ClimbHook m_climbHook;

    public StopHook(ClimbHook climbHook) {
        Logger.setup("Constructing Command: StopHook...");

        // Add given subsystem requirements
        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopHook...");
    }

    @Override
    public void execute() {
        m_climbHook.stop();
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
            Logger.ending("Interrupting Command: StopHook...");
        } else {
            Logger.ending("Ending Command: StopHook...");
        }
        m_climbHook.stop();
    }

}

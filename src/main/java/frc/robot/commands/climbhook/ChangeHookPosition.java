
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;
import frc.robot.subsystems.ClimbHook.HookPosition;

// This command can aim, extend, or retract the hook
public class ChangeHookPosition extends CommandBase {

    private ClimbHook m_climbHook;
    private HookPosition hookPosition;

    public ChangeHookPosition(ClimbHook climbHook, HookPosition hookPosition) {
        Logger.setup("Constructing Command: ChangeHookPosition...");

        this.hookPosition = hookPosition;

        // Add given subsystem requirements
        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ChangeHookPosition...");
    }

    @Override
    public void execute() {
        m_climbHook.changeHookPosition(hookPosition);
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
            Logger.ending("Interrupting Command: ChangeHookPosition...");
        } else {
            Logger.ending("Ending Command: ChangeHookPosition...");
        }
        m_climbHook.stop();
    }

}

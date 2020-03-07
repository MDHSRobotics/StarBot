
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;

// This command retracts the climb legs.
public class MoveHookBackward extends CommandBase {

    private ClimbHook m_climbHook;

    public MoveHookBackward(ClimbHook climbHook) {
        Logger.setup("Constructing Command: MoveHookBackward...");

        // Add given subsystem requirements
        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: MoveHookBackward...");

        m_climbHook.retractHook();
    }

    @Override
    public void execute() {
        //System.out.println("ClimbLegsRed Position: " + m_climbHook.getPosition());
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
            Logger.ending("Interrupting Command: MoveHookBackward...");
        } else {
            Logger.ending("Ending Command: MoveHookBackward...");
        }
        m_climbHook.stop();
    }

}

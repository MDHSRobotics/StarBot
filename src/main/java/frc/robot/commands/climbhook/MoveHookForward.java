
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;

// This command moves the climb hook forward.
public class MoveHookForward extends CommandBase {

    private ClimbHook m_climbHook;
    private Timer m_timer = new Timer();

    public MoveHookForward(ClimbHook climbHook) {
        Logger.setup("Constructing Command: MoveHookForward...");

        // Add given subsystem requirements
        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: MoveHookForward...");

        m_timer.stop();
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        m_climbHook.moveBackward();
    }

    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();
        boolean finished = (currentTime <= 3);
        return finished;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: MoveHookForward...");
        } else {
            Logger.ending("Ending Command: MoveHookForward...");
        }
    }

}

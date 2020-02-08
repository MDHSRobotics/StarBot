
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;
import edu.wpi.first.wpilibj.Timer;

// This command moves the climbArm belt forward
public class MoveHookForward extends CommandBase {

    private ClimbHook m_climbArm;
    private Timer m_timer = new Timer();

    public MoveHookForward(ClimbHook climbArm) {
        Logger.setup("Constructing Command: RetractArm...");

        // Add given subsystem requirements
        m_climbArm = climbArm;
        addRequirements(m_climbArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RetractArm...");
        m_timer.stop();
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
            m_climbArm.retract();
    }

    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();
        if (currentTime <= 3)
        return false;
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: RetractArm...");
        } else {
            Logger.ending("Ending Command: RetractArm...");
        }

        //m_climbArm.stop();
    }

}

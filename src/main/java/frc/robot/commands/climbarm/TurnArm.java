
package frc.robot.commands.climbarm;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbArm;
import edu.wpi.first.wpilibj.Timer;

// This command moves the climbArm belt forward
public class TurnArm extends CommandBase {

    private ClimbArm m_climbArm;
    private Timer m_timer = new Timer();

    public TurnArm(ClimbArm climbArm) {
        Logger.setup("Constructing Command: TurnArm...");

        // Add given subsystem requirements
        m_climbArm = climbArm;
        addRequirements(m_climbArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TurnArm...");
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        m_climbArm.turn();
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
            Logger.ending("Interrupting Command: TurnArm...");
        } else {
            Logger.ending("Ending Command: TurnArm...");
        }

        //m_climbArm.stop();
    }

}

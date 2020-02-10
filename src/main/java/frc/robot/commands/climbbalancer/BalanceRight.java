
package frc.robot.commands.climbbalancer;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbBalancer;

// This command move the ClimbBalancer to the right.
public class BalanceRight extends CommandBase {

    private ClimbBalancer m_climbBalancer;

    public BalanceRight(ClimbBalancer climbBalancer) {
        Logger.setup("Constructing Command: BalanceRight...");

        // Add given subsystem requirements
        m_climbBalancer = climbBalancer;
        addRequirements(m_climbBalancer);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: BalanceRight...");
    }

    @Override
    public void execute() {
        m_climbBalancer.moveRight();
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
            Logger.ending("Interrupting Command: BalanceRight...");
        } else {
            Logger.ending("Ending Command: BalanceRight...");
        }
    }

}

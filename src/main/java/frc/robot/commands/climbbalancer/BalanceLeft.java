
package frc.robot.commands.climbbalancer;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbBalancer;

// This command moves the ClimbBalancer to the left.
public class BalanceLeft extends CommandBase {

    private ClimbBalancer m_climbBalancer;

    public BalanceLeft(ClimbBalancer climbBalancer) {
        Logger.setup("Constructing Command: BalanceLeft...");

        // Add given subsystem requirements
        m_climbBalancer = climbBalancer;
        addRequirements(m_climbBalancer);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: BalanceLeft...");
    }

    @Override
    public void execute() {
        m_climbBalancer.moveLeft();
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
            Logger.ending("Interrupting Command: BalanceLeft...");
        } else {
            Logger.ending("Ending Command: BalanceLeft...");
        }
    }

}
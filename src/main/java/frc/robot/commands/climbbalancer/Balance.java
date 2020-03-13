
package frc.robot.commands.climbbalancer;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbBalancer;
import frc.robot.subsystems.ClimbBalancer.BalanceDirection;

// This command moves climb balancer
public class Balance extends CommandBase {

    private ClimbBalancer m_climbBalancer;
    private BalanceDirection balanceDirection;

    public Balance(ClimbBalancer climbBalancer, BalanceDirection balanceDirection) {
        Logger.setup("Constructing Command: Balance...");

        this.balanceDirection = balanceDirection;

        // Add given subsystem requirements
        m_climbBalancer = climbBalancer;
        addRequirements(m_climbBalancer);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: Balance...");
    }

    @Override
    public void execute() {
        m_climbBalancer.move(balanceDirection);
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
            Logger.ending("Interrupting Command: Balance...");
        } else {
            Logger.ending("Ending Command: Balance...");
        }
    }

}

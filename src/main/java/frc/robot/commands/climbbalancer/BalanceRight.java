
package frc.robot.commands.climbbalancer;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbBalancer;

// This command stops the ClimbArm
public class BalanceRight extends CommandBase {

    private ClimbBalancer m_climbRoller;

    public BalanceRight(ClimbBalancer climbRoller) {
        Logger.setup("Constructing Command: RollerForward...");

        // Add given subsystem requirements
        m_climbRoller = climbRoller;
        addRequirements(m_climbRoller);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RollerForward...");
    }

    @Override
    public void execute() {
        m_climbRoller.forward();
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
            Logger.ending("Interrupting Command: RollerForward...");
        } else {
            Logger.ending("Ending Command: RollerForward...");
        }
    }

}

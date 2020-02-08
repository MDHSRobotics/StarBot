
package frc.robot.commands.climbbalancer;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbBalancer;

// This command stops the ClimbArm
public class BalanceLeft extends CommandBase {

    private ClimbBalancer m_climbRoller;

    public BalanceLeft(ClimbBalancer climbRoller) {
        Logger.setup("Constructing Command: RollerReverse...");

        // Add given subsystem requirements
        m_climbRoller = climbRoller;
        addRequirements(m_climbRoller);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RollerReverse...");
    }

    @Override
    public void execute() {
        m_climbRoller.reverse();
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
            Logger.ending("Interrupting Command: RollerReverse...");
        } else {
            Logger.ending("Ending Command: RollerReverse...");
        }
    }

}

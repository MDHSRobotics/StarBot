
package frc.robot.commands.climbbalancer;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbBalancer;

// This command stops the ClimbArm
public class StopBalancer extends CommandBase {

    private ClimbBalancer m_climbRoller;

    public StopBalancer(ClimbBalancer climbRoller) {
        Logger.setup("Constructing Command: ClimbRollerStop...");

        // Add given subsystem requirements
        m_climbRoller = climbRoller;
        addRequirements(m_climbRoller);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ClimbRollerStop...");
    }

    @Override
    public void execute() {
        m_climbRoller.stop();
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
            Logger.ending("Interrupting Command: ClimbRollerStop...");
        } else {
            Logger.ending("Ending Command: ClimbRollerStop...");
        }

        m_climbRoller.stop();
    }

}

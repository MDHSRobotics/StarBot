
package frc.robot.commands.climbroller;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbRoller;

// This command stops the ClimbArm
public class RollerForward extends CommandBase {

    private ClimbRoller m_climbRoller;

    public RollerForward(ClimbRoller climbRoller) {
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

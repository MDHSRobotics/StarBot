
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;

// This command stops the ClimbArm
public class StopHook extends CommandBase {

    private ClimbHook m_climbArm;

    public StopHook(ClimbHook climbArm) {
        Logger.setup("Constructing Command: ClimbArmStop...");

        // Add given subsystem requirements
        m_climbArm = climbArm;
        addRequirements(m_climbArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ClimbArmStop...");
    }

    @Override
    public void execute() {
        m_climbArm.stop();
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
            Logger.ending("Interrupting Command: ClimbArmStop...");
        } else {
            Logger.ending("Ending Command: ClimbArmStop...");
        }

        m_climbArm.stop();
    }

}


package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;

// This command extends the climb legs.
public class AimHook extends CommandBase {

    private ClimbHook m_climbHook;

    public AimHook(ClimbHook climbHook) {
        Logger.setup("Constructing Command: AimHook...");

        // Add given subsystem requirements
        m_climbHook = climbHook;
        addRequirements(m_climbHook);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AimHook...");

        m_climbHook.aimHook();
    }

    @Override
    public void execute() {
        //System.out.println("ClimbLegsRed Position: " + m_climbHook.getPosition());
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
            Logger.ending("Interrupting Command: AimHook...");
        } else {
            Logger.ending("Ending Command: AimHook...");
        }
        m_climbHook.stop();
    }

}

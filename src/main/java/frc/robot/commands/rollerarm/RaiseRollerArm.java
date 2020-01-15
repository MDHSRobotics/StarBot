
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command raises the roller arm
public class RaiseRollerArm extends CommandBase {

    private RollerArm m_rollerArm;

    public RaiseRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing Command: RaiseRollerArm...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RaiseRollerArm...");

        m_rollerArm.raiseArm();
    }

    @Override
    public void execute() {
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
            Logger.ending("Interrupting Command: RaiseRollerArm...");
        } else {
            Logger.ending("Ending Command: RaiseRollerArm...");
        }

        m_rollerArm.stopArm();
    }

}

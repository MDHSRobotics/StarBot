
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command lowers the roller arm
public class LowerRollerArm extends CommandBase {

    private RollerArm m_rollerArm;

    public LowerRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing Command: LowerRollerArm...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerRollerArm...");

        m_rollerArm.lowerArm();
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
            Logger.ending("Interrupting Command: LowerRollerArm...");
        } else {
            Logger.ending("Ending Command: LowerRollerArm...");
        }

        m_rollerArm.stopArm();
    }

}

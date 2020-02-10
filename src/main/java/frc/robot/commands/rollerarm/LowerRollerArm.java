
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command lowers the RollerArm.
public class LowerRollerArm extends InstantCommand {

    private RollerArm m_rollerArm;

    public LowerRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing InstantCommand: LowerRollerArm...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing InstantCommand: LowerRollerArm...");

        m_rollerArm.lowerArm();
    }

}

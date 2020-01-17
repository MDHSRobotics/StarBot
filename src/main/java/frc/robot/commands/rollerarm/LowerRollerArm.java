
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command lowers the roller arm
public class LowerRollerArm extends InstantCommand {

    private RollerArm m_rollerArm;

    public LowerRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing Command: LowerRollerArm...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerRollerArm...");

        m_rollerArm.lowerArm();
    }

}

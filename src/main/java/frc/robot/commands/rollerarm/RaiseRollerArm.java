
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command raises the roller arm
public class RaiseRollerArm extends InstantCommand {

    private RollerArm m_rollerArm;

    public RaiseRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing Command: RaiseRollerArm...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RaiseRollerArm...");

        m_rollerArm.raiseArm();
    }

}

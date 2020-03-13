
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;
import frc.robot.subsystems.RollerArm.RollerArmPosition;

// This command lowers and raises the RollerArm.
public class MoveRollerArm extends InstantCommand {

    private RollerArm m_rollerArm;
    private RollerArmPosition rollerArmPosition;

    public MoveRollerArm(RollerArm rollerArm, RollerArmPosition rollerArmPosition) {
        Logger.setup("Constructing InstantCommand: MoveRollerArm...");

        this.rollerArmPosition = rollerArmPosition;

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing InstantCommand: MoveRollerArm...");

        m_rollerArm.moveArm(rollerArmPosition);
    }

}

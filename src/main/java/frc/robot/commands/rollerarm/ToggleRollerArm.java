
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;
import frc.robot.BotCommands;

// Toggles the position of the RollerArm.
public class ToggleRollerArm extends InstantCommand {

    private RollerArm m_rollerArm;

    public ToggleRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing InstantCommand: ToggleRollerArm...");

        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleRollerArm...");

        if (m_rollerArm.armIsUp) {
            Logger.action("RollerArm -> Lowering...");
            BotCommands.lowerRollerArm.schedule();
        } else {
            Logger.action("RollerArm -> Raising...");
            BotCommands.raiseRollerArm.schedule();
        }
        m_rollerArm.toggleArmPosition();
    }

}

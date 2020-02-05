
package frc.robot.commands.climbarm;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbArm;
import frc.robot.BotCommands;

// Toggles the position of the roller arm
public class ToggleClimbArm extends InstantCommand {

    private ClimbArm m_climbArm;

    public ToggleClimbArm(ClimbArm climbArm) {
        Logger.setup("Constructing InstantCommand: ToggleClimbArm...");

        m_climbArm = climbArm;
        addRequirements(m_climbArm);
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleClimbArm...");

        if (m_climbArm.armIsUp) {
            Logger.action("RollerArm -> Lowering...");
            BotCommands.retractArm.schedule();
        } else {
            Logger.action("RollerArm -> Raising...");
            BotCommands.turnArm.schedule();
        }
        m_climbArm.toggleArmPosition();

    }
}

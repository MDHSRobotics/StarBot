
package frc.robot.commands.climbhook;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbHook;
import frc.robot.BotCommands;

// Toggles the position of the roller arm
public class ToggleHook extends InstantCommand {

    private ClimbHook m_climbArm;

    public ToggleHook(ClimbHook climbArm) {
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
            BotCommands.moveHookForward.schedule();
        } else {
            Logger.action("RollerArm -> Raising...");
            BotCommands.moveHookBackward.schedule();
        }
        m_climbArm.toggleArmPosition();

    }
}

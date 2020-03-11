
package frc.robot.commands.climblegs;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegs;
import frc.robot.BotCommands;

// Toggles the position of the climb legs.
public class ToggleLegs extends InstantCommand {

    private ClimbLegs m_climbLegs;

    public ToggleLegs(ClimbLegs climbLegs) {
        Logger.setup("Constructing InstantCommand: ToggleLegs...");

        m_climbLegs = climbLegs;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleLegs...");

        if (m_climbLegs.legsAreRetracted) {
            Logger.action("ToggleLegs -> RETRACTING the climb legs...");
            BotCommands.retractLegs.schedule();
        } else {
            Logger.action("ToggleLegs -> EXTENDING the climb legs...");
            BotCommands.extendLegs.schedule();
        }
        m_climbLegs.toggleLegsPosition();
    }

}

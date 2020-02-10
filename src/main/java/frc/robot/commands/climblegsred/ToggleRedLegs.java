
package frc.robot.commands.climblegsred;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsRed;
import frc.robot.BotCommands;

// Toggles the position of the climb legs.
public class ToggleRedLegs extends InstantCommand {

    private ClimbLegsRed m_climbLegsRed;

    public ToggleRedLegs(ClimbLegsRed climbLegsRed) {
        Logger.setup("Constructing InstantCommand: ToggleRedLegs...");

        m_climbLegsRed = climbLegsRed;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleRedLegs...");

        if (m_climbLegsRed.legsAreRetracted) {
            Logger.action("ToggleRedLegs -> RETRACTING the climb legs...");
            BotCommands.retractRedLegs.schedule();
        } else {
            Logger.action("ToggleRedLegs -> EXTENDING the climb legs...");
            BotCommands.extendRedLegs.schedule();
        }
        m_climbLegsRed.toggleLegsPosition();
    }

}

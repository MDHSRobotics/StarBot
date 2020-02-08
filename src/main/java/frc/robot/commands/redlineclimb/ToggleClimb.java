
package frc.robot.commands.redlineclimb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RedLineClimb;
import frc.robot.BotCommands;

// Toggles the position of the climb legs
public class ToggleClimb extends InstantCommand {

    private RedLineClimb m_climb;

    public ToggleClimb(RedLineClimb redLineClimb) {
        Logger.setup("Constructing InstantCommand: ToggleClimb...");

        m_climb = redLineClimb;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleClimb...");

        if (m_climb.legsAreUp) {
            Logger.action("ToggleClimb -> LOWERING the climbing robot legs...");
            BotCommands.lowerClimb.schedule();
        } else {
            Logger.action("ToggleClimb -> LIFTING the climbing robot legs...");
            BotCommands.raiseClimb.schedule();
        }
        m_climb.toggleLegsPosition();
    }

}

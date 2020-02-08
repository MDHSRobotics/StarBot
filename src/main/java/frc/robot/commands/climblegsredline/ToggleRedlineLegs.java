
package frc.robot.commands.climblegsredline;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsRedLine;
import frc.robot.BotCommands;

// Toggles the position of the climb legs
public class ToggleRedlineLegs extends InstantCommand {

    private ClimbLegsRedLine m_climb;

    public ToggleRedlineLegs(ClimbLegsRedLine redLineClimb) {
        Logger.setup("Constructing InstantCommand: ToggleClimb...");

        m_climb = redLineClimb;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleClimb...");

        if (m_climb.legsAreUp) {
            Logger.action("ToggleClimb -> LOWERING the climbing robot legs...");
            BotCommands.retractRedlineLegs.schedule();
        } else {
            Logger.action("ToggleClimb -> LIFTING the climbing robot legs...");
            BotCommands.extendRedlineLegs.schedule();
        }
        m_climb.toggleLegsPosition();
    }

}

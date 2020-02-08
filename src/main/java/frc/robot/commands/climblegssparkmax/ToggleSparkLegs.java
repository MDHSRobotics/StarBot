
package frc.robot.commands.climblegssparkmax;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsSparkMax;
import frc.robot.BotCommands;

// Toggles the position of the climb legs
public class ToggleSparkLegs extends InstantCommand {

    private ClimbLegsSparkMax m_climb;

    public ToggleSparkLegs(ClimbLegsSparkMax climb) {
        Logger.setup("Constructing InstantCommand: ToggleLegs...");

        m_climb = climb;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleLegs...");

        if (m_climb.legsAreUp) {
            Logger.action("ToggleLegs -> LOWERING the climbing robot legs...");
            BotCommands.retractSparkLegs.schedule();
        } else {
            Logger.action("ToggleLegs -> LIFTING the climbing robot legs...");
            BotCommands.extendSparkLegs.schedule();
        }
        m_climb.toggleLegsPosition();
    }

}

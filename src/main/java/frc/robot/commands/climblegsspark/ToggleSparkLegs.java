
package frc.robot.commands.climblegsspark;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsSpark;
import frc.robot.BotCommands;

// Toggles the position of the climb legs.
public class ToggleSparkLegs extends InstantCommand {

    private ClimbLegsSpark m_climbLegsSpark;

    public ToggleSparkLegs(ClimbLegsSpark climbLegsSpark) {
        Logger.setup("Constructing InstantCommand: ToggleSparkLegs...");

        m_climbLegsSpark = climbLegsSpark;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleSparkLegs...");

        if (m_climbLegsSpark.legsAreRetracted) {
            Logger.action("ToggleSparkLegs -> RETRACTING the climb legs...");
            BotCommands.retractSparkLegs.schedule();
        } else {
            Logger.action("ToggleSparkLegs -> EXTENDING the climb legs...");
            BotCommands.extendSparkLegs.schedule();
        }
        m_climbLegsSpark.toggleLegsPosition();
    }

}


package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;
import frc.robot.BotCommands;

// Toggles the position of the Hatcher Claw
public class ToggleLegs extends InstantCommand {

    private Climb m_climb;

    public ToggleLegs(Climb climb) {
        Logger.setup("Constructing InstantCommand: ToggleLegs...");

        m_climb = climb;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleLegs...");

        if (m_climb.legsAreUp) {
            Logger.action("Legs -> Moving to Up...");
            BotCommands.lowerRobot.schedule();
        } else {
            Logger.action("Legs -> Moving to Down...");
            BotCommands.liftRobot.schedule();
        }
        m_climb.toggleLegsPosition();
    }

}

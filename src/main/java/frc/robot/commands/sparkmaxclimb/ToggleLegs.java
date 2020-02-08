
package frc.robot.commands.sparkmaxclimb;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.SparkMaxClimb;
import frc.robot.BotCommands;

// Toggles the position of the climb legs
public class ToggleLegs extends InstantCommand {

    private SparkMaxClimb m_climb;

    public ToggleLegs(SparkMaxClimb climb) {
        Logger.setup("Constructing InstantCommand: ToggleLegs...");

        m_climb = climb;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: ToggleLegs...");

        if (m_climb.legsAreUp) {
            Logger.action("ToggleLegs -> LOWERING the climbing robot legs...");
            BotCommands.lowerRobot.schedule();
        } else {
            Logger.action("ToggleLegs -> LIFTING the climbing robot legs...");
            BotCommands.liftRobot.schedule();
        }
        m_climb.toggleLegsPosition();
    }

}

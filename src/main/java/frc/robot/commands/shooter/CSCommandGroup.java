
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotCommands;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shooter;

// This command stops the Roller
public class CSCommandGroup extends SequentialCommandGroup {

    private Shooter m_shooter;
    private Conveyor m_conveyor;

    public CSCommandGroup(Shooter shooter, Conveyor conveyor) {
        Logger.setup("Constructing Command: PCCommandGroup...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
        m_shooter = shooter;
        addRequirements(m_shooter);

        addCommands(BotCommands.reverseConveyor, BotCommands.shoot);

    }

}

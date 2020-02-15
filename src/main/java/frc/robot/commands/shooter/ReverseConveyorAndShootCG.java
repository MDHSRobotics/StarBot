
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shooter;
import frc.robot.BotCommands;

// This command reverses the conveyor, and then shoots
public class ReverseConveyorAndShootCG extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private Shooter m_shooter;

    public ReverseConveyorAndShootCG(Conveyor conveyor, Shooter shooter) {
        Logger.setup("Constructing SequentialCommandGroup: ReverseConveyorAndShootCG...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);

        addCommands(BotCommands.reverseConveyorCG, BotCommands.shootCG);
    }

}

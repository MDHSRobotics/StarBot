
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotCommands;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Shooter;

// This command reverses the conveyor, and then shoots
public class AutoLineUpAndShoot extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Shooter m_shooter;

    public AutoLineUpAndShoot(Conveyor conveyor, Shooter shooter, DiffDriver diffDriver) {
        Logger.setup("Constructing SequentialCommandGroup: AutoLineUpAndShoot...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        addCommands(BotCommands.autoWait,
                    BotCommands.autoDriveForward,
                    BotCommands.autoRotate,
                    BotCommands.firstAutoDriveToTarget,
                    BotCommands.autoRotate,
                    BotCommands.secondAutoDriveToTarget,
                    BotCommands.reverseConveyorCG,
                    BotCommands.shootCG,
                    BotCommands.stopConveyorCG,
                    BotCommands.StopShooterCG);
    }
}

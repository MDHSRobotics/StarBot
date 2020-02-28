
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotCommands;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Shooter;

public class AutoLineUpAndShootS2 extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Shooter m_shooter;

    public AutoLineUpAndShootS2(Conveyor conveyor, Shooter shooter, DiffDriver diffDriver) {
        Logger.setup("Constructing SequentialCommandGroup: AutoLineUpAndShootS2...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        addCommands(BotCommands.autoWaitS2,
                    BotCommands.autoDriveForwardS2,
                    BotCommands.autoRotateRightS2,
                    BotCommands.firstAutoDriveToTargetS2,
                    BotCommands.autoRotateLeftS2,
                    BotCommands.secondAutoDriveToTargetS2,
                    BotCommands.reverseConveyorCGS2,
                    BotCommands.shootCGS2,
                    BotCommands.stopConveyorCGS2,
                    BotCommands.stopShooterCGS2);

    }
}

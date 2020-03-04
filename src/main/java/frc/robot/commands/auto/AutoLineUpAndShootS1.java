
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotCommands;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Shooter;

public class AutoLineUpAndShootS1 extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Shooter m_shooter;

    public AutoLineUpAndShootS1(Conveyor conveyor, Shooter shooter, DiffDriver diffDriver) {
        Logger.setup("Constructing SequentialCommandGroup: AutoLineUpAndShootS1...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        addCommands(BotCommands.autoWaitS1,
                    BotCommands.reverseConveyorCGS1,
                    BotCommands.shootCGS1,
                    BotCommands.stopConveyorCGS1,
                    BotCommands.stopShooterCGS1,
                    BotCommands.autoRotateLeftS1,
                    BotCommands.autoDriveToWallS1,
                    BotCommands.autoRotateRightS1,
                    BotCommands.autoDriveToPickUpS1,
                    BotCommands.spinRollerAndConveyorCG,
                    BotCommands.autoDriveFromPickUpS1,
                    BotCommands.autoRotateLeftS2,
                    BotCommands.autoDriveFromWallS1,
                    BotCommands.autoRotateRightS2,
                    BotCommands.reverseConveyorCGS1,
                    BotCommands.shootCGS1,
                    BotCommands.stopConveyorCGS1,
                    BotCommands.stopShooterCGS1,
                    BotCommands.autoDriveForwardS1);

    }
}

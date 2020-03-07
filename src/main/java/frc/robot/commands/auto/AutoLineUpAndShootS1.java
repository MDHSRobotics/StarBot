
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
                    BotCommands.firstReverseConveyorCGS1,
                    //BotCommands.firstShootCGS1,
                    BotCommands.firstStopConveyorCGS1,
                    BotCommands.firstStopShooterCGS1,
                    //BotCommands.firstAutoAlignS1,
                    BotCommands.autoDriveAndPickUp,
                    BotCommands.autoDriveFromPickUp,
                    //BotCommands.autoDriveToShoot,
                    //BotCommands.secondAutoAlignS1,
                    BotCommands.secondReverseConveyorCGS1,
                    //BotCommands.secondShootCGS1,
                    BotCommands.secondStopConveyorCGS1,
                    BotCommands.secondStopShooterCGS1,
                    BotCommands.autoDriveForwardS1);

    }
}

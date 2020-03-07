
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotCommands;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Roller;

public class AutoDriveAndPickUp extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Roller m_roller;

    public AutoDriveAndPickUp(DiffDriver diffDriver, Conveyor conveyor, Roller roller) {
        Logger.setup("Constructing SequentialCommandGroup: AutoDriveAndPickUp...");

        // Add given subsystem requirements

        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        m_roller = roller;
        addRequirements(m_roller);

        addCommands(BotCommands.spinRollerAndConveyorCG,
                    BotCommands.autoDriveToPickUp,
                    BotCommands.stopRollerAndConveyorCG);

    }
}

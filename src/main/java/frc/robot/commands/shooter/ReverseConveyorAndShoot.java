
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Conveyor.ConveyorDirection;
import frc.robot.subsystems.Shooter;
import frc.robot.BotSubsystems;
import frc.robot.commands.conveyor.SpinConveyor;

// This command reverses the conveyor, and then shoots.
public class ReverseConveyorAndShoot extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private Shooter m_shooter;

    public ReverseConveyorAndShoot(Conveyor conveyor, Shooter shooter) {
        Logger.setup("Constructing SequentialCommandGroup: ReverseConveyorAndShoot...");

        SpinConveyor spinConveyorBackward = new SpinConveyor(BotSubsystems.conveyor,
                ConveyorDirection.backward);
        ConveyAndShoot conveyAndShoot = new ConveyAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);

        addCommands(spinConveyorBackward.withTimeout(0.5), conveyAndShoot);
    }

}

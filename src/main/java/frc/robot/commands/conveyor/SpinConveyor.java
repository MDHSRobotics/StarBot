
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.oi.movements.ConveyMovement;
import frc.robot.oi.ControlDevices;


// This command spins the Roller
public class SpinConveyor extends InstantCommand {

    private Conveyor m_conveyor;

    public SpinConveyor(Conveyor conveyor) {
        Logger.setup("Constructing InstantCommand: SpinConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing InstantCommand: SpinConveyor...");
            m_conveyor.spin();
    }

}

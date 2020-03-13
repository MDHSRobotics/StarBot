
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Conveyor.ConveyorDirection;

// This command moves the conveyor belt either forwards or backwards.
public class SpinConveyor extends CommandBase {

    private Conveyor m_conveyor;
    private ConveyorDirection conveyorDirection;

    public SpinConveyor(Conveyor conveyor, ConveyorDirection conveyorDirection) {
        Logger.setup("Constructing Command: SpinConveyor...");

        this.conveyorDirection = conveyorDirection;

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: SpinConveyor...");
    }

    @Override
    public void execute() {
        m_conveyor.spin(conveyorDirection);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: SpinConveyor...");
        } else {
            Logger.ending("Ending Command: SpinConveyor...");
        }
        m_conveyor.stop();
    }

}

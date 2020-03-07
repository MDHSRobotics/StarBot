
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

// This command moves the conveyor belt forward.
public class ForwardConveyorCG extends CommandBase {

    private Conveyor m_conveyor;

    public ForwardConveyorCG(Conveyor conveyor) {
        Logger.setup("Constructing Command: ForwardConveyorCG...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ForwardConveyorCG...");
    }

    @Override
    public void execute() {
        m_conveyor.forward();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: ForwardConveyorCG...");
        } else {
            Logger.ending("Ending Command: ForwardConveyorCG...");
        }
        m_conveyor.stop();
    }

}

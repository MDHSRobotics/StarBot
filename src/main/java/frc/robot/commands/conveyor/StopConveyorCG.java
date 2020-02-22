
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

// This command stops the Conveyor
public class StopConveyorCG extends CommandBase {

    private Conveyor m_conveyor;
    private static boolean conveyorIsStopped = false;

    public StopConveyorCG(Conveyor conveyor) {
        Logger.setup("Constructing Command: StopConveyorCG...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopConveyorCG...");
    }

    @Override
    public void execute() {
        m_conveyor.stop();
        conveyorIsStopped = true;
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return conveyorIsStopped;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: StopConveyorCG...");
        } else {
            Logger.ending("Ending Command: StopConveyorCG...");
        }

        m_conveyor.stop();
    }

}

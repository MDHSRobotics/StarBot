
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Roller;

// This command spins the Roller and moves the Conveyor forward.
public class StopRollerAndConveyorCG extends CommandBase {

    private Conveyor m_conveyor;
    private Roller m_roller;

    public StopRollerAndConveyorCG(Roller roller, Conveyor conveyor) {
        Logger.setup("Constructing Command: StopRollerAndConveyor...");

        // Add given subsystem requirements
        m_roller = roller;
        addRequirements(m_roller);

        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopRollerAndConveyorCG...");
    }

    @Override
    public void execute() {
        m_roller.stop();
        m_conveyor.stop();
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: StopRollerAndConveyorCG...");
        } else {
            Logger.ending("Ending Command: StopRollerAndConveyorCG...");
        }
    }

}

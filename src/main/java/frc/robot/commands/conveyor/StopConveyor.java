
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

// This command stops the Roller
public class StopConveyor extends CommandBase {

    private Conveyor m_conveyor;

    public StopConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: StopConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopConveyor...");
    }

    @Override
    public void execute() {
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
            Logger.ending("Interrupting Command: StopConveyor...");
        } else {
            Logger.ending("Ending Command: StopConveyor...");
        }

        m_conveyor.stop();
    }

}

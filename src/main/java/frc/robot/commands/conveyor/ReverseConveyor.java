
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

// This command moves the conveyor belt forward
public class ReverseConveyor extends CommandBase {

    private Conveyor m_conveyor;

    public ReverseConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: ReverseConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ReverseConveyor...");
    }

    @Override
    public void execute() {
        m_conveyor.reverse();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: ReverseConveyor...");
        } else {
            Logger.ending("Ending Command: ReverseConveyor...");
        }

        m_conveyor.stop();
    }

}

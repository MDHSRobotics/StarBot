
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

// This command moves the conveyor belt forward
public class ForwardConveyor extends CommandBase {

    private Conveyor m_conveyor;

    public ForwardConveyor(Conveyor conveyor) {
        Logger.setup("Constructing Command: ForwardConveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ForwardConveyor...");
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
            Logger.ending("Interrupting Command: ForwardConveyor...");
        } else {
            Logger.ending("Ending Command: ForwardConveyor...");
        }

        m_conveyor.stop();
    }

}

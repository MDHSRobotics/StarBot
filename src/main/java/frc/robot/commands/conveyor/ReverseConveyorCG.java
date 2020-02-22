
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;

// This command moves the conveyor belt backward
public class ReverseConveyorCG extends CommandBase {

    private Conveyor m_conveyor;
    private Timer m_timer = new Timer();

    public ReverseConveyorCG(Conveyor conveyor) {
        Logger.setup("Constructing Command: ReverseConveyorCG...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ReverseConveyorCG...");
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        m_conveyor.reverse();
    }

    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();
        if (currentTime > 0.5) {
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: ReverseConveyorCG...");
        } else {
            Logger.ending("Ending Command: ReverseConveyorCG...");
        }

        m_conveyor.stop();
    }

}
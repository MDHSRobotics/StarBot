
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Shooter;

// This command stops the conveyor and shooter
public class StopConveyorAndShooterCG extends CommandBase {

    private Conveyor m_conveyor;
    private Shooter m_shooter;

    public StopConveyorAndShooterCG(Conveyor conveyor, Shooter shooter) {
        Logger.setup("Constructing Command: StopConveyorAndShooterCG...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopConveyorAndShooterCG...");
    }

    @Override
    public void execute() {
        m_conveyor.stop();
        m_shooter.stop();
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
            Logger.ending("Interrupting Command: StopConveyorAndShooterCG...");
        } else {
            Logger.ending("Ending Command: StopConveyorAndShooterCG...");
        }
    }

}

package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Conveyor;

// This command deactivates the shoot mechanism
public class StopCSCommandGroup extends CommandBase {

    private Shooter m_shooter;
    private Conveyor m_conveyor;

    public StopCSCommandGroup(Shooter shooter, Conveyor conveyor) {
        Logger.setup("Constructing Command: StopCSCommandGroup...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);

        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopCSCommandGroup...");
    }

    @Override
    public void execute() {
        m_shooter.stop();
        m_conveyor.stop();
    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: StopCSCommandGroup...");
        } else {
            Logger.ending("Ending Command: StopCSCommandGroup...");
        }
    }

}
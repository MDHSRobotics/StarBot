package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;
import frc.robot.consoles.tabs.ShooterTab;

// This command activates the shoot mechanism
public class ResetShoot extends CommandBase {

    private Shooter m_shooter;

    public ResetShoot(Shooter shooter) {
        Logger.setup("Constructing Command: ResetShoot...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ResetShoot...");

        // m_shooterTab.reset(); TODO move to subsystem

        Logger.action("Shooter min/max velocity values RESET!");
    }

    @Override
    public void execute() {

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
            Logger.ending("Interrupting Command: ResetShoot...");
        } else {
            Logger.ending("Ending Command: ResetShoot...");
        }
    }

}
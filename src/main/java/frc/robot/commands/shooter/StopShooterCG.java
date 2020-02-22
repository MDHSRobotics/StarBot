
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

// This command deactivates the shoot mechanism
public class StopShooterCG extends CommandBase {

    private Shooter m_shooter;

    public StopShooterCG(Shooter shooter) {
        Logger.setup("Constructing Command: StopShooterCG...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopShooterCG...");
    }

    @Override
    public void execute() {
        m_shooter.stop();
    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: StopShooterCG...");
        } else {
            Logger.ending("Ending Command: StopShooterCG...");
        }
    }

}

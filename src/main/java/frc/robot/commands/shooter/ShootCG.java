package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;

// This command activates the shoot mechanism
public class ShootCG extends CommandBase {

    private Shooter m_shooter;

    public ShootCG(Shooter shooter) {
        Logger.setup("Constructing Command: ShootCG...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ShootCG...");

        m_shooter.spinTopWheel();
        m_shooter.spinBottomWheel();

        // m_shooter.testMotor();
    }

    @Override
    public void execute() {
        double topVelocity = m_shooter.getTopWheelVelocity();
        double bottomVelocity = m_shooter.getBottomWheelVelocity();
        double topVelocityFPS = m_shooter.getTopWheelVelocityFPS();
        double bottomVelocityFPS = m_shooter.getBottomWheelVelocityFPS();

        Logger.info("Top wheel velocity: " + topVelocity);
        Logger.info("Top wheel fps: " + topVelocityFPS);
        Logger.info("\n Bottom wheel velocity: " + bottomVelocity);
        Logger.info("Bottom wheel fps: " + bottomVelocityFPS);
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
            Logger.ending("Interrupting Command: ShootCG...");
        } else {
            Logger.ending("Ending Command: ShootCG...");
        }
    }

}
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Conveyor;
import edu.wpi.first.wpilibj.Timer;

// This command activates the shoot mechanism
public class Shoot extends CommandBase {

    private Shooter m_shooter;
    private Conveyor m_conveyor;
    private Timer m_timer = new Timer();

    public Shoot(Shooter shooter, Conveyor conveyor) {
        Logger.setup("Constructing Command: Shoot...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);

        m_conveyor = conveyor;
        addRequirements(m_conveyor);

    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: Shoot...");
        m_timer.reset();
        m_timer.start();

        m_shooter.spinTopWheel();
        m_shooter.spinBottomWheel();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        if  (currentTime > 1) {
            m_conveyor.forward();
        }
        double topVelocity = m_shooter.getTopWheelVelocity();
        double bottomVelocity = m_shooter.getBottomWheelVelocity();

        Logger.info("Top wheel velocity: " + topVelocity);
        Logger.info("Bottom wheel velocity: " + bottomVelocity);
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
            Logger.ending("Interrupting Command: Shoot...");
        } else {
            Logger.ending("Ending Command: Shoot...");
        }
    }

}
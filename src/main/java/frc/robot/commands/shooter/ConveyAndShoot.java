
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Conveyor;

// This command starts the Shooter, waits one second, and then moves the Conveyor forward.
public class ConveyAndShoot extends CommandBase {

    private Shooter m_shooter;
    private Conveyor m_conveyor;
    private Timer m_timer = new Timer();

    public ConveyAndShoot(Shooter shooter, Conveyor conveyor) {
        Logger.setup("Constructing Command: ConveyAndShoot...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);

        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ConveyAndShoot...");
        m_timer.reset();
        m_timer.start();

        m_shooter.spinBottomWheel();
        m_shooter.spinTopWheel();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        if  (currentTime > 1) {
            m_conveyor.forward();
        }
        double bottomVelocity = m_shooter.getBottomWheelVelocity();
        double topVelocity = m_shooter.getTopWheelVelocity();

        Logger.info("Bottom wheel velocity: " + bottomVelocity);
        Logger.info("Top wheel velocity: " + topVelocity);
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
            Logger.ending("Interrupting Command: Shoot...");
        } else {
            Logger.ending("Ending Command: Shoot...");
        }
    }

}

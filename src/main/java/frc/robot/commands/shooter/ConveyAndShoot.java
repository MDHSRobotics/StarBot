
package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Conveyor;

// This command starts the Shooter, waits one second, and then moves the Conveyor forward.
public class ConveyAndShoot extends CommandBase {

    private Conveyor m_conveyor;
    private Shooter m_shooter;
    private Timer m_timer = new Timer();

    public ConveyAndShoot(Conveyor conveyor, Shooter shooter) {
        Logger.setup("Constructing Command: ConveyAndShoot...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: ConveyAndShoot...");
        m_timer.reset();
        m_timer.start();

        m_shooter.shootWithDistance();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        if  (currentTime > 1) {
            m_conveyor.forward();
        }
        double bottomVelocity = m_shooter.getBottomWheelVelocity();
        double topVelocity = m_shooter.getTopWheelVelocity();

        Logger.info("ConveyAndShoot -> Bottom wheel velocity: " + bottomVelocity);
        Logger.info("ConveyAndShoot -> Top wheel velocity: " + topVelocity);
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
            Logger.ending("Interrupting Command: ConveyAndShoot...");
        } else {
            Logger.ending("Ending Command: ConveyAndShoot...");
        }
    }

}

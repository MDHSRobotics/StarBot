package frc.robot.commands.shooter;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Conveyor;
import frc.robot.sensors.DistanceSensor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.consoles.Logger;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.Shooter;

// This command activates the shoot mechanism
public class LineUpAndShoot extends CommandBase {

    private Shooter m_shooter;
    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Gyro m_gyro;

    private Timer m_timer = new Timer();

    private double INITIAL_ANGLE = 0.0;
    private static double targetAngle;

    public LineUpAndShoot(Shooter shooter, Conveyor conveyor, Gyro gyro, DiffDriver diffDriver) {
        Logger.setup("Constructing Command: LineUpAndShoot...");

        // Add given subsystem requirements
        m_shooter = shooter;
        addRequirements(m_shooter);

        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        m_gyro = gyro;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LineUpAndShoot...");
        m_timer.reset();
        m_timer.start();

        m_gyro.getAngle();
    }

    @Override
    public void execute() {
        double currentAngle = m_gyro.getAngle();
        double angleElapsed = currentAngle - INITIAL_ANGLE;

        m_diffDriver.centerOnTarget();
        m_diffDriver.isAligned(targetAngle);

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
            Logger.ending("Interrupting Command: LineUpAndShoot...");
        } else {
            Logger.ending("Ending Command: LineUpAndShoot...");
        }
    }

}
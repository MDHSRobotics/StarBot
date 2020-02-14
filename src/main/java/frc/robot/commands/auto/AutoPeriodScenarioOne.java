package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BotSensors;
import frc.robot.consoles.Logger;
import frc.robot.sensors.DistanceSensor;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time
public class AutoPeriodScenarioOne extends CommandBase {

    private DiffDriver m_diffDriver;
    private Gyro m_gyro;

    private Timer m_timer = new Timer();
    private double m_timeLastPrinted = 0.0;

    private double TOTAL_DISTANCE;
    private double DISTANCE_x_FROM_TARGET;
    private double DISTANCE_Y_FROM_TARGET;
    private double INITIAL_ANGLE = 0.0;
    private double RIGHT_ANGLE = 90.0;

    private int timesTurned = 1;

    private static final double MAX_DRIVE_SECONDS = 15.0;

    public AutoPeriodScenarioOne(DistanceSensor distanceSensor, Gyro gyro, DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveForward...");

        m_gyro = gyro;

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveForward...");

        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        double timeElapsedSincePrint = currentTime - m_timeLastPrinted;

        double currentAngle = m_gyro.getAngle();
        double angleElapsed = currentAngle - INITIAL_ANGLE;

        if (timeElapsedSincePrint > 1.0) {
            Logger.action("AutoDriveForward: -> Moved Forward for " + currentTime);
            m_timeLastPrinted = currentTime;
        }
        m_gyro.getAngle();

        if (angleElapsed < RIGHT_ANGLE * timesTurned) {
            m_diffDriver.driveTank(0.5, -0.5);
        }
        else {
            angleElapsed -= currentAngle;
            if (timesTurned == 1) {
                DISTANCE_x_FROM_TARGET = TOTAL_DISTANCE - DistanceSensor.getDistanceInMeters();
            }
            if (timesTurned <= 3)
                timesTurned++;
            else
                m_diffDriver.stop();
                m_diffDriver.centerOnTarget();
        }
    }

    // This command continues until it MAX_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (currentTime < MAX_DRIVE_SECONDS) {
            return false;
        } else {
            Logger.action("AutoDriveForward: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoDriveForward...");
        } else {
            Logger.ending("Ending Command: AutoDriveForward...");
        }
    }

}

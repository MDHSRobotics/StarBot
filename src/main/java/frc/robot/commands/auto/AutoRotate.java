package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;
import frc.robot.sensors.DistanceSensor;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time
public class AutoRotate extends CommandBase {

    private DiffDriver m_diffDriver;
    private Gyro m_gyro;

    public double TOTAL_DISTANCE_X;
    public double DISTANCE_x_FROM_TARGET;
    public double DISTANCE_Y_FROM_TARGET;
    private double INITIAL_ANGLE = 0.0;
    private double RIGHT_ANGLE = 90.0;

    private int timesTurned = 1;

    public AutoRotate(Gyro gyro, DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveForward...");

        m_gyro = gyro;

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoRotate...");
    }

    @Override
    public void execute() {

        double currentAngle = m_gyro.getAngle();
        double angleElapsed = currentAngle - INITIAL_ANGLE;

        m_gyro.getAngle();

        if (angleElapsed < RIGHT_ANGLE * timesTurned && timesTurned <= 3) {
            m_diffDriver.driveTank(0.5, -0.5);
        }
        else {
            angleElapsed -= currentAngle;
            if (timesTurned == 1) {
                DISTANCE_x_FROM_TARGET = TOTAL_DISTANCE_X - DistanceSensor.getDistanceInMeters();
                timesTurned++;
            }
            if (timesTurned == 2) {
                DISTANCE_Y_FROM_TARGET = DistanceSensor.getDistanceInMeters();
                timesTurned++;
            }
            if (timesTurned == 3) {
                m_diffDriver.stop();
                timesTurned++;
            }
        }
    }

    // This command continues until it MAX_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        if (timesTurned <= 3) {
            return false;
        } else {
            Logger.action("AutoRotate: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoRotate...");
        } else {
            Logger.ending("Ending Command: AutoRotate...");
        }
    }

}

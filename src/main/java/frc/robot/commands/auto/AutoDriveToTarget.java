package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;
import frc.robot.sensors.DistanceSensor;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time
public class AutoDriveToTarget extends CommandBase {

    private DiffDriver m_diffDriver;

    private double distanceTraveled = (Encoder ticks / 360) * circumference;

    private boolean isDistanceReached = false;

    public AutoDriveToTarget(DistanceSensor distanceSensor, Gyro gyro, DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveToTarget...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        double encoderDistanceReading = encoder.getDistance();
        SmartDashboard.putNumber("encoder reading", encoderDistanceReading);

        encoder.reset();
        encoder.setDistancePerPulse(5);
        encoder.getDistance();
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveToTarget...");
    }

    @Override
    public void execute() {
        double encodersReading = encoder.get();
        m_diffDriver.driveTank(0.5, 0.5);

		if (encodersReading > desiredDistance) {
            m_diffDriver.stop();
            isDistanceReached = true;
        }
    }

    // This command continues until it MAX_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        if (!isDistanceReached) {
            return false;
        }
        else {
            m_diffDriver.stop();
            Logger.action("AutoDriveToTarget: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoDriveToTarget...");
        } else {
            Logger.ending("Ending Command: AutoDriveToTarget...");
        }
    }

}

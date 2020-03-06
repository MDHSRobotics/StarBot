package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time.
public class AutoDriveFromPickUp extends CommandBase {

    private DiffDriver m_diffDriver;

    private Timer m_timer = new Timer();
    private double m_timeLastPrinted = 0.0;

    private static final double MAX_DRIVE_SECONDS = 3.5;

    private static final double TARGET_YAW = 0.0;

    public AutoDriveFromPickUp(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveFromPickUp...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveFromPickUp...");

        m_timer.reset();
        m_timer.start();

    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        double timeElapsedSincePrint = currentTime - m_timeLastPrinted;

        if (timeElapsedSincePrint > 1.0) {
            Logger.action("AutoDriveForward: -> Moved Forward for " + currentTime);
            m_timeLastPrinted = currentTime;
        }
        m_diffDriver.driveAlign(TARGET_YAW);
    }

    // This command continues until it target is reached
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (currentTime < MAX_DRIVE_SECONDS) {
            return false;
        } else {
            Logger.action("AutoDriveFromPickUp: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoDriveFromPickUp...");
        } else {
            Logger.ending("Ending Command: AutoDriveFromPickUp...");
        }

        m_diffDriver.stop();
    }

}

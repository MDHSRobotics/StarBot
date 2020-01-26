package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward, follows a path, and then shoots.
public class AutoDriveForwardShoot extends CommandBase {

    private DiffDriver m_diffDriver;

    private Timer m_timer = new Timer();
    private double m_timeLastPrinted = 0.0;

    private static final double MAX_DRIVE_SECONDS = 5.0;
    private static final double DELAY_DRIVE_SECONDS = 2.0;

    public AutoDriveForwardShoot(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveForwardShoot...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveForwardShoot...");

        Timer.delay(DELAY_DRIVE_SECONDS); // to avoid robots from starting at the same time
        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        double timeElapsedSincePrint = currentTime - m_timeLastPrinted;

        if (timeElapsedSincePrint > 1.0) {
            Logger.action("AutoDriveForwardShoot: -> Moved Forward for " + currentTime);
            m_timeLastPrinted = currentTime;
        }
        m_diffDriver.moveForwardAuto();
    }

    // This command continues until it MAX_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (currentTime < MAX_DRIVE_SECONDS)
            return false;

        else {
            Logger.action("AutoDriveForwardShoot: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoDriveForwardShoot...");
        } else {
            Logger.ending("Ending Command: AutoDriveForwardShoot...");
        }
    }

}

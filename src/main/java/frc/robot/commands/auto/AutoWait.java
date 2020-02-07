package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;

// This command waits two second before autoDriveForward() is executed

public class AutoWait extends CommandBase {

    private Timer m_timer = new Timer();
    private double m_timeLastPrinted = 0.0;

    private static final double DELAY_DRIVE_SECONDS = 2.0;

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoWait...");

        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        double timeElapsedSincePrint = currentTime - m_timeLastPrinted;

        if (timeElapsedSincePrint > 1.0) {
            Logger.action("AutoWait: -> Moved Forward for " + currentTime);
            m_timeLastPrinted = currentTime;
        }

    }

    // This command continues until it DELAY_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (currentTime < DELAY_DRIVE_SECONDS) {
            return false;
        } else {
            Logger.action("AutoWait: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoWait...");
        } else {
            Logger.ending("Ending Command: AutoWait...");
        }
    }

}

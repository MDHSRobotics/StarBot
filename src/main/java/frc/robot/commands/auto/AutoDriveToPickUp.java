package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Roller;

// This command auto drives the DiffDriver forward for a short time.
public class AutoDriveToPickUp extends CommandBase {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Roller m_roller;

    private Timer m_timer = new Timer();
    private double m_timeLastPrinted = 0.0;

    private static final double MAX_DRIVE_SECONDS = 4.0;
    private static final double TARGET_YAW = 0.0;

    public AutoDriveToPickUp(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveToPickUp...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveToPickUp...");

        m_timer.reset();
        m_timer.start();
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        double timeElapsedSincePrint = currentTime - m_timeLastPrinted;

        if (timeElapsedSincePrint > 1.0) {
            Logger.action("AutoDriveToPickUp: -> Moved Forward for " + currentTime);
            m_timeLastPrinted = currentTime;
        }
        m_roller.spin();
        m_conveyor.forward();
        m_diffDriver.driveAlign(TARGET_YAW);
    }

    // This command continues until it MAX_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (currentTime < MAX_DRIVE_SECONDS) {
            return false;
        } else {
            Logger.action("AutoDriveToPickUp: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoDriveToPickUp...");
        } else {
            Logger.ending("Ending Command: AutoDriveToPickUp...");
        }

        m_roller.stop();
        m_conveyor.stop();
        m_diffDriver.stop();
    }

}

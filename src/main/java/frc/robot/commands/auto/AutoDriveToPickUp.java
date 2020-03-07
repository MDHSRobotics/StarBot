package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BotSensors;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time.
public class AutoDriveToPickUp extends CommandBase {

    private DiffDriver m_diffDriver;

    public static double DISTANCE_X_FROM_TARGET;
    private static double currentDistance;

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

        DISTANCE_X_FROM_TARGET = DiffDriver.distance;
    }

    @Override
    public void execute() {
        m_diffDriver.driveAlign(TARGET_YAW);
    }

    // This command continues until it target is reached
    @Override
    public boolean isFinished() {
        if (currentDistance - DISTANCE_X_FROM_TARGET < DISTANCE_X_FROM_TARGET) {
            return false;
        } else {
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

        m_diffDriver.stop();
    }

}

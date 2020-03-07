package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BotSensors;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time.
public class AutoDriveFromPickUp extends CommandBase {

    private DiffDriver m_diffDriver;

    private static double targetMin = 4.8;
    private static double targetMax = 4.87;

    private static boolean isDistanceReached = false;

    public AutoDriveFromPickUp(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveFromPickUp...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveFromPickUp...");
    }

    @Override
    public void execute() {
        isDistanceReached = m_diffDriver.driveToWithinRange(BotSensors.distanceSensorFront, targetMin, targetMax);
    }

    // This command continues until it target is reached
    @Override
    public boolean isFinished() {
        return isDistanceReached;
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

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.BotSensors;
import frc.robot.consoles.Logger;
import frc.robot.sensors.Limelight;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time.
public class AutoDriveToShoot extends CommandBase {

    private DiffDriver m_diffDriver;
    private Limelight m_Limelight;

    private static final double TARGET_YAW = 0.0;
    private static final double DISTANCE_X_FROM_TARGET = 3.05;
    private static double currentXDistanceFromTarget;

    public AutoDriveToShoot(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDriveToShoot...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveToShoot...");

        currentXDistanceFromTarget = BotSensors.m_Limelight.getXOffset();
    }

    @Override
    public void execute() {
        if (currentXDistanceFromTarget < DISTANCE_X_FROM_TARGET) {
            m_diffDriver.driveAlign(TARGET_YAW);
        } else {
            m_diffDriver.stop();
        }
    }

    // This command continues until it target is reached
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoDriveToShoot...");
        } else {
            Logger.ending("Ending Command: AutoDriveToShoot...");
        }

        m_diffDriver.stop();
    }

}

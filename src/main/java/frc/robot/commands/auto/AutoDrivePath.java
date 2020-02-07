package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BotSubsystems;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

import java.io.IOException;
import java.nio.file.Path;

// This command automatically a predetermined pathweaver path.
public class AutoDrivePath extends CommandBase {

    private DiffDriver m_diffDriver;
    private Path m_trajectoryPath;
    private Trajectory m_trajectory;

    private boolean m_ableToOpenTrajectory = false;

    public AutoDrivePath(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoDrivePath...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDrivePath...");

        String trajectoryJSON = "paths/testScenario.wpilib.json";

        try {
            m_trajectoryPath = Filesystem.getDeployDirectory().toPath().resolve(trajectoryJSON);
            m_trajectory = TrajectoryUtil.fromPathweaverJson(m_trajectoryPath);
            m_ableToOpenTrajectory = true;

            Logger.info("Trajectory created.");
        }

        catch (IOException ex) {
            DriverStation.reportError("Unable to open trajectory: " + trajectoryJSON, ex.getStackTrace());
        }
    }

    @Override
    public void execute() {
        if (m_ableToOpenTrajectory) {
            BotSubsystems.diffDriver.driveAlongTrajectory(m_trajectory);
        }
    }

    // This command continues until
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }

}
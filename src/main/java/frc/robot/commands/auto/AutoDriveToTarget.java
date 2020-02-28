package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BotSensors;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time
public class AutoDriveToTarget extends CommandBase {

    private DiffDriver m_diffDriver;

    private boolean m_isDistanceReached = false;

    private double m_targetMax;
    private double m_targetMin;

    public AutoDriveToTarget(DiffDriver diffDriver, double targetMin, double targetMax) {
        Logger.setup("Constructing Command: AutoDriveToTarget...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        m_targetMin = 3.0;  //targetMin
        m_targetMax = 3.048;  //targetMax
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveToTarget...");
    }

    @Override
    public void execute() {
        m_isDistanceReached = m_diffDriver.driveToWithinRange(BotSensors.distanceSensorFront, m_targetMin, m_targetMax);
    }

    @Override
    public boolean isFinished() {
        return m_isDistanceReached;
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

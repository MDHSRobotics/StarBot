
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Limelight;
import frc.robot.subsystems.DiffDriver;
import frc.robot.BotSensors;

// DiffDrive uses gyro and limelight to align to the target.
public class AlignDiffDriveToTarget extends CommandBase {

    private DiffDriver m_diffDriver;
    private double m_targetAngle = 0;

    public AlignDiffDriveToTarget(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AlignDiffDriveToTarget...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        float yaw = BotSensors.gyro.getYaw();
        double xOffset = Limelight.getXOffset();
        m_targetAngle = yaw + xOffset;
    }

    @Override
    public void execute() {
        if (m_targetAngle != 0) {
            m_diffDriver.driveAlign(m_targetAngle);
        }
    }

    // This finishes immediately, but is intended to be continually restarted while a button is held
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AlignDiffDriveToTarget...");
        }
    }

}

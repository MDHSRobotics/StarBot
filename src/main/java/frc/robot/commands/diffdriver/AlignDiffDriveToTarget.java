
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.LimelightBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;
import frc.robot.BotSensors;

// DiffDrive uses limelight to align to the target.
public class AlignDiffDriveToTarget extends CommandBase {

    private DiffDriver m_diffDriver;
    private static double m_targetAngle = 0;

    public AlignDiffDriveToTarget(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AlignDiffDriveToTarget...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing Command: AlignDiffDriveToTarget...");

        double yaw = BotSensors.gyro.getYaw();
        double xOffset = LimelightBrain.getXOffset();
        m_targetAngle = yaw + xOffset;
    }

    @Override
    public void execute() {
        if (m_targetAngle != 0) {
            m_diffDriver.driveAlign(m_targetAngle);
        }
    }

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

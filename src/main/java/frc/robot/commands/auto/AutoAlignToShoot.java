
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Limelight;
import frc.robot.subsystems.DiffDriver;
import frc.robot.BotSensors;

// DiffDrive uses gyro and limelight to align to the target.
public class AutoAlignToShoot extends CommandBase {

    private DiffDriver m_diffDriver;
    private double m_targetAngle = 0;

    private boolean m_isAligned = false;

    public AutoAlignToShoot(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AlignDiffDriveToTarget...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        // LEDs turned off in TurnOffLimelightArray command
        Limelight.ledOn();

        float yaw = BotSensors.gyro.getYaw();
        double xOffset = Limelight.getXOffset();
        m_targetAngle = yaw + xOffset;

        m_isAligned = false;
    }

    @Override
    public void execute() {
        Limelight.calculateDistanceToTarget();

        m_isAligned = m_diffDriver.driveAlign(m_targetAngle);
    }

    // This finishes immediately, but is intended to be continually restarted while a button is held
    @Override
    public boolean isFinished() {
        return m_isAligned;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AlignDiffDriveToTarget...");
        }
    }

}
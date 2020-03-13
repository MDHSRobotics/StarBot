
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Limelight;
import frc.robot.subsystems.DiffDriver;
import frc.robot.BotSensors;

// DiffDrive uses gyro and limelight to align to the target
public class AlignToTarget extends CommandBase {

    private DiffDriver m_diffDriver;
    private double m_targetAngle = 0;
    private boolean m_isAligned = false;

    public AlignToTarget(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AlignToTarget...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        m_isAligned = false;

        // LEDs turned off in TurnOffLimelightArray command
        Limelight.ledOn();

        float yaw = BotSensors.gyro.getYaw();
        double xOffset = Limelight.getXOffset();
        m_targetAngle = yaw + xOffset;
    }

    @Override
    public void execute() {
        m_isAligned = m_diffDriver.driveAlign(m_targetAngle);
    }

    // This finishes when the robot is aligned
    @Override
    public boolean isFinished() {
        return m_isAligned;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AlignToTarget...");
        }
    }

}

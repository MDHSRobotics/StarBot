
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.DPadButton;
import frc.robot.subsystems.DiffDriver;
import frc.robot.BotControllers;

// Automatically control the DiffDrive to align the Robot with the gyro.
public class AlignDiffDriveToGyro extends CommandBase {

    private DiffDriver m_diffDriver;
    private int m_targetAngle = -1;

    public AlignDiffDriveToGyro(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AlignDiffDriveToGyro...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing Command: AlignDiffDriveToGyro...");

        m_targetAngle = DPadButton.getDpadAngleForGyro(BotControllers.primary.xbox);
    }

    @Override
    public void execute() {
        if (m_targetAngle != -1) {
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
            Logger.ending("Interrupting Command: AlignDiffDriveToGyro...");
        } else {
            Logger.ending("Ending Command: AlignDiffDriveToGyro...");
        }
    }

}

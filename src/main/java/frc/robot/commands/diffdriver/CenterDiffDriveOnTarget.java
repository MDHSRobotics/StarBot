package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// Automatically control the DiffDrive to align the Robot with the gyro.
public class CenterDiffDriveOnTarget extends CommandBase {

    private DiffDriver m_diffDriver;

    public CenterDiffDriveOnTarget(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: CenterDiffDriveOnTarget...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing Command: CenterDiffDriveOnTarget...");
    }

    @Override
    public void execute() {
        m_diffDriver.centerOnTarget();
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
            Logger.ending("Interrupting Command: CenterDiffDriveOnTarget...");
        } else {
            Logger.ending("Ending Command: CenterDiffDriveOnTarget...");
        }
    }

}

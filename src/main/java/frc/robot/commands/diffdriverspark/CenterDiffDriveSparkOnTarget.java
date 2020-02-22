
package frc.robot.commands.diffdriverspark;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriverSpark;

// Assisted control the DiffDrive to center the robot on the shoot target.
public class CenterDiffDriveSparkOnTarget extends CommandBase {

    private DiffDriverSpark m_diffDriverSpark;

    public CenterDiffDriveSparkOnTarget(DiffDriverSpark diffDriverSpark) {
        Logger.setup("Constructing Command: CenterDiffDriveSparkOnTarget...");

        // Add given subsystem requirements
        m_diffDriverSpark = diffDriverSpark;
        addRequirements(m_diffDriverSpark);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_diffDriverSpark.centerOnTarget();
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
            Logger.ending("Interrupting Command: CenterDiffDriveSparkOnTarget...");
        }
    }

}

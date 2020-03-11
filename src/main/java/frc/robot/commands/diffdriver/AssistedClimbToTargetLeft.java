
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// DiffDrive uses gyro and limelight to align to the target.
public class AssistedClimbToTargetLeft extends CommandBase {

    private DiffDriver m_diffDriver;
    private double m_targetAngle = 67.52;

    public AssistedClimbToTargetLeft(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AssistedClimbToTargetLeft...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.setup("Initialize Command: AssistedClimbToTargetLeft...");
    }

    @Override
    public void execute() {

        m_diffDriver.driveAlign(m_targetAngle);
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
            Logger.ending("Interrupting Command: AssistedClimbToTargetRight...");
        }
    }

}

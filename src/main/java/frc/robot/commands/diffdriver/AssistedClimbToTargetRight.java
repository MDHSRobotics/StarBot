
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// DiffDrive uses gyro and limelight to align to the target.
public class AssistedClimbToTargetRight extends CommandBase {

    private DiffDriver m_diffDriver;
    private double m_targetAngle = -112.48;

    public AssistedClimbToTargetRight(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AssistedClimbToTargetRight...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.setup("Initialize Command: AssistedClimbToTargetRight...");
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

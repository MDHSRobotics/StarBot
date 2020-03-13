
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// Rotates the differential drive towards the rung on the generator switch.
public class RotateTowardsRung extends CommandBase {

    private DiffDriver m_diffDriver;
    private double m_targetAngle;

    public RotateTowardsRung(DiffDriver diffDriver, double targetAngle) {
        Logger.setup("Constructing Command: RotateTowardsRung...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        m_targetAngle = targetAngle;
    }

    @Override
    public void initialize() {
        Logger.setup("Initialize Command: RotateTowardsRung...");
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
            Logger.ending("Interrupting Command: RotateTowardsRung...");
        }
    }

}

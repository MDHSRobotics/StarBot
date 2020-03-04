package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time.
public class AutoAlign extends CommandBase {

    private DiffDriver m_diffDriver;

    private boolean isAligned = false;

    private static final double INITIAL_ANGLE = 0.0;

    public AutoAlign(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoAlign...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoAlign...");
    }

    @Override
    public void execute() {
        isAligned = DiffDriver.isAligned(INITIAL_ANGLE);
    }

    // This command continues until it MAX_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        return isAligned;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoAlign...");
        } else {
            Logger.ending("Ending Command: AutoAlign...");
        }

        m_diffDriver.stop();
    }

}

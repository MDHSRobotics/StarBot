package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// Assisted control the DiffDrive to drive within a range based on a distance sensor.
public class DriveDiffToWithinRange extends CommandBase {

    private DiffDriver m_diffDriver;
    private AnalogInput m_distanceSensor;
    private double m_targetMinimum;
    private double m_targetMaximum;

    public DriveDiffToWithinRange(DiffDriver diffDriver, AnalogInput distanceSensor, double targetMinimum, double targetMaximum) {
        Logger.setup("Constructing Command: DriveDiffToWithinRange...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        m_distanceSensor = distanceSensor;
        m_targetMinimum = targetMinimum;
        m_targetMaximum = targetMaximum;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_diffDriver.driveToWithinRange(m_distanceSensor, m_targetMinimum, m_targetMaximum);
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
            Logger.ending("Interrupting Command: DriveDiffToWithinRange...");
        }
    }

}


package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// Aligns the robot to an input angle
public class AlignToAngle extends CommandBase {

    public GenericHID controller;
    private DiffDriver m_diffDriver;
    private double m_targetAngle;
    private boolean m_isAligned = false;

    public AlignToAngle(DiffDriver diffDriver, double targetAngle) {
        Logger.setup("Constructing Command: AlignToAngle...");

        m_targetAngle = targetAngle;

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        m_isAligned = false;
    }

    @Override
    public void execute() {
        m_isAligned = m_diffDriver.driveAlign(m_targetAngle);
    }

    // This finishes once the robot is aligned to the angle
    @Override
    public boolean isFinished() {
        return m_isAligned;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AlignToAngle...");
        }
    }

}

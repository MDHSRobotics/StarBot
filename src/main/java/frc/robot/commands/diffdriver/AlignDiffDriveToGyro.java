
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.DPadButton;
import frc.robot.subsystems.DiffDriver;

// Assisted control of the DiffDrive to align the robot with the gyro.
public class AlignDiffDriveToGyro extends CommandBase {

    public GenericHID controller;
    private DiffDriver m_diffDriver;
    private int m_targetAngle = -1;

    public AlignDiffDriveToGyro(DiffDriver diffDriver, GenericHID controller) {
        Logger.setup("Constructing Command: AlignDiffDriveToGyro...");

        // Add given subsystem requirements
        this.controller = controller;
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        m_targetAngle = DPadButton.getGyroAngleFromDpadAngle(controller);
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
        }
    }

}

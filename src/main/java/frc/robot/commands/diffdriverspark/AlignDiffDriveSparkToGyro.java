
package frc.robot.commands.diffdriverspark;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.DPadButton;
import frc.robot.subsystems.DiffDriverSpark;

// Assisted control of the DiffDrive to align the robot with the gyro.
public class AlignDiffDriveSparkToGyro extends CommandBase {

    public GenericHID controller;
    private DiffDriverSpark m_diffDriverSpark;
    private int m_targetAngle = -1;

    public AlignDiffDriveSparkToGyro(DiffDriverSpark diffDriverSpark, GenericHID controller) {
        Logger.setup("Constructing Command: AlignDiffDriveSparkToGyro...");

        // Add given subsystem requirements
        this.controller = controller;
        m_diffDriverSpark = diffDriverSpark;
        addRequirements(m_diffDriverSpark);
    }

    @Override
    public void initialize() {
        m_targetAngle = DPadButton.getGyroAngleFromDpadAngle(controller);
    }

    @Override
    public void execute() {
        if (m_targetAngle != -1) {
            m_diffDriverSpark.driveAlign(m_targetAngle);
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
            Logger.ending("Interrupting Command: AlignDiffDriveSparkToGyro...");
        }
    }

}

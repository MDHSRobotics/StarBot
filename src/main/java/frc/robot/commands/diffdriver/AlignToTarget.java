
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.brains.LimelightBrain;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// DiffDrive uses limelight to align to the target
public class AlignToTarget extends CommandBase {

    public GenericHID controller;
    private DiffDriver m_diffDriver;
    private static double m_targetAngle = 0;

    public AlignToTarget(DiffDriver diffDriver, GenericHID controller) {
        Logger.setup("Constructing Command: AlignToTarget...");

        // Add given subsystem requirements
        this.controller = controller;
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing Command: AlignToTarget...");

        m_targetAngle = LimelightBrain.getXOffset();
    }

    @Override
    public void execute() {
        if (m_targetAngle != 0) {
            m_diffDriver.driveAlign(m_targetAngle);
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AlignToTarget...");
        }
    }

}

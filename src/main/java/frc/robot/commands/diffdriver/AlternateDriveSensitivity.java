
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.brains.XboxBrain;
import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.XboxPositionAccessible;
import frc.robot.subsystems.DiffDriver;

// This command uses the xbox input to differential drive using the tank method.
public class AlternateDriveSensitivity extends CommandBase {

    public XboxPositionAccessible controller;
    private DiffDriver m_diffDriver;

    public AlternateDriveSensitivity(DiffDriver diffDriver, XboxPositionAccessible controller) {
        Logger.setup("Constructing Command: AlternateDriveSensitivity...");

        // Add given subsystem requirements
        this.controller = controller;
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        XboxBrain.setYleftDeadZoneAlt();
        XboxBrain.setXleftDeadZoneAlt();
        XboxBrain.setYrightDeadZoneAlt();
        XboxBrain.setXrightDeadZoneAlt();
        XboxBrain.setYleftSensitivityAlt();
        XboxBrain.setXleftSensitivityAlt();
        XboxBrain.setYrightSensitivityAlt();
        XboxBrain.setXrightSensitivityAlt();
    }

    // This command continues until interrupted.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
    }

}

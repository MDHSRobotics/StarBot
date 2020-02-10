
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.XboxPositionAccessible;
import frc.robot.oi.movements.TankMovement;
import frc.robot.subsystems.DiffDriver;

// This command uses the xbox input to differential drive using the tank method.
public class DriveDiffTank extends CommandBase {

    public XboxPositionAccessible controller;
    private DiffDriver m_diffDriver;

    public DriveDiffTank(DiffDriver diffDriver, XboxPositionAccessible controller) {
        Logger.setup("Constructing Command: DriveDiffTank...");

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
        TankMovement move = TankMovement.getMovement(controller, m_diffDriver.controlStickDirectionFlipped);
        m_diffDriver.driveTank(move.leftSpeed, move.rightSpeed);
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

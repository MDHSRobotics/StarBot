
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.JoystickPositionAccessible;
import frc.robot.oi.movements.ArcadeMovement;
import frc.robot.subsystems.DiffDriver;

// This command uses the joystick input to differential drive using the arcade method.
public class DriveDiffArcade extends CommandBase {

    public JoystickPositionAccessible controller;
    private DiffDriver m_diffDriver;

    public DriveDiffArcade(DiffDriver diffDriver, JoystickPositionAccessible controller) {
        Logger.setup("Constructing Command: DriveDiffArcade...");

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
        ArcadeMovement move = ArcadeMovement.getMovement(controller, m_diffDriver.controlStickDirectionFlipped);
        // TODO: This is not the right place to fix a wrong value, by making it negative.
        //       Go to the source of the problem; don't just put a band-aid on it.
        m_diffDriver.driveArcade(-move.straightSpeed, move.rotationSpeed);
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

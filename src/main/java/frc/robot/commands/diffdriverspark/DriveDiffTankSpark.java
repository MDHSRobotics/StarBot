
package frc.robot.commands.diffdriverspark;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.XboxPositionAccessible;
import frc.robot.oi.movements.TankMovement;
import frc.robot.subsystems.DiffDriverSpark;

// This command uses the xbox input to differential drive using the tank method.
public class DriveDiffTankSpark extends CommandBase {

    public XboxPositionAccessible controller;
    private DiffDriverSpark m_diffDriverSpark;

    public DriveDiffTankSpark(DiffDriverSpark diffDriverSpark, XboxPositionAccessible controller) {
        Logger.setup("Constructing Command: DriveDiffTankSpark...");

        // Add given subsystem requirements
        this.controller = controller;
        m_diffDriverSpark = diffDriverSpark;
        addRequirements(m_diffDriverSpark);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        TankMovement move = TankMovement.getMovement(controller, m_diffDriverSpark.controlStickDirectionFlipped);
        m_diffDriverSpark.driveTank(move.leftSpeed, move.rightSpeed);
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

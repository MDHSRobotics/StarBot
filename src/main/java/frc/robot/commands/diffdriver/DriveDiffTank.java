
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.movements.TankMovement;
import frc.robot.subsystems.DiffDriver;
import frc.robot.BotControllers;

// This command uses the xbox input to differential drive using the tank method
public class DriveDiffTank extends CommandBase {

    private DiffDriver m_diffDriver;

    public DriveDiffTank(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: DriveDiffTank...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DriveDiffTank...");
    }

    @Override
    public void execute() {
        TankMovement move = TankMovement.getMovement(BotControllers.primary, m_diffDriver.controlStickDirectionFlipped);
        m_diffDriver.driveTank(move.leftSpeed, move.rightSpeed);
    }

    // This command continues until interrupted.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: DriveDiffTank...");
        } else {
            Logger.ending("Ending Command: DriveDiffTank...");
        }
    }

}

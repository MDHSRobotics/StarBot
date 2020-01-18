
package frc.robot.commands.diffdriver;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.movements.TankMovement;
import frc.robot.subsystems.DiffDriver;

// This command uses the xbox input to differential drive using the tank method
public class DriveDifferentialTank extends CommandBase {

    private DiffDriver m_diffDriver;

    public DriveDifferentialTank(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: DriveDifferentialTank...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: DriveDifferentialTank...");
    }

    @Override
    public void execute() {
        TankMovement move = TankMovement.getTankMovement(m_diffDriver.controlStickDirectionFlipped);
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
            Logger.ending("Interrupting Command: DriveDifferentialTank...");
        } else {
            Logger.ending("Ending Command: DriveDifferentialTank...");
        }
    }

}

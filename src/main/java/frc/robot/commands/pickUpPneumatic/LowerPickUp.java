
package frc.robot.commands.pickUpPneumatic;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickUpPneumatic;
import frc.robot.subsystems.Roller;

// This command lower the PickUp Subsystem using a single solenoid pnematic system
public class LowerPickUp extends CommandBase {

    private PickUpPneumatic m_lower;

    public LowerPickUp(PickUpPneumatic pickUpPneumatic) {
        Logger.setup("Constructing Command: LowerPickUp...");

        // Add given subsystem requirements
        m_lower = pickUpPneumatic;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerPickUp...");

        m_lower.openSolenoid();
    }

    @Override
    public void execute() {

    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: LowerPickUp...");
        } else {
            Logger.ending("Ending Command: LowerPickUp...");
        }

        m_lower.stop();
    }

}

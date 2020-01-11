
package frc.robot.commands.pickUpPneumatic;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickUpPneumatic;
import frc.robot.subsystems.Roller;

// This command closes the Hatcher claw via encoder to release, or in preparating to grab, the hatch, and keeps it closed
public class RetractPickUp extends CommandBase {

    private PickUpPneumatic m_retract;

    public RetractPickUp(PickUpPneumatic pickUpPneumatic) {
        Logger.setup("Constructing Command: RetractPickUp...");

        // Add given subsystem requirements
        m_retract = pickUpPneumatic;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RetractPickUp...");

        m_retract.closeSolenoid();
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
            Logger.ending("Interrupting Command: CloseHatchClaw...");
        } else {
            Logger.ending("Ending Command: CloseHatchClaw...");
        }

        m_retract.stop();
    }

}

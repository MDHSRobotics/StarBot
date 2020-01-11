
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Roller;

// This command closes the Hatcher claw via encoder to release, or in preparating to grab, the hatch, and keeps it closed
public class RollerSpin extends CommandBase {

    private Roller m_roller;

    public RollerSpin(Roller roller) {
        Logger.setup("Constructing Command: RollerSpin...");

        // Add given subsystem requirements
        m_roller = roller;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: CloseHatchClaw...");

        // Set encoded position
        m_roller.insertBox();
    }

    @Override
    public void execute() {
        // int position = m_hatcher.getPosition();
        // int velocity = m_hatcher.getVelocity();
        // Logger.info("CloseHatchClaw -> Position: " + position + "; Velocity: " + velocity);
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

        m_roller.stop();
    }

}

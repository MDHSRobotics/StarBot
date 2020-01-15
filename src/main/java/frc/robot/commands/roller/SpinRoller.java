
package frc.robot.commands.roller;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Roller;

// This command spins the Roller
public class SpinRoller extends CommandBase {

    private Roller m_roller;

    public SpinRoller(Roller roller) {
        Logger.setup("Constructing Command: RollerSpin...");

        // Add given subsystem requirements
        m_roller = roller;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: RollerSpin...");

        // Set encoded position
        m_roller.spin();
    }

    @Override
    public void execute() {

    }

    // This command finishes immediately
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: RollerSpin...");
            m_roller.stop();
        } else {
            Logger.ending("Ending Command: RollerSpin...");
        }
    }

}

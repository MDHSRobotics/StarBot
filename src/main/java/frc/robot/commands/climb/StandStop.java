
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;

// This command stops the Hatcher motor
public class StandStop extends CommandBase {

    private Climb m_climb;

    public StandStop(Climb climb) {
        Logger.setup("Constructing Command: StandStop...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StandStop...");
    }

    @Override
    public void execute() {
        m_climb.stop();
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
            Logger.ending("Interrupting Command: StandStop...");
        } else {
            Logger.ending("Ending Command: StandStop...");
        }

        m_climb.stop();
    }

}
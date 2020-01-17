
package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;

// This command starts the Climb motors
public class StandReverse extends CommandBase {

    private Climb m_climb;

    public StandReverse(Climb climb) {
        Logger.setup("Constructing Command: StandReverse...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StandReverse...");
    }

    @Override
    public void execute() {
        m_climb.standReverse();
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
            Logger.ending("Interrupting Command: StandReverse...");
        } else {
            Logger.ending("Ending Command: StandReverse...");
        }

        m_climb.stop();
    }

}

package frc.robot.commands.climb;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Climb;

// This command stops the Climb motors
public class LiftRobot extends CommandBase {

    private Climb m_climb;

    public LiftRobot(Climb climb) {
        Logger.setup("Constructing Command: LiftRobot...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LiftRobot...");

        m_climb.liftRobot();
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
            Logger.ending("Interrupting Command: LiftRobot...");
        } else {
            Logger.ending("Ending Command: LiftRobot...");
        }

        m_climb.stop();
    }

}
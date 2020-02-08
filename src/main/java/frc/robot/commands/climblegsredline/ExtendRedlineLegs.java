
package frc.robot.commands.climblegsredline;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsRedLine;

// This command lifts the robot
public class ExtendRedlineLegs extends CommandBase {

    private ClimbLegsRedLine m_climb;

    public ExtendRedlineLegs(ClimbLegsRedLine redLineClimb) {
        Logger.setup("Constructing Command: LiftRobot...");

        // Add given subsystem requirements
        m_climb = redLineClimb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LiftRobot...");

        m_climb.raiseRedLineClimb();
    }

    @Override
    public void execute() {
        System.out.println("Raise Position: " + m_climb.getPosition());
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

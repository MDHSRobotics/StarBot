
package frc.robot.commands.climblegsredline;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsRedLine;

// This command lowers the robot
public class RetractRedlineLegs extends CommandBase {

    private ClimbLegsRedLine m_climb;

    public RetractRedlineLegs(ClimbLegsRedLine redLineClimb) {
        Logger.setup("Constructing Command: LowerRobot...");

        // Add given subsystem requirements
        m_climb = redLineClimb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerRobot...");

        m_climb.lowerRedLineClimb();
    }

    @Override
    public void execute() {
        System.out.println("Lower Position: " + m_climb.getPosition());

    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        if (m_climb.getPosition() - 0 <= 100 && m_climb.getPosition() - 0 >= -100) {
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: LowerRobot...");
        } else {
            Logger.ending("Ending Command: LowerRobot...");
        }

        m_climb.stop();
    }

}

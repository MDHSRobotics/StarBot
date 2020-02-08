
package frc.robot.commands.climblegssparkmax;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.ClimbLegsSparkMax;

// This command lowers the robot
public class RetractSparkLegs extends CommandBase {

    private ClimbLegsSparkMax m_climb;

    public RetractSparkLegs(ClimbLegsSparkMax climb) {
        Logger.setup("Constructing Command: LowerRobot...");

        // Add given subsystem requirements
        m_climb = climb;
        addRequirements(m_climb);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LowerRobot...");

        m_climb.lowerRobot();
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
            Logger.ending("Interrupting Command: LowerRobot...");
        } else {
            Logger.ending("Ending Command: LowerRobot...");
        }

        m_climb.stop();
    }

}

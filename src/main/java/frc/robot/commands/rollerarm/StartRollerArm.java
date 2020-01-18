
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command starts the roller arm
public class StartRollerArm extends CommandBase {

    private RollerArm m_rollerArm;

    public StartRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing Command: StartRollerArm...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StartRollerArm...");
        m_rollerArm.startArm();
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
            Logger.ending("Interrupting Command: StartRollerArm...");
        } else {
            Logger.ending("Ending Command: StartRollerArm...");
        }
    }

}

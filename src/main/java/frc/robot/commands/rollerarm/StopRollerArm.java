
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command stops the roller arm
public class StopRollerArm extends CommandBase {

    private RollerArm m_rollerArm;

    public StopRollerArm(RollerArm rollerArm) {
        Logger.setup("Constructing Command: StopRollerArm...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: StopRollerArm...");
    }

    @Override
    public void execute() {
        m_rollerArm.stopArm();
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
            Logger.ending("Interrupting Command: StopRollerArm...");
        } else {
            Logger.ending("Ending Command: StopRollerArm...");
        }

        m_rollerArm.stopArm();
    }

}

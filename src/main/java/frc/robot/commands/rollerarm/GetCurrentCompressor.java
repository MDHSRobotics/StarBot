
package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command stops the roller arm
public class GetCurrentCompressor extends CommandBase {

    private RollerArm m_rollerArm;

    public GetCurrentCompressor(RollerArm rollerArm) {
        Logger.setup("Constructing Command: GetCurrentCompressor...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: GetCurrentCompressor...");
    }

    @Override
    public void execute() {
        System.out.println("Interrupting GetCurrentCompressor..." + m_rollerArm.getCurrent());;
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
            Logger.ending("Interrupting GetCurrentCompressor...");
        } else {
            Logger.ending("Ending Command: GetCurrentCompressor...");
        }

    }

}


package frc.robot.commands.rollerarm;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.RollerArm;

// This command logs the current being used by the roller arm
public class LogRollerArmCurrent extends CommandBase {

    private RollerArm m_rollerArm;

    public LogRollerArmCurrent(RollerArm rollerArm) {
        Logger.setup("Constructing Command: LogRollerArmCurrentInAmps...");

        // Add given subsystem requirements
        m_rollerArm = rollerArm;
        addRequirements(m_rollerArm);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: LogRollerArmCurrentInAmps...");
    }

    @Override
    public void execute() {
        int current = m_rollerArm.getCurrent();
        Logger.ending("RollerArm compressor current in amps: " + current);
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
            Logger.ending("Interrupting LogRollerArmCurrentInAmps...");
        } else {
            Logger.ending("Ending Command: LogRollerArmCurrentInAmps...");
        }
    }

}


package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.BotCommands;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Roller;

// This command stops the Roller
public class PCCommandGroup extends SequentialCommandGroup {

    private Roller m_roller;
    private Conveyor m_conveyor;

    public PCCommandGroup(Roller roller, Conveyor conveyor) {
        Logger.setup("Constructing Command: PCCommandGroup...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
        m_roller = roller;
        addRequirements(m_roller);

        addCommands(BotCommands.spinRoller, BotCommands.forwardConveyor);

    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: PCCommandGroup...");
    }

    @Override
    public void execute() {
        m_conveyor.stop();
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
            Logger.ending("Interrupting Command: PCCommandGroup...");
        } else {
            Logger.ending("Ending Command: PCCommandGroup...");
        }

        m_conveyor.stop();
    }

}

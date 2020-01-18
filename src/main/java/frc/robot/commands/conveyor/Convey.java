
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.movements.ConveyMovement;
import frc.robot.oi.ControlDevices;
import frc.robot.subsystems.Conveyor;

// This command moves the conveyor belt forward
public class Convey extends CommandBase {

    private Conveyor m_conveyor;

    public Convey(Conveyor conveyor) {
        Logger.setup("Constructing Command: Convey...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: Convey...");
    }

    @Override
    public void execute() {
        double speed = ConveyMovement.getConveySpeed(ControlDevices.driveXbox);
        m_conveyor.convey(speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: Convey...");
        } else {
            Logger.ending("Ending Command: Convey...");
        }

        m_conveyor.stop();
    }

}

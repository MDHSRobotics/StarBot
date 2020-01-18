
package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.oi.ControlDevices;
import frc.robot.oi.movements.ConveyMovement;


// This command moves the conveyor belt forward
public class Convey extends CommandBase {

    private Conveyor m_conveyor;


    public Convey(Conveyor conveyor) {
        Logger.setup("Constructing Command: Conveyor...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: Conveyor...");

    }

    @Override
    public void execute() {
        m_conveyor.convey(ConveyMovement.getConveySpeed(ControlDevices.driveXbox));
    }



    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: Conveyor...");
        } else {
            Logger.ending("Ending Command: Conveyor...");
        }

        m_conveyor.stop();
    }

}

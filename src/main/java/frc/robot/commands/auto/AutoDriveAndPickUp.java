
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Roller;
import frc.robot.subsystems.Conveyor.ConveyorDirection;

// This command starts the Shooter, waits one second, and then moves the Conveyor forward.
public class AutoDriveAndPickUp extends CommandBase {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Roller m_roller;

    private Timer m_timer = new Timer();

    private static final double TARGET_YAW = 0.0;
    private static final double MAX_DRIVE_SECONDS = 3.5;

    public AutoDriveAndPickUp(Conveyor conveyor, DiffDriver diffDriver, Roller roller) {
        Logger.setup("Constructing Command: AutoDriveAndPickUp...");

        // Add given subsystem requirements

        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        m_roller = roller;
        addRequirements(m_roller);

    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoDriveAndPickUp...");
        m_timer.reset();
        m_timer.start();

        m_roller.spin();
        m_conveyor.spin(ConveyorDirection.forward);
    }

    @Override
    public void execute() {

        m_diffDriver.driveTank(0.3, 0.3);
    }

    // This command continues until interrupted
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (currentTime < MAX_DRIVE_SECONDS) {
            return false;
        } else {
            Logger.action("AutoDriveAndPickUp: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoDriveAndPickUp...");
        } else {
            Logger.ending("Ending Command: AutoDriveAndPickUp...");
        }
        m_diffDriver.stop();
        m_roller.spin();
        m_conveyor.forward();
    }
}

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.BotSensors;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.DiffDriver;

// This command auto drives the DiffDriver forward for a short time
public class AutoRotateRight extends CommandBase {

    private DiffDriver m_diffDriver;

    private double INITIAL_ANGLE = 0.0;
    private double RIGHT_ANGLE = 90.0;

    private static boolean isTurned = false;

    private int timesTurned = 1;

    public AutoRotateRight(DiffDriver diffDriver) {
        Logger.setup("Constructing Command: AutoRotateRight...");

        // Add given subsystem requirements
        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoRotateRight...");
    }

    @Override
    public void execute() {

        double currentAngle = BotSensors.gyro.getAngle();
        double angleElapsed = currentAngle - INITIAL_ANGLE;

        BotSensors.gyro.getAngle();

        if (angleElapsed < RIGHT_ANGLE * timesTurned) {
            m_diffDriver.driveTank(0.5, - 0.5);
        }
        else {
            m_diffDriver.stop();
            isTurned = true;

        }
    }

    @Override
    public boolean isFinished() {
        if (!isTurned) {
            return false;
        } else {
            Logger.action("AutoRotateRight: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: AutoRotateRight...");
        } else {
            Logger.ending("Ending Command: AutoRotateRight...");
        }
    }

}

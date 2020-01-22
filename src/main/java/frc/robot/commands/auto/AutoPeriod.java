package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Gyro;
import frc.robot.subsystems.Autonomous;
import frc.robot.subsystems.DiffDriver;

public class AutoPeriod extends CommandBase {

    private Autonomous m_autonomous;
    // private DiffDriver m_autoDiffDriver;

    private DiffDriver m_diffDriver; // robot drive system
    private Gyro gyro;

    private Timer m_timer = new Timer();
    private double m_timeLastPrinted = 0.0;

    private static final double MAX_DRIVE_SECONDS = 5.0;

    public AutoPeriod(Autonomous autonomous) {
        Logger.setup("Constructing Command: AutoPeriod...");

        // Add given subsystem requirements
        m_autonomous = autonomous;
        addRequirements(m_autonomous);

        // DiffDriver();
        // DriveDifferentialTank(m_autoDiffDriver.getDiffDriver);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoPeriod...");
        // Logger.action("Initializing Command: DriveDifferentialTank...");

        m_timer.reset();
        m_timer.start();

    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        double timeElapsedSincePrint = currentTime - m_timeLastPrinted;

        if (timeElapsedSincePrint > 1.0) {
            Logger.action("AutoPeriod: -> Moved Forward for " + currentTime);
            m_timeLastPrinted = currentTime;
        }

       // m_autonomous.moveForwardAuto(); // drive forwards

        // TankMovement move = TankMovement.getTankMovement(m_autoDiffDriver.controlStickDirectionFlipped);
        // m_autoDiffDriver.driveTank(move.leftSpeed, move.rightSpeed);

//         while (isAutonomous() && isEnabled()) {
//              double angle = gyro.get();
//              myDrive.arcadeDrive(-1.0, -angle * Kp);
//              Timer.delay(0.01);
//          }

    }

    // This command continues until it MAX_DRIVE_SECONDS is reached
    @Override
    public boolean isFinished() {
        double currentTime = m_timer.get();

        if (currentTime < MAX_DRIVE_SECONDS)
            return false;

        else {
            Logger.action("AutoPeriod: -> Stopped");
            return true;
        }
    }

    @Override
    public void end(boolean interrupted) {
        // if (interrupted) {
        //     System.out.println("--");
        //     Logger.ending("Interrupting Command: DriveDifferentialTank...");
        // } else {
        //     Logger.ending("Ending Command: DriveDifferentialTank...");
        // }
    }
}



package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.consoles.Logger;
import frc.robot.oi.ControlDevices;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    private Command m_autonomousCommand;
    private boolean m_driveXBoxConnected = false;

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        System.out.println("--");
        Logger.setup("Initializing Robot...");

        // Initialize our RobotManager, which initializes and perists the state of the robot,
        // including flags, sensors, devices, subsystems, commands, button bindings, shuffleboard,
        // and puts our autonomous chooser on the dashboard.
        RobotManager.initialize();

        // Check which controllers are plugged in
        m_driveXBoxConnected = ControlDevices.isDriveXboxConnected();
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Update the Shuffleboard
        RobotManager.botShuffler.update();

        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
        System.out.println("--");
        Logger.ending("Disabling Robot...");
    }

    @Override
    public void disabledPeriodic() {
    }

    /**
     * This autonomous runs the autonomous command selected by your {@link BotCommands} class.
     */
    @Override
    public void autonomousInit() {
        System.out.println("--");
        Logger.setup("Initializing Autonomous Mode...");

        m_autonomousCommand = BotCommands.getAutonomousCommand();

        // schedule the autonomous command (example)
        if (m_autonomousCommand != null) {
            m_autonomousCommand.schedule();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
        System.out.println("--");
        Logger.setup("Initializing Teleop Mode...");

        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (m_autonomousCommand != null) {
            m_autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        // Detect whether a controller has been plugged in after start-up
        if (!m_driveXBoxConnected) {
            if (ControlDevices.isDriveXboxConnected()) {
                // Drive XBox was not previously plugged in but now it is so configure buttons
                ButtonBindings.configureDriveXBoxButtons();
                Logger.setup("Drive XBox controller detected and configured");
                m_driveXBoxConnected = true;
            }
        }
        // TODO: Check to see if the climbXbox controller is connected
    }

    @Override
    public void testInit() {
        System.out.println("--");
        Logger.setup("Initializing Test Mode...");

        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }

}

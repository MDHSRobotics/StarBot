
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.DPadButton.Direction;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    // Autonomous variables
    private Command m_autonomousCommand;

    // Test variables
    private final double TEST_SECONDS = 8.0;
    private int m_currentTest = 0;
    private Timer m_testTimer = new Timer();

    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        System.out.println("--");
        Logger.setup("Initializing Robot...");

        // Initialize our RobotManager, which initializes and perists the state of the robot,
        // including flags, sensors, devices, subsystems, commands, shuffleboard,
        // and puts our autonomous chooser on the dashboard.
        RobotManager.initialize();
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

        // Cancel all running commands
        VirtualControllers.reset();
        CommandScheduler.getInstance().cancelAll();
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

        // Cancel all running commands
        VirtualControllers.reset();
        CommandScheduler.getInstance().cancelAll();

        // Schedule the autonomous command
        m_autonomousCommand = BotCommands.getAutonomousCommand();
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

        // Set subsystem "teleop" default commands
        BotSubsystems.setTeleopDefaultCommands();

        // Cancel all running commands
        VirtualControllers.reset();
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        // Configure all controllers
        BotControllers.configure();
    }

    @Override
    public void testInit() {
        System.out.println("--");
        Logger.setup("Initializing Test Mode...");

        // Set subsystem "test" default commands
        BotSubsystems.setTestDefaultCommands();

        // Cancel all running commands
        VirtualControllers.reset();
        CommandScheduler.getInstance().cancelAll();
        // Re-enable the scheduler
        CommandScheduler.getInstance().enable();

        m_currentTest = 1;
        m_testTimer.stop();
        m_testTimer.reset();

        // Configure virtual controllers
        VirtualControllers.configure();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
        double currentTime = m_testTimer.get();
        if (currentTime > TEST_SECONDS) {
            VirtualControllers.reset();
            CommandScheduler.getInstance().cancelAll();
            m_currentTest++;
            m_testTimer.stop();
            m_testTimer.reset();
            currentTime = 0;
        }

        switch (m_currentTest) {
        case 1:
            if (currentTime == 0) {
                Logger.action("Starting TestCycleLights for " + TEST_SECONDS + " seconds...");
                m_testTimer.start();
                BotCommands.testCycleLights.schedule();
            }
            return;
        case 2:
            if (currentTime == 0) {
                Logger.action("Starting AlignDiffDriveToGyro test for " + TEST_SECONDS + " seconds...");
                m_testTimer.start();
                VirtualControllers.primary.xbox.dpadActive = true;
                VirtualControllers.primary.xbox.dpadDirection = Direction.UP;
            }
            else if (currentTime < 1) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.RIGHT;
            }
            else if (currentTime < 2) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.LEFT;
            }
            else if (currentTime < 3) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.DOWN_RIGHT;
            }
            else if (currentTime < 4) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.DOWN;
            }
            else if (currentTime < 5) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.DOWN_LEFT;
            }
            else if (currentTime < 6) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.UP_RIGHT;
            }
            else if (currentTime < 7) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.UP_LEFT;
            }
            else if (currentTime < 8) {
                VirtualControllers.primary.xbox.dpadDirection = Direction.UP;
            }
            return;
        default:
            Logger.action("All tests complete.");
            VirtualControllers.reset();
            CommandScheduler.getInstance().cancelAll();
            m_currentTest = 1;
            m_testTimer.stop();
            m_testTimer.reset();
            return;
        }
    }

}

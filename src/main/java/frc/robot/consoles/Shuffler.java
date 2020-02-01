
package frc.robot.consoles;

import frc.robot.consoles.tabs.*;

// Class that wraps all of the interaction with the Shuffleboard

// All decisions about content and layout of the Shuffleboard are consolidated in this file
// to make it easier to change things rather than having to look throughout all of the
// classes for subsystems, commands, etc.

// The Shuffler class knows about the subsystems, commands, etc. but generally not vice versa.
public class Shuffler {

    // Tabs
    private MainTab m_mainTab;
    private InputsTab m_inputsTab;
    private DriveTab m_driveTab;
    private LimelightTab m_limelightTab;
    private RollerTab m_rollerTab;
    private ShooterTab m_shooterTab;
    private ClimbHookTab m_climbHookTab;
    private ClimbLegsSparkTab m_climbLegsSparkTab;
    private ClimbBalancerTab m_climbBalancerTab;
    private DebugTab m_debugTab;

    public Shuffler() {
        ShuffleLogger.logTrivial("Constructing Shuffler...");

        m_mainTab = new MainTab();
        m_inputsTab = new InputsTab();
        m_driveTab = new DriveTab();
        m_rollerArmTab = new RollerArmTab();
        m_limelightTab = new LimelightTab();
        m_rollerTab = new RollerTab();
        m_shooterTab = new ShooterTab();
        m_climbHookTab = new ClimbHookTab();
        m_climbLegsSparkTab = new ClimbLegsSparkTab();
        m_climbBalancerTab = new ClimbBalancerTab();
        m_debugTab = new DebugTab();
    }

    public void preInitialize() {
        ShuffleLogger.logTrivial("Pre-Initializing Shuffler...");

        m_mainTab.preInitialize();
        m_inputsTab.preInitialize();
        m_driveTab.preInitialize();
        m_limelightTab.preInitialize();
        m_rollerArmTab.preInitialize();
        m_rollerTab.preInitialize();
        m_shooterTab.preInitialize();
        m_climbHookTab.preInitialize();
        m_climbLegsSparkTab.preInitialize();
        m_climbBalancerTab.preInitialize();
        m_debugTab.preInitialize();
    }

    public void initialize() {
        ShuffleLogger.logTrivial("Initializing Shuffler...");

        m_mainTab.initialize();
        m_inputsTab.initialize();
        m_driveTab.initialize();
        m_rollerArmTab.initialize();
        m_rollerTab.initialize();
        m_shooterTab.initialize();
        m_climbHookTab.initialize();
        m_climbLegsSparkTab.initialize();
        m_climbBalancerTab.initialize();
        m_debugTab.initialize();
        m_limelightTab.initialize();
    }

    public void configure() {
        ShuffleLogger.logTrivial("Configuring Shuffler...");

        m_mainTab.configure();
        m_inputsTab.configure();
        m_driveTab.configure();
        m_limelightTab.configure();
        m_rollerArmTab.configure();
        m_rollerTab.configure();
        m_shooterTab.configure();
        m_climbHookTab.configure();
        m_climbLegsSparkTab.configure();
        m_climbBalancerTab.configure();
        m_debugTab.configure();
        m_limelightTab.configure();

        setupSmartdashboard();
    }

    public void update() {
        m_mainTab.update();
        m_inputsTab.update();
        m_driveTab.update();
        m_limelightTab.update();
        m_rollerArmTab.update();
        m_rollerTab.update();
        m_shooterTab.update();
        m_climbHookTab.update();
        m_climbLegsSparkTab.update();
        m_climbBalancerTab.update();
        m_debugTab.update();
    }

    // This is for stuff that can't be displayed easily in custom Shuffleboard tabs.
    // It will end up on the SmartDashboard tab.
    private void setupSmartdashboard() {
        // SmartDashboard.putData("Command Scheduler",Scheduler.getInstance());
    }

}

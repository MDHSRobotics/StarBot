
package frc.robot.consoles;

import frc.robot.consoles.tabs.*;

// Class that wraps all of the interaction with the Shuffleboard

// All decisions about content and layout of the Shuffleboard are consolidated in this file
// to make it easier to change things rather than having to look throughout all of the
// classes for subsystems, commands, etc.

// The Shuffler class knows about the subsystems, commands, etc. but generally not vice versa
public class Shuffler {

    // Tabs
    private MainTab m_mainTab;
    private InputsTab m_inputsTab;
    private DebugTab m_debugTab;
    private RollerTab m_rollerTab;
    private RollerArmTab m_rollerArmTab;
    private DriveTab m_driveTab;

    public Shuffler() {
        ShuffleLogger.logTrivial("Constructing Shuffler...");

        m_mainTab = new MainTab();
        m_inputsTab = new InputsTab();
        m_driveTab = new DriveTab();
        m_rollerTab = new RollerTab();
        m_rollerArmTab = new RollerArmTab();
        m_debugTab = new DebugTab();
    }

    public void preInitialize() {
        ShuffleLogger.logTrivial("Pre-Initializing Shuffler...");

        m_mainTab.preInitialize();
        m_inputsTab.preInitialize();
        m_driveTab.preInitialize();
        m_rollerTab.preInitialize();
        m_rollerArmTab.preInitialize();
        m_debugTab.preInitialize();
    }

    public void initialize() {
        ShuffleLogger.logTrivial("Initializing Shuffler...");

        m_mainTab.initialize();
        m_inputsTab.initialize();
        m_driveTab.initialize();
        m_rollerTab.initialize();
        m_rollerArmTab.initialize();
        m_debugTab.initialize();
    }

    public void configure() {
        ShuffleLogger.logTrivial("Configuring Shuffler...");

        m_mainTab.configure();
        m_inputsTab.configure();
        m_driveTab.configure();
        m_rollerTab.configure();
        m_rollerArmTab.configure();
        m_debugTab.configure();

        setupSmartdashboard();
    }

    public void update() {
        m_mainTab.update();
        m_inputsTab.update();
        m_driveTab.update();
        m_rollerTab.update();
        m_rollerArmTab.update();
        m_debugTab.update();
    }

    // This is for stuff that can't be displayed easily in custom Shuffleboard tabs.
    // It will end up on the SmartDashboard tab.
    private void setupSmartdashboard() {
        // SmartDashboard.putData("Command Scheduler",Scheduler.getInstance());
    }

}

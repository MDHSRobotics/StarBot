
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

// import frc.robot.commands.test.diffDriveStraightDistance;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.subsystems.Devices;
// import frc.robot.Robot;
import frc.robot.brains.DiffDriverBrain;

// The Shuffleboard Drive Tab
public class DriveTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;
    private ComplexWidget m_diffDriveWidget;
    // private ComplexWidget m_diffDriverWidget;
    // private ComplexWidget m_diffDriveStraightCmdWidget;
    // private SimpleWidget m_targetDistanceWidget;
    private SimpleWidget m_alignZSensitivityWidget;
    private SimpleWidget m_alignZSpeedMinimumWidget;
    private SimpleWidget m_alignZToleranceWidget;

    // Create Brain Widgets
    public DriveTab() {
        ShuffleLogger.logCritical("Constructing DriveTab...");

        m_tab = Shuffleboard.getTab("Drive");
    }

    // Create Brain Widgets
    public void preInitialize() {
        // Target Distance for Drive Forward command
        // m_targetDistanceWidget = m_tab.add("Target Distance", Brain.driveTargetDistanceDefault);
        // Brain.driveTargetDistanceEntry = m_targetDistanceWidget.getEntry();

        m_alignZSensitivityWidget = m_tab.add("Z Sensitivity", DiffDriverBrain.alignZSensitivityDefault);
        DiffDriverBrain.alignZSensitivityEntry = m_alignZSensitivityWidget.getEntry();

        m_alignZSpeedMinimumWidget = m_tab.add("Z Speed Minimum", DiffDriverBrain.alignZSpeedMinimumDefault);
        DiffDriverBrain.alignZSpeedMinimumEntry = m_alignZSpeedMinimumWidget.getEntry();

        m_alignZToleranceWidget = m_tab.add("Z Tolerance", DiffDriverBrain.alignZToleranceDefault);
        DiffDriverBrain.alignZToleranceEntry = m_alignZToleranceWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
        if (Devices.diffDrive != null) {
            m_diffDriveWidget = m_tab.add("diffanum Drive", Devices.diffDrive);
        }
        // m_diffDriverWidget = m_tab.add("diffanum Driver Subsystem", Robot.robotdiffDriver);
        // m_diffDriveStraightCmdWidget = m_tab.add("diffanum Drive Straight", new diffDriveStraightDistance());
    }

    // Configure all Widgets
    public void configure() {
        // m_diffDriverWidget.withPosition(0, 0);
        // m_diffDriverWidget.withSize(2, 1);

        // m_targetDistanceWidget.withPosition(0, 1);
        // m_targetDistanceWidget.withWidget(BuiltInWidgets.kTextView);

        // m_diffDriveStraightCmdWidget.withPosition(0, 2);
        // m_diffDriveStraightCmdWidget.withSize(2, 1);

        if (m_diffDriveWidget != null) {
            m_diffDriveWidget.withPosition(3, 1);
            m_diffDriveWidget.withSize(4, 3);
        }

        m_alignZSensitivityWidget.withPosition(2, 0);
        m_alignZSpeedMinimumWidget.withPosition(0, 1);
        m_alignZToleranceWidget.withPosition(1, 1);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
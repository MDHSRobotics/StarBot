
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.LimelightBrain;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.BotSubsystems;

// The Shuffleboard RollerArm Tab
public class LimelightTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    // Properties
    private SimpleWidget m_limelightWidget;

    // Constructor
    public LimelightTab() {
        ShuffleLogger.logTrivial("Constructing LimelightTab...");

        m_tab = Shuffleboard.getTab("Limelight");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_limelightWidget = m_tab.add("Limelight X", LimelightBrain.x);
        m_limelightWidget = m_tab.add("Limelight Y", LimelightBrain.y);
        m_limelightWidget = m_tab.add("Limelight Area", LimelightBrain.area);
        LimelightBrain.tx = m_limelightWidget.getEntry();
        LimelightBrain.ty = m_limelightWidget.getEntry();
        LimelightBrain.ta = m_limelightWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_limelightWidget.withPosition(0, 1);
    }

    // This will be called in the robotPeriodic
    public void update() {
        LimelightBrain.setXOffset();
        LimelightBrain.setYOffset();
        LimelightBrain.setArea();
    }

}


package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.LimelightBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard RollerArm Tab
public class LimelightTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    // Properties
    private SimpleWidget m_limelightWidgetX;
    private SimpleWidget m_limelightWidgetY;
    private SimpleWidget m_limelightWidgetArea;

    // Constructor
    public LimelightTab() {
        ShuffleLogger.logTrivial("Constructing LimelightTab...");

        m_tab = Shuffleboard.getTab("Limelight");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_limelightWidgetX = m_tab.add("tx", LimelightBrain.x);
        m_limelightWidgetY = m_tab.add("ty", LimelightBrain.y);
        m_limelightWidgetArea = m_tab.add("ta", LimelightBrain.area);
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_limelightWidgetX.withPosition(1, 0);
        m_limelightWidgetY.withPosition(2, 0);
        m_limelightWidgetArea.withPosition(3, 0);
    }

    // This will be called in the robotPeriodic
    public void update() {
        LimelightBrain.setXOffset();
        LimelightBrain.setYOffset();
        LimelightBrain.setArea();

    }

}

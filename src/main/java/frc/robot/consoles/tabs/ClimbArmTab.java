
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.ClimbArmBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard ClimbArm Tab
public class ClimbArmTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    // Properties
    private SimpleWidget m_climbArmPowerWidget;

    // Constructor
    public ClimbArmTab() {
        ShuffleLogger.logTrivial("Constructing ClimbArmTab...");

        m_tab = Shuffleboard.getTab("ClimbArm");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_climbArmPowerWidget = m_tab.add("ClimbArm Power", ClimbArmBrain.climbArmPowerDefault);
        ClimbArmBrain.climbArmPowerEntry = m_climbArmPowerWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_climbArmPowerWidget.withWidget(BuiltInWidgets.kTextView);
        m_climbArmPowerWidget.withPosition(0, 0);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

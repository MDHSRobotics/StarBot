
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.ClimbHookBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard ClimbHook tab.
public class ClimbHookTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;

    // Widgets
    private SimpleWidget m_powerWidget;

    // Constructor
    public ClimbHookTab() {
        ShuffleLogger.logTrivial("Constructing ClimbHookTab...");

        m_tab = Shuffleboard.getTab("ClimbHook");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_powerWidget = m_tab.add("Power", ClimbHookBrain.powerDefault);
        ClimbHookBrain.powerEntry = m_powerWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_powerWidget.withWidget(BuiltInWidgets.kTextView);
        m_powerWidget.withPosition(0, 0);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

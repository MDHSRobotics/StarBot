
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.ClimbBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Roller Tab
public class ClimbTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    // Properties
    private SimpleWidget m_climbRotationWidget;

    // Constructor
    public ClimbTab() {
        ShuffleLogger.logTrivial("Constructing ClimbTab...");

        m_tab = Shuffleboard.getTab("Climb");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_climbRotationWidget = m_tab.add("Roller Power", ClimbBrain.climbRotationDefault);
        ClimbBrain.climbRotation = m_climbRotationWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_climbRotationWidget.withWidget(BuiltInWidgets.kTextView);
        m_climbRotationWidget.withPosition(0, 0);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

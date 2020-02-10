
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.ClimbLegsSparkBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard ClimbLegsSpark tab.
public class ClimbLegsSparkTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;

    // Widgets
    private SimpleWidget m_rotationWidget;

    // Constructor
    public ClimbLegsSparkTab() {
        ShuffleLogger.logTrivial("Constructing ClimbLegsSparkTab...");

        m_tab = Shuffleboard.getTab("ClimbLegsSpark");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_rotationWidget = m_tab.add("Rotations", ClimbLegsSparkBrain.rotationsDefault);
        ClimbLegsSparkBrain.rotations = m_rotationWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_rotationWidget.withWidget(BuiltInWidgets.kTextView);
        m_rotationWidget.withPosition(0, 0);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

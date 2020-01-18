
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import frc.robot.brains.RollerBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Sight Tab
public class RollerTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    // Encoder Properties
    private SimpleWidget m_rollerPowerWidget;

    // Constructor
    public RollerTab() {
        ShuffleLogger.logTrivial("Constructing RollerTab...");

        m_tab = Shuffleboard.getTab("Roller");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_rollerPowerWidget = m_tab.add("Roller Power", RollerBrain.rollerPowerDefault);
        RollerBrain.rollerPowerEntry = m_rollerPowerWidget.getEntry();

    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_rollerPowerWidget.withWidget(BuiltInWidgets.kTextView);
        m_rollerPowerWidget.withPosition(0, 0);

    }

    // This will be called in the robotPeriodic
    public void update() {

    }

}


package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.ClimbRollerBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard ClimbArm Tab
public class ClimbRollerTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    // Properties
    private SimpleWidget m_climbRollerPowerWidget;

    // Constructor
    public ClimbRollerTab() {
        ShuffleLogger.logTrivial("Constructing ClimbRollerTab...");

        m_tab = Shuffleboard.getTab("ClimbRoller");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_climbRollerPowerWidget = m_tab.add("ClimbArm Power", ClimbRollerBrain.climbRollerPowerDefault);
        ClimbRollerBrain.climbRollerPowerEntry = m_climbRollerPowerWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_climbRollerPowerWidget.withWidget(BuiltInWidgets.kTextView);
        m_climbRollerPowerWidget.withPosition(0, 0);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

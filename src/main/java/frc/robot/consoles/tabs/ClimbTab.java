
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.ClimbBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Climb tab.
public class ClimbTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;

    // Widgets
    private SimpleWidget m_balancerPowerWidget;
    private SimpleWidget m_hookPowerWidget;
    private SimpleWidget m_legRotationsWidget;

    // Constructor
    public ClimbTab() {
        ShuffleLogger.logTrivial("Constructing ClimbTab...");

        m_tab = Shuffleboard.getTab("Climb");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_balancerPowerWidget = m_tab.add("Balancer Power", ClimbBrain.balancerPowerDefault);
        ClimbBrain.balancerPowerEntry = m_balancerPowerWidget.getEntry();

        m_hookPowerWidget = m_tab.add("Hook Power", ClimbBrain.hookPowerDefault);
        ClimbBrain.hookPowerEntry = m_hookPowerWidget.getEntry();

        m_legRotationsWidget = m_tab.add("Leg Rotations", ClimbBrain.legRotationsDefault);
        ClimbBrain.legRotationsEntry = m_legRotationsWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_balancerPowerWidget.withWidget(BuiltInWidgets.kTextView);
        m_balancerPowerWidget.withPosition(0, 0);

        m_hookPowerWidget.withWidget(BuiltInWidgets.kTextView);
        m_hookPowerWidget.withPosition(0, 1);

        m_legRotationsWidget.withWidget(BuiltInWidgets.kTextView);
        m_legRotationsWidget.withPosition(0, 2);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

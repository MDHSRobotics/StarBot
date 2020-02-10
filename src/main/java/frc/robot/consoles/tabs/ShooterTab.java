
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import java.util.Map;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Shooter tab.
public class ShooterTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_bottomWheelLayout;
    private ShuffleboardLayout m_topWheelLayout;

    // Widgets
    private SimpleWidget m_bottomWheelVelocity;
    private SimpleWidget m_topWheelVelocity;

    // Constructor
    public ShooterTab() {
        ShuffleLogger.logTrivial("Constructing ShooterTab...");

        m_tab = Shuffleboard.getTab("Shooter");

        m_bottomWheelLayout = m_tab.getLayout("Bottom Wheel", BuiltInLayouts.kGrid);
        m_bottomWheelLayout.withPosition(0, 1);
        m_bottomWheelLayout.withSize(2, 1);
        m_bottomWheelLayout.withProperties(Map.of("Number of columns", 1));
        m_bottomWheelLayout.withProperties(Map.of("Number of rows", 2));
        m_bottomWheelLayout.withProperties(Map.of("Label position", "LEFT"));

        m_topWheelLayout = m_tab.getLayout("Top Wheel", BuiltInLayouts.kGrid);
        m_topWheelLayout.withPosition(0, 0);
        m_topWheelLayout.withSize(2, 1);
        m_topWheelLayout.withProperties(Map.of("Number of columns", 1));
        m_topWheelLayout.withProperties(Map.of("Number of rows", 2));
        m_topWheelLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_bottomWheelVelocity = m_bottomWheelLayout.add("Bottom Wheel Velocity", ShooterBrain.bottomWheelVelocityDefault);
        ShooterBrain.bottomWheelVelocityEntry = m_bottomWheelVelocity.getEntry();
        m_bottomWheelVelocity.withWidget(BuiltInWidgets.kTextView);

        m_topWheelVelocity = m_topWheelLayout.add("Top Wheel Velocity", ShooterBrain.topWheelVelocityDefault);
        ShooterBrain.topWheelVelocityEntry = m_topWheelVelocity.getEntry();
        m_topWheelVelocity.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

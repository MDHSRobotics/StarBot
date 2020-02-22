
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
    private SimpleWidget m_shooterBottomWheelTargetVelocity;
    private SimpleWidget m_shooterTopWheelTargetVelocity;
    private SimpleWidget m_shooterTopWheelCurrentVelocity;
    private SimpleWidget m_shooterBottomWheelCurrentVelocity;

    private SimpleWidget m_shooterBottomWheelCurrentVelocityFPS;
    private SimpleWidget m_shooterTopWheelCurrentVelocityFPS;

    private SimpleWidget m_shooterBottomWheelMaxVelocity;
    private SimpleWidget m_shooterBottomWheelMinVelocity;
    private SimpleWidget m_shooterTopWheelMaxVelocity;
    private SimpleWidget m_shooterTopWheelMinVelocity;

    // Constructor
    public ShooterTab() {
        ShuffleLogger.logTrivial("Constructing ShooterTab...");

        m_tab = Shuffleboard.getTab("Shooter");

        m_bottomWheelLayout = m_tab.getLayout("Bottom Wheel", BuiltInLayouts.kGrid);
        m_topWheelLayout = m_tab.getLayout("Top Wheel", BuiltInLayouts.kGrid);
    }

    // Create Brain Widgets
    public void preInitialize() {
        // Target velocity
        m_shooterBottomWheelTargetVelocity = m_bottomWheelLayout.add("Target Velocity Entry",
                ShooterBrain.shootBottomWheelTargetVelocityDefault);
        ShooterBrain.shootBottomWheelTargetVelocityEntry = m_shooterBottomWheelTargetVelocity.getEntry();
        m_shooterBottomWheelTargetVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelTargetVelocity = m_topWheelLayout.add("Target Velocity Entry",
                ShooterBrain.shootTopWheelTargetVelocityDefault);
        ShooterBrain.shootTopWheelTargetVelocityEntry = m_shooterTopWheelTargetVelocity.getEntry();
        m_shooterTopWheelTargetVelocity.withWidget(BuiltInWidgets.kTextView);

        // Current velocity
        m_shooterBottomWheelCurrentVelocity = m_bottomWheelLayout.add("Current Velocity",
                ShooterBrain.shootBottomWheelCurrentVelocityDefault);
        ShooterBrain.shootBottomWheelCurrentVelocityEntry = m_shooterBottomWheelCurrentVelocity.getEntry();
        m_shooterBottomWheelCurrentVelocity.withWidget(BuiltInWidgets.kGraph);

        m_shooterTopWheelCurrentVelocity = m_topWheelLayout.add("Current Velocity",
                ShooterBrain.shootTopWheelCurrentVelocityDefault);
        ShooterBrain.shootTopWheelCurrentVelocityEntry = m_shooterTopWheelCurrentVelocity.getEntry();
        m_shooterTopWheelCurrentVelocity.withWidget(BuiltInWidgets.kGraph);

        // Current velocity FPS
        m_shooterBottomWheelCurrentVelocityFPS = m_bottomWheelLayout.add("Current Velocity FPS",
                ShooterBrain.shootBottomWheelCurrentVelocityFPSDefault);
        ShooterBrain.shootBottomWheelCurrentVelocityFPSEntry = m_shooterBottomWheelCurrentVelocityFPS.getEntry();
        m_shooterBottomWheelCurrentVelocityFPS.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelCurrentVelocityFPS = m_topWheelLayout.add("Current Velocity FPS",
                ShooterBrain.shootTopWheelCurrentVelocityFPSDefault);
        ShooterBrain.shootTopWheelCurrentVelocityFPSEntry = m_shooterTopWheelCurrentVelocityFPS.getEntry();
        m_shooterTopWheelCurrentVelocityFPS.withWidget(BuiltInWidgets.kTextView);

        // Min velocity
        m_shooterBottomWheelMinVelocity = m_bottomWheelLayout.add("Min Velocity",
                ShooterBrain.shootBottomWheelMinVelocityDefault);
        ShooterBrain.shootBottomWheelMinVelocityEntry = m_shooterBottomWheelMinVelocity.getEntry();
        m_shooterBottomWheelMinVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelMinVelocity = m_topWheelLayout.add("Min Velocity",
                ShooterBrain.shootTopWheelMinVelocityDefault);
        ShooterBrain.shootTopWheelMinVelocityEntry = m_shooterTopWheelMinVelocity.getEntry();
        m_shooterTopWheelMinVelocity.withWidget(BuiltInWidgets.kTextView);

        // Max velocity
        m_shooterBottomWheelMaxVelocity = m_bottomWheelLayout.add("Max Velocity",
                ShooterBrain.shootBottomWheelMaxVelocityDefault);
        ShooterBrain.shootBottomWheelMaxVelocityEntry = m_shooterBottomWheelMaxVelocity.getEntry();
        m_shooterBottomWheelMaxVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelMaxVelocity = m_topWheelLayout.add("Max Velocity",
                ShooterBrain.shootTopWheelMaxVelocityDefault);
        ShooterBrain.shootTopWheelMaxVelocityEntry = m_shooterTopWheelMaxVelocity.getEntry();
        m_shooterTopWheelMaxVelocity.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_bottomWheelLayout.withPosition(0, 0);
        m_bottomWheelLayout.withSize(3, 5);
        m_bottomWheelLayout.withProperties(Map.of("Number of columns", 1));
        m_bottomWheelLayout.withProperties(Map.of("Number of rows", 5));
        m_bottomWheelLayout.withProperties(Map.of("Label position", "TOP"));

        m_topWheelLayout.withPosition(4, 0);
        m_topWheelLayout.withSize(3, 5);
        m_topWheelLayout.withProperties(Map.of("Number of columns", 1));
        m_topWheelLayout.withProperties(Map.of("Number of rows", 5));
        m_topWheelLayout.withProperties(Map.of("Label position", "TOP"));
    }

    // This will be called in the robotPeriodic
    public void update() {

    }

}

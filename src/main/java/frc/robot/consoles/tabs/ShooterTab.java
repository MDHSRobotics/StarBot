
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import java.util.Map;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.BotCommands;

// The Shuffleboard Shooter tab.
public class ShooterTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_bottomWheelLayout;
    private ShuffleboardLayout m_topWheelLayout;
    private ShuffleboardLayout m_shootTargetLayout;

    // Commands
    private ComplexWidget m_shooterReset;
    private ComplexWidget m_shootWithDistance;
    private ComplexWidget m_shootWithVelocity;

    // Widgets
    private SimpleWidget m_shooterTopWheelCurrentVelocity;
    private SimpleWidget m_shooterBottomWheelCurrentVelocity;

    private SimpleWidget m_shooterBottomWheelMaxVelocity;
    private SimpleWidget m_shooterBottomWheelMinVelocity;
    private SimpleWidget m_shooterBottomWheelAverageVelocity;
    private SimpleWidget m_shooterTopWheelMaxVelocity;
    private SimpleWidget m_shooterTopWheelMinVelocity;
    private SimpleWidget m_shooterTopWheelAverageVelocity;

    private SimpleWidget m_shooterDistance;
    private SimpleWidget m_shooterTargetFPS;
    private SimpleWidget m_shooterTargetTPHMS;
    private SimpleWidget m_shooterVelocityTPHMSOffsetTop;
    private SimpleWidget m_shooterVelocityTPHMSOffsetBottom;

    // Constructor
    public ShooterTab() {
        ShuffleLogger.logTrivial("Constructing ShooterTab...");

        m_tab = Shuffleboard.getTab("Shooter");

        m_bottomWheelLayout = m_tab.getLayout("Bottom Wheel", BuiltInLayouts.kList);
        m_topWheelLayout = m_tab.getLayout("Top Wheel", BuiltInLayouts.kList);
        m_shootTargetLayout = m_tab.getLayout("Target", BuiltInLayouts.kList);
    }

    // Create Brain Widgets
    public void preInitialize() {

        // Current velocity
        m_shooterBottomWheelCurrentVelocity = m_bottomWheelLayout.add("Current Velocity (TpHMS)",
                ShooterBrain.shootBottomWheelCurrentVelocityDefault);
        ShooterBrain.shootBottomWheelCurrentVelocityEntry = m_shooterBottomWheelCurrentVelocity.getEntry();
        m_shooterBottomWheelCurrentVelocity.withWidget(BuiltInWidgets.kGraph);

        m_shooterTopWheelCurrentVelocity = m_topWheelLayout.add("Current Velocity (TpHMS)",
                ShooterBrain.shootTopWheelCurrentVelocityDefault);
        ShooterBrain.shootTopWheelCurrentVelocityEntry = m_shooterTopWheelCurrentVelocity.getEntry();
        m_shooterTopWheelCurrentVelocity.withWidget(BuiltInWidgets.kGraph);

        // Min velocity
        m_shooterBottomWheelMinVelocity = m_bottomWheelLayout.add("Min Velocity (TpHMS)",
                ShooterBrain.shootBottomWheelMinVelocityDefault);
        ShooterBrain.shootBottomWheelMinVelocityEntry = m_shooterBottomWheelMinVelocity.getEntry();
        m_shooterBottomWheelMinVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelMinVelocity = m_topWheelLayout.add("Min Velocity (TpHMS)",
                ShooterBrain.shootTopWheelMinVelocityDefault);
        ShooterBrain.shootTopWheelMinVelocityEntry = m_shooterTopWheelMinVelocity.getEntry();
        m_shooterTopWheelMinVelocity.withWidget(BuiltInWidgets.kTextView);

        // Max velocity
        m_shooterBottomWheelMaxVelocity = m_bottomWheelLayout.add("Max Velocity (TpHMS)",
                ShooterBrain.shootBottomWheelMaxVelocityDefault);
        ShooterBrain.shootBottomWheelMaxVelocityEntry = m_shooterBottomWheelMaxVelocity.getEntry();
        m_shooterBottomWheelMaxVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelMaxVelocity = m_topWheelLayout.add("Max Velocity (TpHMS)",
                ShooterBrain.shootTopWheelMaxVelocityDefault);
        ShooterBrain.shootTopWheelMaxVelocityEntry = m_shooterTopWheelMaxVelocity.getEntry();
        m_shooterTopWheelMaxVelocity.withWidget(BuiltInWidgets.kTextView);

        // Average Velocity
        m_shooterBottomWheelAverageVelocity = m_bottomWheelLayout.add("Average Velocity (TpHMS)",
                ShooterBrain.shootBottomWheelAverageVelocityDefault);
        ShooterBrain.shootBottomWheelAverageVelocityEntry = m_shooterBottomWheelAverageVelocity.getEntry();
        m_shooterBottomWheelAverageVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelAverageVelocity = m_topWheelLayout.add("Average Velocity (TpHMS)",
                ShooterBrain.shootTopWheelAverageVelocityDefault);
        ShooterBrain.shootTopWheelAverageVelocityEntry = m_shooterTopWheelAverageVelocity.getEntry();
        m_shooterTopWheelAverageVelocity.withWidget(BuiltInWidgets.kTextView);

        // Distance
        m_shooterDistance = m_shootTargetLayout.add("Distance (Feet)", ShooterBrain.shootDistanceDefault);
        ShooterBrain.shootDistanceEntry = m_shooterDistance.getEntry();
        m_shooterDistance.withWidget(BuiltInWidgets.kTextView);

        // Target velocity FpS
        m_shooterTargetFPS = m_shootTargetLayout.add("Ball Velocity (FpS)", ShooterBrain.shootTargetFPSDefault);
        ShooterBrain.shootTargetFPSEntry = m_shooterTargetFPS.getEntry();
        m_shooterTargetFPS.withWidget(BuiltInWidgets.kTextView);

        // Target velocity TpHMS
        m_shooterTargetTPHMS = m_shootTargetLayout.add("Wheel Velocity (TpHMS)", ShooterBrain.shootTargetTPHMSDefault);
        ShooterBrain.shootTargetTPHMSEntry = m_shooterTargetTPHMS.getEntry();
        m_shooterTargetTPHMS.withWidget(BuiltInWidgets.kTextView);

        // Offset velocity
        m_shooterVelocityTPHMSOffsetTop = m_shootTargetLayout.add("Offset Velocity Top (TpHMS)", ShooterBrain.shootVelocityTPHMSOffsetTopDefault);
        ShooterBrain.shootVelocityTPHMSOffsetTopEntry = m_shooterVelocityTPHMSOffsetTop.getEntry();
        m_shooterVelocityTPHMSOffsetTop.withWidget(BuiltInWidgets.kTextView);

        m_shooterVelocityTPHMSOffsetBottom = m_shootTargetLayout.add("Offset Velocity Bottom (TpHMS)", ShooterBrain.shootVelocityTPHMSOffsetBottomDefault);
        ShooterBrain.shootVelocityTPHMSOffsetBottomEntry = m_shooterVelocityTPHMSOffsetBottom.getEntry();
        m_shooterVelocityTPHMSOffsetBottom.withWidget(BuiltInWidgets.kTextView);

    }

    // Create all other Widgets
    public void initialize() {
        m_shooterReset = m_tab.add("RESET", BotCommands.resetShoot);
        m_shooterReset.withWidget(BuiltInWidgets.kCommand);

        m_shootWithDistance = m_shootTargetLayout.add("Shoot With Distance", BotCommands.shootWithDistance);
        m_shootWithDistance.withWidget(BuiltInWidgets.kCommand);

        m_shootWithVelocity = m_shootTargetLayout.add("Shoot With Velocity", BotCommands.shootWithVelocity);
        m_shootWithVelocity.withWidget(BuiltInWidgets.kCommand);
    }

    // Configure all Widgets
    public void configure() {
        m_bottomWheelLayout.withPosition(0, 0);
        m_bottomWheelLayout.withSize(3, 4);
        // m_bottomWheelLayout.withProperties(Map.of("Number of columns", 1));
        // m_bottomWheelLayout.withProperties(Map.of("Number of rows", 3));
        m_bottomWheelLayout.withProperties(Map.of("Label position", "TOP"));

        m_topWheelLayout.withPosition(3, 0);
        m_topWheelLayout.withSize(3, 4);
        // m_topWheelLayout.withProperties(Map.of("Number of columns", 1));
        // m_topWheelLayout.withProperties(Map.of("Number of rows", 3));
        m_topWheelLayout.withProperties(Map.of("Label position", "TOP"));

        m_shootTargetLayout.withPosition(6, 0);
        m_shootTargetLayout.withSize(2, 3);
        // m_shootTargetLayout.withProperties(Map.of("Number of columns", 1));
        // m_shootTargetLayout.withProperties(Map.of("Number of rows", 3));
        m_shootTargetLayout.withProperties(Map.of("Label position", "TOP"));

        m_shooterReset.withPosition(6, 3);
        m_shooterReset.withSize(2, 1);
    }

    // This will be called in the robotPeriodic
    public void update() {

    }

}
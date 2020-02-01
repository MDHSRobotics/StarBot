
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import java.util.Map;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.subsystems.Shooter;
import frc.robot.BotSubsystems;

// The Shuffleboard Shooter tab.
public class ShooterTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_bottomWheelLayout;
    private ShuffleboardLayout m_topWheelLayout;

    // Widgets
    private SimpleWidget m_bottomWheelVelocity;
    private SimpleWidget m_topWheelVelocity;

    private SimpleWidget m_shooterBottomWheelTargetVelocity;
    private SimpleWidget m_shooterTopWheelTargetVelocity;
    private SimpleWidget m_shooterTopWheelCurrentVelocity;
    private SimpleWidget m_shooterBottomWheelCurrentVelocity;

    double topVelocity = 0;
    double bottomVelocity = 0;

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
        m_shooterBottomWheelTargetVelocity = m_bottomWheelLayout.add("Bottom Wheel Target Velocity Entry",
                ShooterBrain.shootBottomWheelTargetVelocityDefault);
        ShooterBrain.shootBottomWheelTargetVelocityEntry = m_shooterBottomWheelTargetVelocity.getEntry();
        m_shooterBottomWheelTargetVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelTargetVelocity = m_topWheelLayout.add("Top Wheel Target Velocity Entry",
                ShooterBrain.shootTopWheelTargetVelocityDefault);
        ShooterBrain.shootTopWheelTargetVelocityEntry = m_shooterTopWheelTargetVelocity.getEntry();
        m_shooterTopWheelTargetVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterBottomWheelCurrentVelocity = m_bottomWheelLayout.add("Bottom Wheel Current Velocity Entry",
                ShooterBrain.shootBottomWheelCurrentVelocityDefault);
        ShooterBrain.shootBottomWheelCurrentVelocityEntry = m_shooterBottomWheelCurrentVelocity.getEntry();
        m_shooterBottomWheelCurrentVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelCurrentVelocity = m_topWheelLayout.add("Top Wheel Current Velocity Entry",
                ShooterBrain.shootTopWheelCurrentVelocityDefault);
        ShooterBrain.shootTopWheelCurrentVelocityEntry = m_shooterTopWheelCurrentVelocity.getEntry();
        m_shooterTopWheelCurrentVelocity.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
    }

    // This will be called in the robotPeriodic
    public void update() {
        topVelocity = BotSubsystems.shooter.getTopWheelVelocity();
        bottomVelocity = BotSubsystems.shooter.getBottomWheelVelocity();

        ShooterBrain.setTopWheelCurrentVelocity(topVelocity);
        ShooterBrain.setBottomWheelCurrentVelocity(bottomVelocity);
    }

}

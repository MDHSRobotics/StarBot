
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import java.util.Map;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Shooter Tab
public class ShooterTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_bottomWheelLayout;
    private ShuffleboardLayout m_topWheelLayout;

    private ComplexWidget m_schedulerWidget;

    private SimpleWidget m_shooterBottomWheelVelocity;
    private SimpleWidget m_shooterTopWheelVelocity;

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
        m_shooterBottomWheelVelocity = m_bottomWheelLayout.add("Bottom Wheel Velocity", ShooterBrain.shootBottomWheelVelocityDefault);
        ShooterBrain.shootBottomWheelVelocityEntry = m_shooterBottomWheelVelocity.getEntry();
        m_shooterBottomWheelVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelVelocity = m_topWheelLayout.add("Top Wheel Velocity", ShooterBrain.shootTopWheelVelocityDefault);
        ShooterBrain.shootTopWheelVelocityEntry = m_shooterTopWheelVelocity.getEntry();
        m_shooterTopWheelVelocity.withWidget(BuiltInWidgets.kTextView);
    }

    // Create all other Widgets
    public void initialize() {
        // TODO: This is probably left over from where it was copied from, right?
        //  Command Scheduler - Not sure why this isn't working
        CommandScheduler sched = CommandScheduler.getInstance();
        m_schedulerWidget = m_tab.add("Command Scheduler", sched);
    }

    // Configure all Widgets
    public void configure() {
        m_schedulerWidget.withPosition(0, 1);
        m_schedulerWidget.withSize(2, 1);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}

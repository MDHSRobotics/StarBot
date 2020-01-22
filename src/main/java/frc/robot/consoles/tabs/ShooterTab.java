
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Debug Tab
public class ShooterTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    private SimpleWidget m_shooterWheelVelocity;

    // Constructor
    public ShooterTab() {
        ShuffleLogger.logTrivial("Constructing ShooterTab...");

        m_tab = Shuffleboard.getTab("Shooter");
    }

    // Create Brain Widgets
    public void preInitialize() {
    }

    // Create all other Widgets
    public void initialize() {
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


package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.RollerArmBrain;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.BotSubsystems;

// The Shuffleboard RollerArm tab.
public class RollerArmTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;

    // Widgets
    private SimpleWidget m_powerWidget;

    // Constructor
    public RollerArmTab() {
        ShuffleLogger.logTrivial("Constructing RollerArmTab...");

        m_tab = Shuffleboard.getTab("RollerArm");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_powerWidget = m_tab.add("Compressor State", RollerArmBrain.compressorState);
        RollerArmBrain.compressorStateEntry = m_powerWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_powerWidget.withPosition(0, 0);
    }

    // This will be called in the robotPeriodic
    public void update() {
        boolean compressorState = false;
        int compressorCurrent = BotSubsystems.rollerArm.getCurrent();
        if (compressorCurrent == 0) {
            compressorState = true;
        } else {
            compressorState = false;
        }
        RollerArmBrain.setCompressorState(compressorState);
    }

}


package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.RollerArmBrain;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.BotSubsystems;

// The Shuffleboard RollerArm Tab
public class RollerArmTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;

    // Properties
    private SimpleWidget m_rollerPowerWidget;

    // Constructor
    public RollerArmTab() {
        ShuffleLogger.logTrivial("Constructing RollerArmTab...");

        m_tab = Shuffleboard.getTab("RollerArm");
    }

    // Create Brain Widgets
    public void preInitialize() {
        m_rollerPowerWidget = m_tab.add("Compressor State", RollerArmBrain.compressorState);
        RollerArmBrain.compressorStateEntry = m_rollerPowerWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        m_rollerPowerWidget.withPosition(0, 0);
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


package frc.robot.consoles.tabs;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.*;

import frc.robot.brains.ClimbBrain;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.BotSensors;

// The Shuffleboard Climb tab.
public class ClimbTab {

    // Tab & Layouts
    private ShuffleboardTab m_tab;

    // Widgets
    private SimpleWidget m_balancerPowerWidget;
    private SimpleWidget m_hookPowerWidget;
    private SimpleWidget m_legRotationsWidget;

    private SimpleWidget m_brightnessWidget;
    private SimpleWidget m_exposureWidget;
    private SimpleWidget m_whiteBalanceWidget;

    // Constructor
    public ClimbTab() {
        ShuffleLogger.logTrivial("Constructing ClimbTab...");

        m_tab = Shuffleboard.getTab("Climb");
    }

    // Create Brain Widgets
    public void preInitialize() {
        // Subsystems
        m_balancerPowerWidget = m_tab.add("Balancer Power", ClimbBrain.balancerPowerDefault);
        ClimbBrain.balancerPowerEntry = m_balancerPowerWidget.getEntry();

        m_hookPowerWidget = m_tab.add("Hook Power", ClimbBrain.hookPowerDefault);
        ClimbBrain.hookPowerEntry = m_hookPowerWidget.getEntry();

        m_legRotationsWidget = m_tab.add("Leg Rotations", ClimbBrain.legRotationsDefault);
        ClimbBrain.legRotationsEntry = m_legRotationsWidget.getEntry();

        // Sensors
        m_brightnessWidget = m_tab.add("Brightness", ClimbBrain.brightnessDefault);
        ClimbBrain.brightnessEntry = m_brightnessWidget.getEntry();

        m_exposureWidget = m_tab.add("Exposure", ClimbBrain.exposureDefault);
        ClimbBrain.exposureEntry = m_exposureWidget.getEntry();

        m_whiteBalanceWidget = m_tab.add("White Balance", ClimbBrain.whiteBalanceDefault);
        ClimbBrain.whiteBalanceEntry = m_whiteBalanceWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        // Subsystems
        m_balancerPowerWidget.withWidget(BuiltInWidgets.kTextView);
        m_balancerPowerWidget.withPosition(0, 0);

        m_hookPowerWidget.withWidget(BuiltInWidgets.kTextView);
        m_hookPowerWidget.withPosition(0, 1);

        m_legRotationsWidget.withWidget(BuiltInWidgets.kTextView);
        m_legRotationsWidget.withPosition(0, 2);

        // Sensors
        m_brightnessWidget.withWidget(BuiltInWidgets.kTextView);
        m_brightnessWidget.withPosition(0, 3);

        m_exposureWidget.withWidget(BuiltInWidgets.kTextView);
        m_exposureWidget.withPosition(0, 4);

        m_whiteBalanceWidget.withWidget(BuiltInWidgets.kTextView);
        m_whiteBalanceWidget.withPosition(0, 5);
    }

    // This will be called in the robotPeriodic
    public void update() {

        // Don't need to update anything if the sight camera is not active
        if (BotSensors.climbCamera == null)
            return;

        double brightness = ClimbBrain.getBrightness();
        NetworkTableEntry brightnessEntry = m_brightnessWidget.getEntry();
        double newBrightness = brightnessEntry.getDouble(brightness);
        if (newBrightness != brightness) {
            BotSensors.climbCamera.setBrightness((int) newBrightness);
        }

        double exposure = ClimbBrain.getExposure();
        NetworkTableEntry exposureEntry = m_exposureWidget.getEntry();
        double newExposure = exposureEntry.getDouble(brightness);
        if (newExposure != exposure) {
            BotSensors.climbCamera.setExposureManual((int) newExposure);
        }

        double whiteBalance = ClimbBrain.getBrightness();
        NetworkTableEntry whiteBalanceEntry = m_whiteBalanceWidget.getEntry();
        double newWhiteBalance = whiteBalanceEntry.getDouble(whiteBalance);
        if (newWhiteBalance != whiteBalance) {
            BotSensors.climbCamera.setWhiteBalanceManual((int) newWhiteBalance);
        }

    }

}

package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import java.util.Map;

import frc.robot.brains.DistanceBrain;
import frc.robot.brains.VisionBrain;
import frc.robot.consoles.ShuffleLogger;

// The Shuffleboard Vision Tab
public class VisionTab {

    // Tab, layout, and widget objects
    private ShuffleboardTab m_tab;
    private ShuffleboardLayout m_hsvLayout;
    private ShuffleboardLayout m_frontCamLayout;
    private ShuffleboardLayout m_leftCamLayout;
    private ShuffleboardLayout m_rightCamLayout;

    // Line Pipeline - HSV Thresholds
    private SimpleWidget m_hueMinWidget;
    private SimpleWidget m_hueMaxWidget;
    private SimpleWidget m_saturationMinWidget;
    private SimpleWidget m_saturationMaxWidget;
    private SimpleWidget m_valueMinWidget;
    private SimpleWidget m_valueMaxWidget;

    // Line Detection - Front Camera
    private SimpleWidget m_frontAreaWidget;
    private SimpleWidget m_frontAngleWidget;
    private SimpleWidget m_frontXcenterWidget;
    private SimpleWidget m_frontYcenterWidget;

    // Distance
    private SimpleWidget m_distanceWidget;

    // Constructor
    public VisionTab() {
        ShuffleLogger.logTrivial("Constructing VisionTab...");

        m_tab = Shuffleboard.getTab("Vision");
        m_hsvLayout = m_tab.getLayout("HSV Thresholds", BuiltInLayouts.kGrid);
        m_frontCamLayout = m_tab.getLayout("Front Camera", BuiltInLayouts.kGrid);
        m_leftCamLayout = m_tab.getLayout("Left Camera", BuiltInLayouts.kGrid);
        m_rightCamLayout = m_tab.getLayout("Right Camera", BuiltInLayouts.kGrid);
    }

    // Create Brain Widgets
    public void preInitialize() {
        // Hue Thresholds
        m_hueMinWidget = m_hsvLayout.add("Hue Minimum", VisionBrain.hueMinDefault);
        VisionBrain.hueMinEntry = m_hueMinWidget.getEntry();

        m_hueMaxWidget = m_hsvLayout.add("Hue Maximum", VisionBrain.hueMaxDefault);
        VisionBrain.hueMaxEntry = m_hueMaxWidget.getEntry();

        // Saturation Thresholds
        m_saturationMinWidget = m_hsvLayout.add("Saturation Minimum", VisionBrain.saturationMinDefault);
        VisionBrain.saturationMinEntry = m_saturationMinWidget.getEntry();

        m_saturationMaxWidget = m_hsvLayout.add("Saturation Maximum", VisionBrain.saturationMaxDefault);
        VisionBrain.saturationMaxEntry = m_saturationMaxWidget.getEntry();

        // Value Thresholds
        m_valueMinWidget = m_hsvLayout.add("Value Minimum", VisionBrain.valueMinDefault);
        VisionBrain.valueMinEntry = m_valueMinWidget.getEntry();

        m_valueMaxWidget = m_hsvLayout.add("Value Maximum", VisionBrain.valueMaxDefault);
        VisionBrain.valueMaxEntry = m_valueMaxWidget.getEntry();

        // Front Camera
        m_frontAreaWidget = m_frontCamLayout.add("Front Line Area", VisionBrain.frontLineAreaDefault);
        VisionBrain.frontLineAreaEntry = m_frontAreaWidget.getEntry();

        m_frontAngleWidget = m_frontCamLayout.add("Front Line Angle", VisionBrain.frontLineAngleDefault);
        VisionBrain.frontLineAngleEntry = m_frontAngleWidget.getEntry();

        m_frontXcenterWidget = m_frontCamLayout.add("Front Line Center X", VisionBrain.frontLineXcenterDefault);
        VisionBrain.frontLineXcenterEntry = m_frontXcenterWidget.getEntry();

        m_frontYcenterWidget = m_frontCamLayout.add("Front Line Center Y", VisionBrain.frontLineYcenterDefault);
        VisionBrain.frontLineYcenterEntry = m_frontYcenterWidget.getEntry();

        m_distanceWidget = m_tab.add("Distance Sensor", DistanceBrain.distanceDefault);
        DistanceBrain.distanceEntry = m_distanceWidget.getEntry();
    }

    // Create all other Widgets
    public void initialize() {
    }

    // Configure all Widgets
    public void configure() {
        // Layouts
        m_frontCamLayout.withPosition(0, 0);
        m_frontCamLayout.withSize(3, 2);
        m_frontCamLayout.withProperties(Map.of("Number of columns", 2));
        m_frontCamLayout.withProperties(Map.of("Number of rows", 2));
        m_frontCamLayout.withProperties(Map.of("Label position", "LEFT"));

        m_hsvLayout.withPosition(3, 0);
        m_hsvLayout.withSize(3, 2);
        m_hsvLayout.withProperties(Map.of("Number of columns", 2));
        m_hsvLayout.withProperties(Map.of("Number of rows", 2));
        m_hsvLayout.withProperties(Map.of("Label position", "LEFT"));

        m_leftCamLayout.withPosition(0, 2);
        m_leftCamLayout.withSize(3, 2);
        m_leftCamLayout.withProperties(Map.of("Number of columns", 2));
        m_leftCamLayout.withProperties(Map.of("Number of rows", 2));
        m_leftCamLayout.withProperties(Map.of("Label position", "LEFT"));

        m_rightCamLayout.withPosition(3, 2);
        m_rightCamLayout.withSize(3, 2);
        m_rightCamLayout.withProperties(Map.of("Number of columns", 2));
        m_rightCamLayout.withProperties(Map.of("Number of rows", 2));
        m_rightCamLayout.withProperties(Map.of("Label position", "LEFT"));

        // HSV Thresholds
        m_hueMinWidget.withWidget(BuiltInWidgets.kTextView);
        m_hueMaxWidget.withWidget(BuiltInWidgets.kTextView);
        m_saturationMinWidget.withWidget(BuiltInWidgets.kTextView);
        m_saturationMaxWidget.withWidget(BuiltInWidgets.kTextView);
        m_valueMinWidget.withWidget(BuiltInWidgets.kTextView);
        m_valueMaxWidget.withWidget(BuiltInWidgets.kTextView);

        // Front Camera
        m_frontAreaWidget.withWidget(BuiltInWidgets.kTextView);
        m_frontAngleWidget.withWidget(BuiltInWidgets.kTextView);
        m_frontXcenterWidget.withWidget(BuiltInWidgets.kTextView);
        m_frontYcenterWidget.withWidget(BuiltInWidgets.kTextView);

        // Distance
        m_distanceWidget.withWidget(BuiltInWidgets.kTextView);
        m_distanceWidget.withPosition(5, 5);
    }

    // This will be called in the robotPeriodic
    public void update() {
    }

}
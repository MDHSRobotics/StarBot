
package frc.robot.consoles.tabs;

import edu.wpi.first.wpilibj.shuffleboard.*;
import java.util.Map;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.ShuffleLogger;
import frc.robot.BotSubsystems;
import frc.robot.subsystems.utils.EncoderUtils;
import frc.robot.subsystems.Shooter;

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

    double topVelocity = ShooterBrain.shootTopWheelCurrentVelocityDefault;
    double bottomVelocity = ShooterBrain.shootBottomWheelCurrentVelocityDefault;

    double bottomVelocityFPS = ShooterBrain.shootBottomWheelCurrentVelocityFPSDefault;
    double topVelocityFPS = ShooterBrain.shootTopWheelCurrentVelocityFPSDefault;

    double minTopVelocity = ShooterBrain.shootTopWheelMinVelocityDefault;
    double maxTopVelocity = ShooterBrain.shootTopWheelMaxVelocityDefault;

    double minBottomVelocity = ShooterBrain.shootBottomWheelMinVelocityDefault;
    double maxBottomVelocity = ShooterBrain.shootBottomWheelMaxVelocityDefault;

    // Constructor
    public ShooterTab() {
        ShuffleLogger.logTrivial("Constructing ShooterTab...");

        m_tab = Shuffleboard.getTab("Shooter");

        m_bottomWheelLayout = m_tab.getLayout("Bottom Wheel", BuiltInLayouts.kGrid);
        m_bottomWheelLayout.withPosition(0, 0);
        m_bottomWheelLayout.withSize(2, 4);
        m_bottomWheelLayout.withProperties(Map.of("Number of columns", 2));
        m_bottomWheelLayout.withProperties(Map.of("Number of rows", 4));
        m_bottomWheelLayout.withProperties(Map.of("Label position", "LEFT"));

        m_topWheelLayout = m_tab.getLayout("Top Wheel", BuiltInLayouts.kGrid);
        m_topWheelLayout.withPosition(0, 4);
        m_topWheelLayout.withSize(2, 4);
        m_topWheelLayout.withProperties(Map.of("Number of columns", 2));
        m_topWheelLayout.withProperties(Map.of("Number of rows", 4));
        m_topWheelLayout.withProperties(Map.of("Label position", "LEFT"));
    }

    // Create Brain Widgets
    public void preInitialize() {
        // Target velocity
        m_shooterBottomWheelTargetVelocity = m_bottomWheelLayout.add("Bottom Wheel Target Velocity Entry",
                ShooterBrain.shootBottomWheelTargetVelocityDefault);
        ShooterBrain.shootBottomWheelTargetVelocityEntry = m_shooterBottomWheelTargetVelocity.getEntry();
        m_shooterBottomWheelTargetVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelTargetVelocity = m_topWheelLayout.add("Top Wheel Target Velocity Entry",
                ShooterBrain.shootTopWheelTargetVelocityDefault);
        ShooterBrain.shootTopWheelTargetVelocityEntry = m_shooterTopWheelTargetVelocity.getEntry();
        m_shooterTopWheelTargetVelocity.withWidget(BuiltInWidgets.kTextView);

        // Current velocity
        m_shooterBottomWheelCurrentVelocity = m_bottomWheelLayout.add("Bottom Wheel Current Velocity Entry",
                ShooterBrain.shootBottomWheelCurrentVelocityDefault);
        ShooterBrain.shootBottomWheelCurrentVelocityEntry = m_shooterBottomWheelCurrentVelocity.getEntry();
        m_shooterBottomWheelCurrentVelocity.withWidget(BuiltInWidgets.kGraph);

        m_shooterTopWheelCurrentVelocity = m_topWheelLayout.add("Top Wheel Current Velocity Entry",
                ShooterBrain.shootTopWheelCurrentVelocityDefault);
        ShooterBrain.shootTopWheelCurrentVelocityEntry = m_shooterTopWheelCurrentVelocity.getEntry();
        m_shooterTopWheelCurrentVelocity.withWidget(BuiltInWidgets.kGraph);

        // Current velocity FPS
        m_shooterBottomWheelCurrentVelocityFPS = m_bottomWheelLayout.add("Bottom Wheel Current Velocity FPS Entry",
                ShooterBrain.shootBottomWheelCurrentVelocityFPSDefault);
        ShooterBrain.shootBottomWheelCurrentVelocityFPSEntry = m_shooterBottomWheelCurrentVelocityFPS.getEntry();
        m_shooterBottomWheelCurrentVelocityFPS.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelCurrentVelocityFPS = m_topWheelLayout.add("Top Wheel Current Velocity FPS Entry",
                ShooterBrain.shootTopWheelCurrentVelocityFPSDefault);
        ShooterBrain.shootTopWheelCurrentVelocityFPSEntry = m_shooterTopWheelCurrentVelocityFPS.getEntry();
        m_shooterTopWheelCurrentVelocityFPS.withWidget(BuiltInWidgets.kTextView);

        // Min velocity
        m_shooterBottomWheelMinVelocity = m_bottomWheelLayout.add("Bottom Wheel Min Velocity Entry",
                ShooterBrain.shootBottomWheelMinVelocityDefault);
        ShooterBrain.shootBottomWheelMinVelocityEntry = m_shooterBottomWheelMinVelocity.getEntry();
        m_shooterBottomWheelMinVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelMinVelocity = m_topWheelLayout.add("Top Wheel Min Velocity Entry",
                ShooterBrain.shootTopWheelMinVelocityDefault);
        ShooterBrain.shootTopWheelMinVelocityEntry = m_shooterTopWheelMinVelocity.getEntry();
        m_shooterTopWheelMinVelocity.withWidget(BuiltInWidgets.kTextView);

        // Max velocity
        m_shooterBottomWheelMaxVelocity = m_bottomWheelLayout.add("Bottom Wheel Max Velocity Entry",
                ShooterBrain.shootBottomWheelMaxVelocityDefault);
        ShooterBrain.shootBottomWheelMaxVelocityEntry = m_shooterBottomWheelMaxVelocity.getEntry();
        m_shooterBottomWheelMaxVelocity.withWidget(BuiltInWidgets.kTextView);

        m_shooterTopWheelMaxVelocity = m_topWheelLayout.add("Top Wheel Max Velocity Entry",
                ShooterBrain.shootTopWheelMaxVelocityDefault);
        ShooterBrain.shootTopWheelMaxVelocityEntry = m_shooterTopWheelMaxVelocity.getEntry();
        m_shooterTopWheelMaxVelocity.withWidget(BuiltInWidgets.kTextView);
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

        topVelocityFPS = EncoderUtils.translateTicksPerDecisecondToFPS(topVelocity, BotSubsystems.shooter.getWheelDiameter(), BotSubsystems.shooter.getGearRatio());
        bottomVelocityFPS = EncoderUtils.translateTicksPerDecisecondToFPS(bottomVelocity, BotSubsystems.shooter.getWheelDiameter(), BotSubsystems.shooter.getGearRatio());

        ShooterBrain.setTopWheelCurrentVelocity(topVelocity);
        ShooterBrain.setBottomWheelCurrentVelocity(bottomVelocity);

        ShooterBrain.setTopWheelCurrentVelocityFPS(topVelocityFPS);
        ShooterBrain.setBottomWheelCurrentVelocityFPS(bottomVelocityFPS);

        if (topVelocity < minTopVelocity) minTopVelocity = topVelocity;
        if (topVelocity > maxTopVelocity) maxTopVelocity = topVelocity;
        if (bottomVelocity < minBottomVelocity) minBottomVelocity = bottomVelocity;
        if (bottomVelocity > maxBottomVelocity) maxBottomVelocity = bottomVelocity;

        ShooterBrain.setBottomWheelMinVelocity(minBottomVelocity);
        ShooterBrain.setBottomWheelMaxVelocity(maxBottomVelocity);
        ShooterBrain.setTopWheelMinVelocity(minTopVelocity);
        ShooterBrain.setTopWheelMaxVelocity(maxTopVelocity);

    }

    // Resets the min/max velocity capture variables to their default values
    public void reset(){
        minTopVelocity = ShooterBrain.shootTopWheelMinVelocityDefault;
        maxTopVelocity = ShooterBrain.shootTopWheelMaxVelocityDefault;

        minBottomVelocity = ShooterBrain.shootBottomWheelMinVelocityDefault;
        maxBottomVelocity = ShooterBrain.shootBottomWheelMaxVelocityDefault;
    }

}

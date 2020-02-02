
package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.consoles.Logger;
import frc.robot.consoles.Shuffler;
import frc.robot.subsystems.Devices;

// This is where the robot state is initialized and persisted.
public class RobotManager {

    //--------------//
    // Robot States //
    //--------------//

    public enum Variant {
        TEST_BOARD, TEST_DRIVE, BUILD_HOME, BUILD_AWAY
    }

    // Variant is used to configure different device mappings for different "robots"
    // TODO: This needs to be added to the Brain and Shuffleboard, so that it is settable on the fly
    public static Variant botVariant = Variant.TEST_BOARD;

    //-------------------------------//
    // Shuffleboard & SmartDashboard //
    //-------------------------------//

    // The robot Shuffler instance
    public static Shuffler botShuffler;

    // The auto command chooser to add to SmartDashboard
    public static SendableChooser<Command> autoCommandChooser;

    //----------------//
    // Initialization //
    //----------------//

    // It is important that the robot be initialized in exactly this order.
    public static void initialize() {
        Logger.setup("Initializing RobotManager...");

        // Initialize subsystem Devices
        Devices.initializeDevices();

        // Pre-intialize the Shuffler
        botShuffler = new Shuffler();
        botShuffler.preInitialize();

        // Initialize BotSensors, BotSubsystems, and BotCommands
        BotSensors.initializeSensors();
        BotSubsystems.initializeSubsystems();
        BotCommands.initializeCommands();

        // Setup SmartDashboard
        setupSmartDashboard();

        // Intialize and configure the Shuffler
        botShuffler.initialize();
        botShuffler.configure();

        // Set default subsystem commands and configure button bindings
        BotSubsystems.setDefaultCommands();
        ButtonBindings.configure();
    }

    // Add the desired commands to the SmartDashboard
    private static void setupSmartDashboard() {
        Logger.setup("Adding AutoModes to SmartDashboard...");
        autoCommandChooser = new SendableChooser<>();
        autoCommandChooser.setDefaultOption("Lighter - TestCycleLights", BotCommands.testCycleLights);
        // TODO: Add additional commands for autonomous here
        SmartDashboard.putData("AutoMode", autoCommandChooser);
    }

}

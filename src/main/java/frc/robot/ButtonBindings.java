
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Check controllers and configure button bindings
    public static void configure() {
        Logger.setup("Configuring ButtonBindings...");

        // Primary Controller
        if (!BotControllers.primary.isConnected()) {
            Logger.error("Primary controller not plugged in!");
        } else {
            configurePrimaryButtons();
        }

        // Secondary Controller
        if (!BotControllers.secondary.isConnected()) {
            Logger.error("Secondary controller not plugged in!");
        } else {
            configureSecondaryButtons();
        }
    }

    // Configure "primary" xbox buttons
    public static void configurePrimaryButtons() {
        Logger.setup("Configure Buttons -> Primary Controller...");

        // TODO: There are conflicts with buttons after merge. Resolve.

        // Climb
        BotControllers.primary.btnA.whenPressed(BotCommands.toggleHook);
        BotControllers.primary.btnB.whenPressed(BotCommands.toggleLegs);
        BotControllers.primary.btnX.whileHeld(BotCommands.rollerForward);
        BotControllers.primary.btnY.whileHeld(BotCommands.rollerReverse);

        // DiffDriver
        BotControllers.primary.btnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);

        // Roller
        BotControllers.primary.btnB.whileHeld(BotCommands.spinRoller);

        // RollerArm
        BotControllers.primary.btnX.whenPressed(BotCommands.toggleRollerArm);

        // Shooter?
        BotControllers.primary.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
        BotControllers.primary.btnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);
    }

    // Configure "secondary" xbox buttons
    public static void configureSecondaryButtons() {
        Logger.setup("Configure Buttons -> Secondary Controller...");

        // Conveyor
        BotControllers.secondary.btnBumperLeft.whileHeld(BotCommands.reverseConveyor);
    }

}

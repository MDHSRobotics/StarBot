
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Check controllers and configure button bindings
    public static void configure() {
        Logger.setup("Configuring ButtonBindings...");

        if (!BotControllers.drive.isConnected()) {
            Logger.error("Drive controller not plugged in!");
        } else {
            configureDriveButtons();
        }
    }

    // Configure "drive" xbox buttons
    public static void configureDriveButtons() {
        Logger.setup("Configure Buttons -> Drive Controller...");

        // TODO: There are conflicts with buttons after merge. Resolve.

        // Climb
        BotControllers.drive.btnA.whenPressed(BotCommands.toggleHook);
        BotControllers.drive.btnB.whenPressed(BotCommands.toggleLegs);
        BotControllers.drive.btnX.whileHeld(BotCommands.rollerForward);
        BotControllers.drive.btnY.whileHeld(BotCommands.rollerReverse);

        // DiffDriver
        BotControllers.drive.btnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);
        BotControllers.drive.btnBumperRight.whileHeld(BotCommands.centerDiffDriveOnTarget);

        // Roller
        BotControllers.drive.btnB.whileHeld(BotCommands.spinRoller);

        // RollerArm
        BotControllers.drive.btnX.whenPressed(BotCommands.toggleRollerArm);

        // Shooter?
       // BotControllers.drive.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
       // BotControllers.drive.btnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);

        // TODO: This is configuring buttons for the shoot xbox controller in a method called configureDriveXboxButtons()
        // Climb/Shoot Controller
        BotControllers.shoot.btnBumperLeft.whileHeld(BotCommands.reverseConveyor);
    }

}

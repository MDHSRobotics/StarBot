
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure "primary" xbox buttons
    public static void configurePrimary() {
        Logger.setup("Configure Buttons -> Primary Controller...");

        // TODO: There are conflicts with buttons after merge. Resolve.

        // Climb
        BotControllers.primary.btnA.whenPressed(BotCommands.toggleHook);
        BotControllers.primary.btnB.whenPressed(BotCommands.toggleLegs);
        BotControllers.primary.btnX.whileHeld(BotCommands.rollerForward);
        BotControllers.primary.btnY.whileHeld(BotCommands.rollerReverse);

        // DiffDriver
        BotControllers.drive.btnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);
        BotControllers.drive.btnBumperRight.whileHeld(BotCommands.centerDiffDriveOnTarget);

        // Roller
        BotControllers.primary.btnB.whileHeld(BotCommands.spinRoller);

        // RollerArm
        BotControllers.primary.btnX.whenPressed(BotCommands.toggleRollerArm);

        // Shooter?
       // BotControllers.drive.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
       // BotControllers.drive.btnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);

    // Configure "secondary" xbox buttons
    public static void configureSecondary() {
        Logger.setup("Configure Buttons -> Secondary Controller...");

        // Conveyor
        BotControllers.secondary.btnBumperLeft.whileHeld(BotCommands.reverseConveyor);
    }

}

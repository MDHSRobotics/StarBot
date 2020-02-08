
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure "primary" xbox buttons
    public static void configurePrimary() {
        Logger.setup("Configure Buttons -> Primary Controller...");

        // DiffDriver
        BotControllers.primary.btnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);
        BotControllers.primary.btnBumperRight.whileHeld(BotCommands.centerDiffDriveOnTarget);

        // Roller
        BotControllers.primary.btnB.whileHeld(BotCommands.spinRoller);

        // RollerArm
        BotControllers.primary.btnX.whenPressed(BotCommands.toggleRollerArm);
    }

    // Configure "secondary" xbox buttons
    public static void configureSecondary() {
        Logger.setup("Configure Buttons -> Secondary Controller...");

        // Climb
        BotControllers.secondary.btnA.whenPressed(BotCommands.toggleHook);
        BotControllers.secondary.btnX.whenPressed(BotCommands.toggleRedlineLegs);
        BotControllers.secondary.btnY.whenPressed(BotCommands.toggleSparkLegs);
        BotControllers.secondary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
        BotControllers.secondary.btnDpadRight.whileHeld(BotCommands.balanceRight);

        // Conveyor
        BotControllers.secondary.btnB.whileHeld(BotCommands.reverseConveyor);

        // Shooter
        BotControllers.secondary.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
        BotControllers.secondary.btnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);
    }

}


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

        // Climb
        BotControllers.primary.btnY.whenPressed(BotCommands.toggleHook);
        // BotControllers.primary.btnA.whenPressed(BotCommands.toggleRedLegs);
        BotControllers.primary.btnA.whenPressed(BotCommands.toggleSparkLegs);
        // TODO: Use the triggers for the balancer, so that you have fine analog control.
        // BotControllers.primary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
        // BotControllers.primary.btnDpadRight.whileHeld(BotCommands.balanceRight);
    }

    // Configure "secondary" xbox buttons
    public static void configureSecondary() {
        Logger.setup("Configure Buttons -> Secondary Controller...");

        // RollerArm
        BotControllers.primary.btnY.whenPressed(BotCommands.toggleRollerArm);

        // Roller
        BotControllers.primary.btnA.whileHeld(BotCommands.spinRollerAndConveyor);

        // Conveyor
        BotControllers.secondary.btnX.whileHeld(BotCommands.reverseConveyor);

        // Shooter
        BotControllers.secondary.btnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);
        BotControllers.secondary.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
        ControlDevices.driveXboxBtnBumperRight.whenPressed(BotCommands.shoot);
        ControlDevices.driveXboxBtnBumperLeft.whenPressed(BotCommands.stopShoot);
    }

}

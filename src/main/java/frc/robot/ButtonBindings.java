
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure "primary" xbox buttons
    public static void configurePrimary() {
        Logger.setup("Configure Buttons -> Primary Controller...");

        // DiffDriver
        BotControllers.primary.btnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);
        BotControllers.primary.btnBumperRight.whileHeld(BotCommands.driveDiffToWithinRangeFront);
        BotControllers.primary.btnStart.whenPressed(BotCommands.defaultDriveSensitivity);
        BotControllers.primary.btnBack.whenPressed(BotCommands.alternateDriveSensitivity);

        // RollerArm
        BotControllers.secondary.btnY.whenPressed(BotCommands.toggleRollerArm);

        // Roller
        BotControllers.secondary.btnBumperRight.whileHeld(BotCommands.spinRollerAndConveyor);

        // Conveyor
        // BotControllers.secondary.btnX.whileHeld(BotCommands.reverseConveyor);
        BotControllers.secondary.btnBumperLeft.whenPressed(BotCommands.reverseConveyorAndShoot);

        // TODO: Use the triggers for the balancer, so that you have fine analog control.
        // BotControllers.primary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
        // BotControllers.primary.btnDpadRight.whileHeld(BotCommands.balanceRight);
    }

    // Configure "secondary" xbox buttons
    public static void configureSecondary() {
        Logger.setup("Configure Buttons -> Secondary Controller...");

        // Climb
        BotControllers.primary.btnBumperLeft.whileHeld(BotCommands.driveDiffToWithinRangeTop);
        BotControllers.primary.btnY.whenPressed(BotCommands.toggleHook);
        // BotControllers.primary.btnA.whenPressed(BotCommands.toggleRedLegs);
        BotControllers.primary.btnA.whenPressed(BotCommands.toggleSparkLegs);

        // Shooter
        // BotControllers.secondary.btnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);
        // BotControllers.secondary.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
        BotControllers.secondary.btnBumperRight.whenPressed(BotCommands.shoot);
        BotControllers.secondary.btnBumperLeft.whenPressed(BotCommands.stopShooter);
        BotControllers.secondary.btnStart.whenPressed(BotCommands.resetShoot);
    }

}


package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure "primary" xbox buttons
    public static void configurePrimary() {
        Logger.setup("Configure Buttons -> Primary Controller...");

        // TODO: Convert this to joystick control.

        // DiffDriver
        BotControllers.primary.btnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);
        BotControllers.primary.btnBumperRight.whileHeld(BotCommands.driveDiffToWithinRangeFront);
        BotControllers.primary.btnB.whileHeld(BotCommands.alignDiffDriveToTarget);

        // Climb
        BotControllers.primary.btnBumperLeft.whileHeld(BotCommands.driveDiffToWithinRangeTop);
        BotControllers.primary.btnY.whenPressed(BotCommands.toggleHook);
        // BotControllers.primary.btnA.whenPressed(BotCommands.toggleRedLegs);
        BotControllers.primary.btnA.whenPressed(BotCommands.toggleSparkLegs);

        // TODO: Use the triggers for the balancer, so that you have fine analog control.
        BotControllers.primary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
        BotControllers.primary.btnDpadRight.whileHeld(BotCommands.balanceRight);
    }

    // Configure "secondary" xbox buttons
    public static void configureSecondary() {
        Logger.setup("Configure Buttons -> Secondary Controller...");
        // RollerArm
        BotControllers.secondary.btnY.whenPressed(BotCommands.toggleRollerArm);

        // Roller
        //BotControllers.secondary.btnX.whileHeld(BotCommands.reverseRoller);
        BotControllers.secondary.btnB.whileHeld(BotCommands.spinRollerAndConveyor);

        // Conveyor & Shooter
        BotControllers.secondary.btnBumperLeft.whileHeld(BotCommands.reverseConveyor);
        BotControllers.secondary.btnBumperRight.whileHeld(BotCommands.reverseConveyorAndShoot);
    }

}

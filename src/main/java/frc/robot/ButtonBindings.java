
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");

        // TODO: Convert this to joystick control.

        // DiffDriver
        BotControllers.primary.btnBumperRight.whileHeld(BotCommands.driveDiffToWithinRangeFront);
        BotControllers.primary.btnB.whileHeld(BotCommands.alignDiffDriveToTarget);

        // Limelight
        //BotControllers.primary.btnB.whenReleased(BotCommands.turnOffLimelightArray);

        // Climb
        BotControllers.primary.btnBumperLeft.whileHeld(BotCommands.driveDiffToWithinRangeTop);
        BotControllers.primary.btnY.whenPressed(BotCommands.toggleHook); // Tested
        BotControllers.primary.btnA.whenPressed(BotCommands.toggleRedLegs); // Tested

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
        BotControllers.secondary.btnB.whileHeld(BotCommands.spinRollerAndConveyor); // Tested

        // Conveyor & Shooter
        BotControllers.secondary.btnA.whileHeld(BotCommands.reverseConveyor);
        BotControllers.secondary.btnBumperLeft.whileHeld(BotCommands.stopConveyorAndShooter);
        BotControllers.secondary.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
        BotControllers.secondary.btnStart.whenPressed(BotCommands.resetShoot);
    }

    //     // TODO: Use the triggers for the balancer, so that you have fine analog control.
    //     // BotControllers.primary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
    //     // BotControllers.primary.btnDpadRight.whileHeld(BotCommands.balanceRight);
    // }


    // Configure joystick buttons
    public static void configureJoystick() {
        Logger.setup("Configure Buttons -> Joystick...");

        // Drive
        BotJoystick.joystick.jstickBtn1.whileHeld(BotCommands.alignDiffDriveToGyro);

        // Climb
        BotJoystick.joystick.jstickBtn11.whenPressed(BotCommands.toggleHook);
        BotJoystick.joystick.jstickBtn12.whenPressed(BotCommands.toggleSparkLegs);
    }
}


package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure xbox buttons
    // public static void configureXbox() {
    //     Logger.setup("Configure Buttons -> Xbox Controller...");

    // TODO: Convert this to joystick control.

    // DiffDriver
    //     BotControllers.primary.btnBumperRight.whileHeld(BotCommands.driveDiffToWithinRangeFront);
    //     BotControllers.primary.btnB.whileHeld(BotCommands.alignDiffDriveToTarget);

    // Limelight
    //     BotControllers.primary.btnB.whenReleased(BotCommands.turnOffLimelightArray);

    // Climb
    //     BotControllers.primary.btnBumperLeft.whileHeld(BotCommands.driveDiffToWithinRangeTop);
    //     BotControllers.primary.btnY.whenPressed(BotCommands.toggleHook);
    //     BotControllers.primary.btnA.whenPressed(BotCommands.toggleRedLegs);
    //     BotControllers.primary.btnA.whenPressed(BotCommands.toggleSparkLegs);

    //     TODO: Use the triggers for the balancer, so that you have fine analog control.
    //     BotControllers.primary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
    //     BotControllers.primary.btnDpadRight.whileHeld(BotCommands.balanceRight);
    // }

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");
        // RollerArm
        BotControllers.xbox.btnY.whenPressed(BotCommands.toggleRollerArm);

        // Roller
        //BotControllers.secondary.btnX.whileHeld(BotCommands.reverseRoller);
        BotControllers.xbox.btnB.whileHeld(BotCommands.spinRollerAndConveyor);

        // Conveyor & Shooter
        BotControllers.xbox.btnBumperLeft.whileHeld(BotCommands.reverseConveyor);
        BotControllers.xbox.btnBumperRight.whileHeld(BotCommands.reverseConveyorAndShoot);
    }

    //     // TODO: Use the triggers for the balancer, so that you have fine analog control.
    //     // BotControllers.primary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
    //     // BotControllers.primary.btnDpadRight.whileHeld(BotCommands.balanceRight);
    // }


    // Configure joystick buttons
    public static void configureJoystick() {
        Logger.setup("Configure Buttons -> Joystick...");

        // Drive
        BotJoystick.joystick.jstickBtn1.whileHeld(BotCommands.alignDiffDriveToTarget);

        // Climb
        BotJoystick.joystick.jstickBtn11.whenPressed(BotCommands.toggleHook);
        BotJoystick.joystick.jstickBtn12.whenPressed(BotCommands.toggleSparkLegs);
    }
}

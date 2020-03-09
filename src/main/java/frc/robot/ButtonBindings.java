
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    //Configure xbox buttons
    public static void configureJoystick() {
        Logger.setup("Configure Buttons -> Joystick Controller...");

    //DiffDriver
        BotControllers.jstick.jstickBtn1.whileHeld(BotCommands.alignDiffDriveToTarget);

    //Limelight
        BotControllers.jstick.jstickBtn1.whenReleased(BotCommands.turnOffLimelightArray);

    //Climb
        BotControllers.jstick.jstickBtn9.whileHeld(BotCommands.stopHook);
        BotControllers.jstick.jstickBtn11.whenPressed(BotCommands.toggleHook);
        BotControllers.jstick.jstickBtn12.whenPressed(BotCommands.toggleRedLegs);
        BotControllers.jstick.jstickBtn7.whileHeld(BotCommands.alignDiffDriveToGyro);

        BotControllers.jstick.jstickBtn3.whileHeld(BotCommands.balanceLeft);
        BotControllers.jstick.jstickBtn4.whileHeld(BotCommands.balanceRight);
    }

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");
        // RollerArm
        BotControllers.xbox.btnY.whenPressed(BotCommands.toggleRollerArm);

        // Roller
        //BotControllers.secondary.btnX.whileHeld(BotCommands.reverseRoller);
        // BotControllers.xbox.btnB.whileHeld(BotCommands.spinRollerAndConveyor);

        // Conveyor & Shooter
        BotControllers.xbox.btnX.whileHeld(BotCommands.spinRollerAndConveyor);
        BotControllers.xbox.btnB.whileHeld(BotCommands.reverseConveyor);

        // BotControllers.xbox.btnBumperLeft.whileHeld(BotCommands.reverseConveyor);
        // BotControllers.xbox.btnBumperRight.whileHeld(BotCommands.reverseConveyorAndShoot);
    }

    //     // TODO: Use the triggers for the balancer, so that you have fine analog control.
    //     // BotControllers.primary.btnDpadLeft.whileHeld(BotCommands.balanceLeft);
    //     // BotControllers.primary.btnDpadRight.whileHeld(BotCommands.balanceRight);
    // }

}
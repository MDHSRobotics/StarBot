
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure joystick buttons
    public static void configureJoystick() {
        Logger.setup("Configure Buttons -> Joystick Controller...");

        //DiffDriver
        BotControllers.jstick.jstickBtn1.whileHeld(BotCommands.rotateTowardsTarget);
        BotControllers.jstick.jstickBtn5.whileHeld(BotCommands.rotateTowardsRightRung);
        BotControllers.jstick.jstickBtn6.whileHeld(BotCommands.rotateTowardsLeftRung);

        // BotControllers.jstick.jstickBtn7.whileHeld(BotCommands.alignDiffDriveToGyro);

        //Limelight
        BotControllers.jstick.jstickBtn1.whenReleased(BotCommands.turnOffLimelightArray);

        //Climb
        BotControllers.jstick.jstickBtn9.whenPressed(BotCommands.retractHook);
        BotControllers.jstick.jstickBtn11.whenPressed(BotCommands.toggleHook);
        BotControllers.jstick.jstickBtn12.whenPressed(BotCommands.toggleLegs);

        BotControllers.jstick.jstickBtn3.whileHeld(BotCommands.balanceRight);
        BotControllers.jstick.jstickBtn4.whileHeld(BotCommands.balanceLeft);
    }

    // Configure xbox buttons
    public static void configureXbox() {
        Logger.setup("Configure Buttons -> Xbox Controller...");

        // RollerArm
        BotControllers.xbox.btnY.whenPressed(BotCommands.toggleRollerArm);

        // Roller
        // BotControllers.xbox.btnX.whileHeld(BotCommands.reverseRoller);
        // BotControllers.xbox.btnB.whileHeld(BotCommands.spinRollerAndConveyor);

        // Conveyor & Shooter
        BotControllers.xbox.btnX.whileHeld(BotCommands.spinRollerAndConveyor);
        BotControllers.xbox.btnB.whileHeld(BotCommands.reverseConveyor);
    }

}
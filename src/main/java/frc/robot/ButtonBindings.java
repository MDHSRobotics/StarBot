
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Configure joystick buttons
    public static void configureJoystick() {
        Logger.setup("Configure Buttons -> Joystick Controller...");

        //DiffDriver
        BotControllers.jstick.jstickBtn1.whileHeld(BotCommands.alignDiffDriveToTarget);
        BotControllers.jstick.jstickBtn5.whileHeld(BotCommands.rotateTowardsRightLevel);
        BotControllers.jstick.jstickBtn6.whileHeld(BotCommands.rotateTowardsLeftLevel);

        // BotControllers.jstick.jstickBtn7.whileHeld(BotCommands.alignDiffDriveToGyro);

        //Limelight
        BotControllers.jstick.jstickBtn1.whenReleased(BotCommands.turnOffLimelightArray);

        //Climb
        BotControllers.jstick.jstickBtn9.whenPressed(BotCommands.retractHook);
        BotControllers.jstick.jstickBtn11.whenPressed(BotCommands.toggleHook);
        BotControllers.jstick.jstickBtn12.whenPressed(BotCommands.toggleLegs);

        BotControllers.jstick.jstickBtn3.whileHeld(BotCommands.balanceLeft);
        BotControllers.jstick.jstickBtn4.whileHeld(BotCommands.balanceRight);
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

        // BotControllers.xbox.btnBumperLeft.whileHeld(BotCommands.reverseConveyor);
        BotControllers.xbox.btnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
        BotControllers.xbox.btnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);
        BotControllers.xbox.btnStart.whenPressed(BotCommands.resetShoot);

    }

}
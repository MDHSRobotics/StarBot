
package frc.robot;

import frc.robot.consoles.Logger;
import frc.robot.oi.ControlDevices;

// Configures all the button->command bindings for the robot.
public class ButtonBindings {

    // Check controllers and configure button bindings
    public static void configure() {
        Logger.setup("Configuring ButtonBindings...");

        if (!ControlDevices.isDriveXboxConnected()) {
            Logger.error("Drive XBox controller not plugged in!");
        } else {
            configureDriveXBoxButtons();
        }
    }

    // Configure "drive" xbox buttons
    public static void configureDriveXBoxButtons() {
        Logger.setup("Configure Buttons -> Drive Xbox Controller...");

        // TODO: There are conflicts with buttons after merge. Resolve.

        // Climb
        ControlDevices.driveXboxBtnA.whenPressed(BotCommands.toggleHook);
        ControlDevices.driveXboxBtnB.whenPressed(BotCommands.toggleLegs);
        ControlDevices.driveXboxBtnX.whileHeld(BotCommands.rollerForward);
        ControlDevices.driveXboxBtnY.whileHeld(BotCommands.rollerReverse);

        // DiffDriver
        ControlDevices.driveXboxBtnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);

        // Roller
        ControlDevices.driveXboxBtnB.whileHeld(BotCommands.spinRoller);

        // RollerArm
        ControlDevices.driveXboxBtnX.whenPressed(BotCommands.toggleRollerArm);

        // Shooter?
        ControlDevices.driveXboxBtnBumperRight.whenPressed(BotCommands.reverseConveyorAndShoot);
        ControlDevices.driveXboxBtnBumperLeft.whenPressed(BotCommands.stopConveyorAndShooter);

        // TODO: This is configuring buttons for the shoot xbox controller in a method called configureDriveXboxButtons()
        // Climb/Shoot Controller
        ControlDevices.shootXboxBtnBumperLeft.whileHeld(BotCommands.reverseConveyor);
    }

}

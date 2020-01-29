
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

        ControlDevices.driveXboxBtnDpad.whileHeld(BotCommands.alignDiffDriveToGyro);
        ControlDevices.driveXboxBtnB.whileHeld(BotCommands.spinRoller);
        ControlDevices.driveXboxBtnX.whenPressed(BotCommands.toggleRollerArm);
        
        ControlDevices.driveXboxBtnBumperRight.whenPressed(BotCommands.shoot);
        ControlDevices.driveXboxBtnBumperLeft.whenPressed(BotCommands.stopShoot);
        
        ControlDevices.driveXboxBtnA.whenPressed(BotCommands.toggleHook);
        ControlDevices.driveXboxBtnB.whenPressed(BotCommands.toggleLegs);
        ControlDevices.driveXboxBtnX.whileHeld(BotCommands.rollerForward);
        ControlDevices.driveXboxBtnY.whileHeld(BotCommands.rollerReverse);
        
        ControlDevices.driveXboxBtnBumperRight.whenPressed(BotCommands.csCommandGroup);
        ControlDevices.driveXboxBtnBumperLeft.whenPressed(BotCommands.stopCSCommandGroup);

        // Climb/Shoot Controller
        ControlDevices.shootXboxBtnBumperLeft.whileHeld(BotCommands.reverseConveyor);
        ControlDevices.driveXboxBtnY.whenPressed(BotCommands.csCommandGroup);
    }

}

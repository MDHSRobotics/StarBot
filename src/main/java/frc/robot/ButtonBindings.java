
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

        ControlDevices.driveXboxBtnA.whenPressed(BotCommands.cycleLights);
        ControlDevices.driveXboxBtnB.whileHeld(BotCommands.rollerSpin);
        ControlDevices.driveXboxBtnX.whenPressed(BotCommands.togglePickUp);
    }

}

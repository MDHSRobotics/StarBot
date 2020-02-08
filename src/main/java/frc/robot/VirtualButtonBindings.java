
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the virtual button->command bindings for testing the robot.
public class VirtualButtonBindings {

    // Configure "primary" virtual buttons
    public static void configurePrimary() {
        Logger.setup("Configure Virtual Buttons -> Primary Virtual Controller...");

        // DiffDriver
        VirtualControllers.primary.btnDpad.whileActiveContinuous(TestCommands.alignDiffDriveToGyro);
        VirtualControllers.primary.btnDpad.whileActiveContinuous(TestCommands.driveDiffTank);
        VirtualControllers.primary.btnBumperRight.whileActiveContinuous(TestCommands.centerDiffDriveOnTarget);

        //Roller
        VirtualControllers.primary.btnB.whileActiveContinuous(TestCommands.spinRoller);
    }

    // Configure "secondary" virtual buttons
    public static void configureSecondary() {
        Logger.setup("Configure Virtual Buttons -> Secondary Virtual Controller...");

        // Conveyor
        VirtualControllers.secondary.btnBumperLeft.whileActiveContinuous(BotCommands.reverseConveyor);
    }

}

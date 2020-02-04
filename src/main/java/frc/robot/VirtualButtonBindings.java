
package frc.robot;

import frc.robot.consoles.Logger;

// Configures all the virtual button->command bindings for testing the robot.
public class VirtualButtonBindings {

    // Configure "primary" virtual buttons
    public static void configurePrimary() {
        Logger.setup("Configure Virtual Buttons -> Primary Virtual Controller...");

        // DiffDriver
        VirtualControllers.primary.btnDpad.whileActiveContinuous(TestCommands.alignDiffDriveToGyro);

        //Roller
        BotControllers.primary.btnB.whileActiveContinuous(BotCommands.spinRoller);

        // RollerArm
        BotControllers.primary.btnX.whenActive(BotCommands.toggleRollerArm);

        // Shooter
        BotControllers.primary.btnBumperRight.whenActive(BotCommands.reverseConveyorAndShoot);
        BotControllers.primary.btnBumperLeft.whenActive(BotCommands.stopConveyorAndShooter);
    }

    // Configure "secondary" virtual buttons
    public static void configureSecondary() {
        Logger.setup("Configure Virtual Buttons -> Secondary Virtual Controller...");

        // Conveyor
        VirtualControllers.secondary.btnBumperLeft.whileActiveContinuous(BotCommands.reverseConveyor);

        //Climb
        VirtualControllers.secondary.btnA.whenActive(BotCommands.toggleHook);
        VirtualControllers.secondary.btnB.whenActive(BotCommands.toggleLegs);
        VirtualControllers.secondary.btnX.whileActiveContinuous(BotCommands.rollerForward);
        VirtualControllers.secondary.btnY.whileActiveContinuous(BotCommands.rollerReverse);
    }

}

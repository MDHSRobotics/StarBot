
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.lighter.*;
import frc.robot.commands.pickUpPneumatic.LowerPickUp;
import frc.robot.commands.pickUpPneumatic.RetractPickUp;
import frc.robot.commands.pickUpPneumatic.TogglePickUp;
import frc.robot.commands.roller.*;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickUpPneumatic;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    public static CycleLights cycleLights;
    public static RollerSpin rollerSpin;
    public static RetractPickUp retractPickUpPneumatic;
    public static LowerPickUp lowerPickUpPneumatic;
    public static TogglePickUp togglePickUp;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        cycleLights = new CycleLights(BotSubsystems.lighter);
        rollerSpin = new RollerSpin(BotSubsystems.roller);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}

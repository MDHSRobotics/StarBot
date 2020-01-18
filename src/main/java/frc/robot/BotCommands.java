
package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.conveyor.*;
import frc.robot.commands.diffdriver.*;
import frc.robot.commands.lighter.*;
import frc.robot.commands.roller.*;
import frc.robot.commands.rollerarm.*;
import frc.robot.consoles.Logger;

// Contains singleton instances of all the commands on the robot.
public class BotCommands {

    // Conveyor
    public static Convey convey;

    // DiffDriver
    public static DriveDifferentialTank driveDifferentialTank;

    // Lighter
    public static CycleLights cycleLights;

    // Roller
    public static SpinRoller rollerSpin;
    public static StopRoller rollerStop;

    // RollerArm
    public static LowerRollerArm lowerRollerArm;
    public static RaiseRollerArm raiseRollerArm;
    public static ToggleRollerArm toggleRollerArm;

    // Initialize all robot commands
    public static void initializeCommands() {
        Logger.setup("Initializing BotCommands...");

        // Conveyor
        convey = new Convey(BotSubsystems.conveyor);

        // DiffDriver
        driveDifferentialTank = new DriveDifferentialTank(BotSubsystems.diffDriver);

        // Lighter
        cycleLights = new CycleLights(BotSubsystems.lighter);

        // Roller
        rollerSpin = new SpinRoller(BotSubsystems.roller);
        rollerStop = new StopRoller(BotSubsystems.roller);

        // RollerArm
        lowerRollerArm = new LowerRollerArm(BotSubsystems.rollerArm);
        raiseRollerArm = new RaiseRollerArm(BotSubsystems.rollerArm);
        toggleRollerArm = new ToggleRollerArm(BotSubsystems.rollerArm);
    }

    // Return the command to run in autonomous mode
    public static Command getAutonomousCommand() {
        return cycleLights;
    }

}

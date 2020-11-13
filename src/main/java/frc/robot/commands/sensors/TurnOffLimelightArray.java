
package frc.robot.commands.sensors;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Limelight;

// This command turns off the limelight LEDs.
public class TurnOffLimelightArray extends InstantCommand {

    public TurnOffLimelightArray() {
        Logger.setup("Constructing InstantCommand: TurnOffLimelightArray...");
    }

    @Override
    public void initialize() {
        // LEDs turned on in AlignDiffDriveToTarget command
        Limelight.calculateDistanceToTarget(); // calculates distance for ShooterBrain
        Limelight.ledOff();
    }

}

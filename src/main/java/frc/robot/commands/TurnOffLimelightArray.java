package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Limelight;

// This method will turn off the limelight LEDs when the target button is released
public class TurnOffLimelightArray extends CommandBase {

    public TurnOffLimelightArray() {
        Logger.setup("Constructing Command: TurnOffLimelightArray...");
    }

    @Override
    public void initialize() {
        // LEDs turned on in AlignDiffDriveToTarget command
        Limelight.ledOff();
    }

    @Override
    public void execute() {
    }

    // This finishes immediately, but is intended to be continually restarted while a button is held
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: TurnOffLimelightArray...");
        }
    }

}

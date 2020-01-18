package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

// Lighter subsystem, for turning lights on and off.
public class Autonomous extends SubsystemBase {

    public Autonomous() {
        Logger.setup("Constructing Subsystem: Autonomous...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }


}
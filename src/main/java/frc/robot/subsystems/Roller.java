
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.RollerBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxRoller;

// Roller Subsytem, for sucking in balls.
public class Roller extends SubsystemBase {

    public Roller() {
         Logger.setup("Constructing Subsystem: Roller...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the roller
    public void stop() {
        talonSrxRoller.stopMotor();
    }

    // Spin the roller
    public void spin() {
        double power = RollerBrain.getPower();
        talonSrxRoller.set(power);
    }

}

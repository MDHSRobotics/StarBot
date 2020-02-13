
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.RollerBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxRoller;
import static frc.robot.RobotManager.isReal;

// Roller Subsytem, for sucking in balls.
public class Roller extends SubsystemBase {

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public Roller() {
         Logger.setup("Constructing Subsystem: Roller...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxRoller == null);
        if (m_disabled) {
            Logger.problem("Roller devices not initialized! Disabling subsystem...");
            return;
        }

        if (isReal) {
            // Configure the subsystem devices
            talonSrxRoller.configFactoryDefault();
        }

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the roller
    public void stop() {
        if (m_disabled) return;
        talonSrxRoller.stopMotor();
    }

    // Spin the roller
    public void spin() {
        double power = RollerBrain.getPower();
        if (m_disabled) return;
        talonSrxRoller.set(power);
    }

}

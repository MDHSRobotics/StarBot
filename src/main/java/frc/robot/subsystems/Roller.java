package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import frc.robot.BotSubsystems;
import frc.robot.SubsystemDevices;
import frc.robot.commands.roller.RollerSpin;

// Claw Wheel Subsytem, for sucking in boxes and spitting them out thru the barrier
public class Roller extends SubsystemBase {

    private final double WHEEL_POWER = 0.2;

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Roller() {
         Logger.setup("Constructing Subsystem: Roller...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.talonSrxRoller == null);
        if (m_disabled) {
            Logger.error("Roller devices not initialized! Disabling subsystem...");
            return;
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the Roller claw motor
    public void stop() {
        SubsystemDevices.talonSrxRoller.stopMotor();
        Logger.setup("Roller Motors Disconnected! Shutting down wheels...");
    }

    public void ejectBox() {
        SubsystemDevices.talonSrxRoller.set(WHEEL_POWER);
    }

    public void insertBox() {
        SubsystemDevices.talonSrxRoller.set(-WHEEL_POWER);
    }

}

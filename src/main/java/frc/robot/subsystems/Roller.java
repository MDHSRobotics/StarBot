package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import frc.robot.BotSubsystems;
import frc.robot.SubsystemDevices;
import frc.robot.commands.roller.RollerSpin;

// Claw Wheel Subsytem, for sucking in boxes and spitting them out thru the barrier
public class Roller extends BotSubsystems {

    private final double WHEEL_POWER = 0.2;

    private boolean m_talonsAreConnected = false;

    public Roller() {
        Logger.setup("Constructing Subsystem: Roller...");

        boolean talonRollerConnected = SubsystemDevices.isConnected(SubsystemDevices.talonSrxRoller);

        m_talonsAreConnected = talonRollerConnected;

        if (!m_talonsAreConnected) {
            Logger.error("Roller talons not all connected! Disabling Roller...");
        } else {
            SubsystemDevices.talonSrxRoller.configFactoryDefault();
        }
    }

    // Stop the Hatcher claw motor
    public void stop() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSrxRoller.stopMotor();
        Logger.setup("Roller Motors Disconnected! Shutting down wheels...");
    }

    public void ejectBox() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSrxRoller.set(WHEEL_POWER);
    }

    public void insertBox() {
        if (!m_talonsAreConnected)
            return;
        SubsystemDevices.talonSrxRoller.set(-WHEEL_POWER);
    }

}

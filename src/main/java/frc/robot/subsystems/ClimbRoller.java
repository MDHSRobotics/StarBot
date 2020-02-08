
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbRollerBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimbRoller;

// ClimbRoller Subsytem, for sucking in balls
public class ClimbRoller extends SubsystemBase {

    // If any of the motor ClimbRollers are null, this should be true
    private boolean m_disabled = false;
    public boolean armIsUp = true;

    public ClimbRoller() {
        Logger.setup("Constructing Subsystem: ClimbRoller...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxClimbRoller == null);
        if (m_disabled) {
            Logger.problem("ClimbRoller devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        talonSrxClimbRoller.configFactoryDefault();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the ClimbRoller motor
    public void stop() {
        if (m_disabled)
            return;
        talonSrxClimbRoller.stopMotor();
    }

    // Spin the ClimbRoller motor
    public void forward() {
        if (m_disabled)
            return;
        double power = ClimbRollerBrain.getClimbRollerPower();
        talonSrxClimbRoller.set(power);
    }

    public void reverse() {
        if (m_disabled)
            return;
        double power = ClimbRollerBrain.getClimbRollerPower();
        talonSrxClimbRoller.set(-power);
    }
}

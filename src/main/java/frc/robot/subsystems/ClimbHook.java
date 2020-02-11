
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbHookBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimbHook;

// ClimbHook Subsystem, for hooking onto the lever.
public class ClimbHook extends SubsystemBase {

    // State variables
    public boolean hookIsBack = true;

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public ClimbHook() {
         Logger.setup("Constructing Subsystem: ClimbHook...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxClimbHook == null);
        if (m_disabled) {
            Logger.problem("ClimbHook devices not initialized! Disabling subsystem...");
            return;
        }

        if (RobotBase.isReal()) {
            // Configure the subsystem devices
            talonSrxClimbHook.configFactoryDefault();
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Toggle the hook position
    public void toggleHookPosition() {
        hookIsBack = !hookIsBack;
    }

    // Stop the hook
    public void stop() {
        if (m_disabled) return;
        talonSrxClimbHook.stopMotor();
    }

    // Move the hook forward
    public void moveForward() {
        if (m_disabled) return;
        double power = ClimbHookBrain.getPower();
        talonSrxClimbHook.set(power);
    }

    // Move the hook backward
    public void moveBackward() {
        if (m_disabled) return;
        double power = ClimbHookBrain.getPower();
        talonSrxClimbHook.set(-power);
    }

}

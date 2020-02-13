
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbHookBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimbHook;

// ClimbHook Subsystem, for hooking onto the lever.
public class ClimbHook extends SubsystemBase {

    // State variables
    public boolean hookIsBack = true;

    public ClimbHook() {
         Logger.setup("Constructing Subsystem: ClimbHook...");
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
        talonSrxClimbHook.stopMotor();
    }

    // Move the hook forward
    public void moveForward() {
        double power = ClimbHookBrain.getPower();
        talonSrxClimbHook.set(power);
    }

    // Move the hook backward
    public void moveBackward() {
        double power = ClimbHookBrain.getPower();
        talonSrxClimbHook.set(-power);
    }

}

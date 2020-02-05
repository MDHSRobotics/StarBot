
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbArmBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimbArm;

// ClimbArm Subsytem, for sucking in balls
public class ClimbArm extends SubsystemBase {

    // If any of the motor contClimbArms are null, this should be true
    private boolean m_disabled = false;
    public boolean armIsUp = true;

    public ClimbArm() {
         Logger.setup("Constructing Subsystem: ClimbArm...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxClimbArm == null);
        if (m_disabled) {
            Logger.error("ClimbArm devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        talonSrxClimbArm.configFactoryDefault();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the ClimbArm motor
    public void stop() {
        if (m_disabled) return;
        talonSrxClimbArm.stopMotor();
    }

    // Spin the ClimbArm motor
    public void turn() {
        if (m_disabled) return;
        double power = ClimbArmBrain.getClimbArmPower();
        talonSrxClimbArm.set(power);
    }

    public void retract() {
        if (m_disabled) return;
        double power = ClimbArmBrain.getClimbArmPower();
        talonSrxClimbArm.set(-power);
    }

    public void toggleArmPosition() {
        armIsUp = !armIsUp;
    }

}

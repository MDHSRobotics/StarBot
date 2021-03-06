
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.compressorRollerArm;
import static frc.robot.subsystems.Devices.solenoidRollerArm;

// Arm subsystem for the Roller, for raising and lowering the Roller.
public class RollerArm extends SubsystemBase {

    public enum RollerArmPosition {
        raise, lower;
    }

    // State variables
    public boolean armIsUp = true;

    public RollerArm() {
        Logger.setup("Constructing Subsystem: RollerArm...");

        // Configure devices
        compressorRollerArm.setClosedLoopControl(true);
        solenoidRollerArm.set(false);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Get the current being used by the roller arm compressor
    public int getCurrent() {
        return (int)compressorRollerArm.getCompressorCurrent();
    }

    // Toggle the position of the roller arm
    public void toggleArmPosition() {
        armIsUp = !armIsUp;
    }

    // Raise or lower the roller arm
    public void moveArm(RollerArmPosition rollerArmPosition) {
        switch(rollerArmPosition) {
            case raise:
                solenoidRollerArm.set(true);
                break;
            case lower:
                solenoidRollerArm.set(false);
                break;
        }

    }

}

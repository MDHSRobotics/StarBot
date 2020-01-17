
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

// Climb subsystem, for pulling robot up and down.
public class Climb extends SubsystemBase {

    public Climb () {
        Logger.setup("Constructing Subsystem: Climb...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void standForward() {
        SubsystemDevices.sparkMaxClimbStandOne.set(0.5);
        SubsystemDevices.sparkMaxClimbStandTwo.set(0.5);
        SubsystemDevices.sparkMaxClimbStandThree.set(0.5);
        SubsystemDevices.sparkMaxClimbStandFour.set(0.5);
        }

    public void standReverse() {
        SubsystemDevices.sparkMaxClimbStandOne.set(-0.5);
        SubsystemDevices.sparkMaxClimbStandTwo.set(-0.5);
        SubsystemDevices.sparkMaxClimbStandThree.set(-0.5);
        SubsystemDevices.sparkMaxClimbStandFour.set(-0.5);
    }

    public void extendArm() {
        SubsystemDevices.sparkMaxClimbArm.set(0.5);
    }

    public void retractArm() {

    }

    public void stop() {
        SubsystemDevices.sparkMaxClimbArm.stopMotor();
        SubsystemDevices.sparkMaxClimbStandOne.stopMotor();
        SubsystemDevices.sparkMaxClimbStandTwo.stopMotor();
        SubsystemDevices.sparkMaxClimbStandThree.stopMotor();
        SubsystemDevices.sparkMaxClimbStandFour.stopMotor();

    }



}

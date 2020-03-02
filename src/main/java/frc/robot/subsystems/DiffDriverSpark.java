
package frc.robot.subsystems;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.diffDriveSpark;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelFrontLeft;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelFrontRight;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelRearLeft;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelRearRight;

// Differential driver subsystem for the spark max controllers.
public class DiffDriverSpark extends DiffDriver {

    public DiffDriverSpark() {
        super(diffDriveSpark);
        Logger.setup("Constructing Subsystem: DiffDriverSpark...");

        sparkMaxDiffWheelRearLeft.follow(sparkMaxDiffWheelFrontLeft);
        sparkMaxDiffWheelRearRight.follow(sparkMaxDiffWheelFrontRight);
    }

}

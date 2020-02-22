
package frc.robot.subsystems;

import frc.robot.consoles.Logger;
import frc.robot.devices.DevCANSparkMax;

import static frc.robot.subsystems.Devices.diffDriveSpark;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelFrontLeft;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelFrontRight;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelRearLeft;
import static frc.robot.subsystems.Devices.sparkMaxDiffWheelRearRight;
import static frc.robot.RobotManager.isReal;

// Differential driver subsystem for the spark max's.
public class DiffDriverSpark extends DiffDriver {

    public DiffDriverSpark() {
        Logger.setup("Constructing Subsystem: DiffDriverSpark...");

        m_diffDrive = diffDriveSpark;

        if (isReal) {
            // Configure the subsystem devices
            configureSpark(sparkMaxDiffWheelFrontLeft);
            configureSpark(sparkMaxDiffWheelFrontRight);
            configureSpark(sparkMaxDiffWheelRearLeft);
            configureSpark(sparkMaxDiffWheelRearRight);
            sparkMaxDiffWheelRearLeft.follow(sparkMaxDiffWheelFrontLeft);
            sparkMaxDiffWheelRearRight.follow(sparkMaxDiffWheelFrontRight);
        }
    }

    // Configure the given spark max
    private void configureSpark(DevCANSparkMax spark) {
        if (!spark.isConnected) return;

        spark.restoreFactoryDefaults();
    }

}

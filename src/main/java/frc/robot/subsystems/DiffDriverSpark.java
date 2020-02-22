
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.DiffDriverBrain;
import frc.robot.consoles.Logger;
import frc.robot.devices.DevCANSparkMax;
import frc.robot.sensors.DistanceSensor;
import frc.robot.sensors.Gyro;
import frc.robot.BotSensors;

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
            configureSparkMax(sparkMaxDiffWheelFrontLeft);
            configureSparkMax(sparkMaxDiffWheelFrontRight);
            configureSparkMax(sparkMaxDiffWheelRearLeft);
            configureSparkMax(sparkMaxDiffWheelRearRight);

            sparkMaxDiffWheelRearLeft.follow(sparkMaxDiffWheelFrontLeft);
            sparkMaxDiffWheelRearRight.follow(sparkMaxDiffWheelFrontRight);
        }
    }

    // Configure the given spark max
    private void configureSparkMax(DevCANSparkMax sparkMax) {
        if (!sparkMax.isConnected) return;

        sparkMax.restoreFactoryDefaults();
    }

}

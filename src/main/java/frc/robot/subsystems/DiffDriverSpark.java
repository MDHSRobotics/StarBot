
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.DiffDriverBrain;
import frc.robot.consoles.Logger;
import frc.robot.sensors.DistanceSensor;
import frc.robot.sensors.Gyro;
import frc.robot.BotSensors;

import static frc.robot.subsystems.Devices.diffDriveSpark;

// Differential driver subsystem for the spark max's.
public class DiffDriverSpark extends DiffDriver {

    public DiffDriverSpark() {
        Logger.setup("Constructing Subsystem: DiffDriverSpark...");

    @Override

    // Drive using the tank method
    public void driveTank(double leftSpeed, double rightSpeed) {
        // Logger.info("Left Speed: " + leftSpeed + "; Right Speed: " + rightSpeed);
        diffDriveSpark.tankDrive(leftSpeed, rightSpeed);
    }


    // Drive to center the robot perpendicular to the shoot target
    // based on the detected distance to the near side arena wall
        }
    }

    // TODO: Use this to indicate to the driver that the robot is aligned with the target (lights? Shuffleboard?)
    public static boolean isAligned(double targetAngle) {
        boolean straight = Gyro.isYawAligned(targetAngle);

        Logger.info("DiffDriverSpark -> Robot is fully aligned!");
    }

}


package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.consoles.Logger;
import frc.robot.sensors.Camera;
import frc.robot.sensors.DistanceSensor;
import frc.robot.sensors.Gyro;


import static frc.robot.RobotManager.isReal;

// This class contains singleton instances of id mapped sensors.
public class BotSensors {

    // Analog Inputs
    public static final AnalogInput distanceSensorFront = new AnalogInput(0); // pins 3, 6 and 7 from MB1013 to analog input 0
    public static final AnalogInput distanceSensorTop = new AnalogInput(1); // pins 3, 6 and 7 from MB1013 to analog input 1

    // Attitude and Heading Reference Systems
    public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

    // Webcam for streaming to console
    public static UsbCamera climbCamera;

    // This initialization is called in RobotManager at startup.
    public static void initializeSensors() {
        Logger.setup("Initializing BotSensors...");

        if (isReal) {
            DistanceSensor.initializeDistanceSensor(distanceSensorFront);
            DistanceSensor.initializeDistanceSensor(distanceSensorTop);
            Gyro.initializeGyro(gyro);
            climbCamera = Camera.initializeCamera(0);
        } else {
            Logger.setup("Skipping initializion of sensors in Simulation mode...");
        }
    }

}

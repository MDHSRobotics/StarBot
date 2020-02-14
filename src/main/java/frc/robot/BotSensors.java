
package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.consoles.Logger;

import static frc.robot.RobotManager.isReal;

// This class contains singleton instances of id mapped sensors.
public class BotSensors {

    // Analog Inputs
    public static final AnalogInput distanceSensorFront = new AnalogInput(0); // pins 3, 6 and 7 from MB1013 to analog input 0
    public static final AnalogInput distanceSensorTop = new AnalogInput(1); // pins 3, 6 and 7 from MB1013 to analog input 1
    // Attitude and Heading Reference Systems
    public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

    // This initialization is called in RobotManager at startup.
    public static void initializeSensors() {
        Logger.setup("Initializing BotSensors...");

        if (isReal) {
            initializeDistanceSensorFront();
            initializeDistanceSensorTop();
            initializeGyro();
        } else {
            Logger.setup("Skipping initializion of sensors in Simulation mode...");
        }
    }

    // Distance Sensor Front
    private static void initializeDistanceSensorFront() {
        // TODO: How can we check connections?
        boolean distanceSensorFrontIsConnected = true;
        if (!distanceSensorFrontIsConnected) {
            Logger.problem("Distance sensor not connected!");
        }
    }

    //Distance Sensor Top
    private static void initializeDistanceSensorTop() {
        // TODO: How can we check connections?
        boolean distanceSensorFrontIsConnected = true;
        if (!distanceSensorFrontIsConnected) {
            Logger.problem("Distance sensor not connected!");
        }
    }

    // Gyro
    private static void initializeGyro() {
        boolean gyroIsConnected = gyro.isConnected();
        if (!gyroIsConnected) {
            Logger.problem("Gyro not connected!");
        }
    }

}


package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped sensors.
public class BotSensors {

    // Analog Inputs
    public static final AnalogInput distanceSensor = new AnalogInput(0); // (pins 3, 6 and 7 from MB1013 to analog input 0)

    // Attitude and Heading Reference Systems
    public static final AHRS gyro = new AHRS(SPI.Port.kMXP);

    // This initialization is called in RobotManager at startup.
    public static void initializeSensors() {
        Logger.setup("Initializing BotSensors...");

        if (RobotBase.isReal()) {
            initializeDistanceSensor();
            initializeGyro();
        } else {
            Logger.setup("Skipping initializion of sensors in Simulation mode...");
        }

    }

    // Distance Sensor
    private static void initializeDistanceSensor() {
        // TODO: How can we check connections?
        boolean distanceSensorIsConnected = true;
        if (!distanceSensorIsConnected) {
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

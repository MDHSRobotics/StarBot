
package frc.robot;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped sensors.
public class BotSensors {

    // Gyros
    public static AHRS gyro;

    public static void initializeSensors() {
        Logger.setup("Initializing BotSensors...");

        gyro = new AHRS(SPI.Port.kMXP);
        if (!gyro.isConnected())
            Logger.error("Gyro not connected!");
    }

}

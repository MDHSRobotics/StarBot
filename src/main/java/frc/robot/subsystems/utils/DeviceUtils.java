
package frc.robot.subsystems.utils;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

// Utility methods for devices.
public class DeviceUtils {

    // Determines if the Compressor is connected
    public static boolean isConnected(Compressor compressor) {
        boolean enabled = compressor.enabled();
        return enabled;
    }

    // Determines if the Solenoid is connected
    public static boolean isConnected(Solenoid solenoid) {
        boolean outputOn = solenoid.get();
        return !outputOn;
    }

    // Determines if the Talon FX is connected
    public static boolean isConnected(WPI_TalonFX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}

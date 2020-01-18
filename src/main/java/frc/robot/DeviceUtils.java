
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;

// Utility methods for devices.
public class DeviceUtils {

    // Determines if the Compressor is connected
    public static boolean isConnected(Compressor compressor) {
        boolean notConnected = compressor.getCompressorNotConnectedFault();
        return !notConnected;
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

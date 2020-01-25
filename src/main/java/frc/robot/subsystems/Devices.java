
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.utils.DeviceUtils;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    // Relays
    static Relay relayLighter = new Relay(1);

    // TalonSRX
    static WPI_TalonSRX talonSRXShooterTopWheel = new WPI_TalonSRX(15);
    static WPI_TalonSRX talonSRXShooterBottomWheel = new WPI_TalonSRX(11);

    // Drives
    // TODO: Add the appropriate drives

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing subsystem Devices...");

        // Initialize the devices
        initShooterDevices();
    }

    private static void initShooterDevices() {
        boolean talonSrxShooterTopIsConnected = DeviceUtils.isConnected(talonSRXShooterTopWheel);
        boolean talonSRXShooterBottomIsConnect = DeviceUtils.isConnected(talonSRXShooterBottomWheel);

        if (!(talonSrxShooterTopIsConnected && talonSRXShooterBottomIsConnect)) {
            talonSRXShooterTopWheel = null;
            Logger.error("Shooter talon is not connected! Disabling...");
        }
    }

}


package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped subsystem components, and utility methods.
// IMPORTANT: It is imperative that ONLY subsystems control any interactive device.
// Also, only ONE subsystem should control any given device.
public class SubsystemDevices {

    // Relays
    public static Relay relayLighter = new Relay(1);

    // Motor Controllers
    // TODO: Add the appropriate motor controllers
    public static WPI_TalonSRX talonSRXShooterTopWheel = new WPI_TalonSRX(15);
    public static WPI_TalonSRX talonSRXShooterBottomWheel = new WPI_TalonSRX(15);

    // Drives
    // TODO: Add the appropriate drives

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        // TODO: Initialize the devices
        initShooterDevices();
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

    private static void initShooterDevices() {
        boolean talonSrxShooterTopIsConnected = isConnected(talonSRXShooterTopWheel);
        boolean talonSRXShooterBottomIsConnect = isConnected(talonSRXShooterBottomWheel);

        if (!(talonSrxShooterTopIsConnected && talonSRXShooterBottomIsConnect)) {
            talonSRXShooterTopWheel = null;
            Logger.error("Shooter talon is not connected! Disabling...");
        }
    }

}


package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;

// This class contains singleton instances of id mapped subsystem components, and utility methods.
// IMPORTANT: It is imperative that ONLY subsystems control any interactive device.
// Also, only ONE subsystem should control any given device.
public class SubsystemDevices {

    // Relays
    public static Relay relayLighter = new Relay(1);

    // Motor Controllers
    // TODO: Add the appropriate motor controllers
    public static WPI_TalonSRX talonSrxRoller = new WPI_TalonSRX(1); // 1 motor

    // Pneumatics Controller
    public static final Compressor pcm = new Compressor(0);

    // Solenoids
    public static final Solenoid testSolenoid = new Solenoid(0);
    public static final Solenoid testSolenoid2 = new Solenoid(1);
    //public static final DoubleSolenoid testDoubleSolenoid = new DoubleSolenoid(5, 6);


    // Drives
    // TODO: Add the appropriate drives

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        // TODO: Initialize the devices
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}

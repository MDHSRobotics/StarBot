
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped subsystem components, and utility methods.
// IMPORTANT: It is imperative that ONLY subsystems control any interactive device.
// Also, only ONE subsystem should control any given device.
public class SubsystemDevices {

    // Relays
    public static Relay relayLighter = new Relay(1);

    // Motor Controllers
    public static WPI_TalonSRX talonSrxConveyor = new WPI_TalonSRX(11);
    public static WPI_TalonSRX talonSrxRoller = new WPI_TalonSRX(1); // 1 motor

    // Compressors
    public static Compressor compressorRollerArm = new Compressor(0);

    // Solenoids
    public static Solenoid solenoidRollerArm = new Solenoid(0);

    // Drives
    // TODO: Add the appropriate drives

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        initConveyorDevices();
        initRollerDevices();
        initRollerArmDevices();
    }

    // Conveyor
    private static void initConveyorDevices() {
        boolean talonSrxConveyorIsConnected = isConnected(talonSrxConveyor);

        boolean talonsAreConnected = true;
        if (!talonSrxConveyorIsConnected) {
            talonsAreConnected = false;
            Logger.error("Conveyor talon is not connected!");
        }
    }

    // Roller
    private static void initRollerDevices() {
        boolean talonSrxRollerIsConnected = isConnected(talonSrxRoller);

        if (!talonSrxRollerIsConnected) {
            talonSrxRoller = null;
            Logger.error("Roller talon is not connected! Disabling...");
        }
    }

    // Roller Arm
    private static void initRollerArmDevices() {
        boolean m_compressorRollerArmIsNotConnected = compressorRollerArm.getCompressorNotConnectedFault();

        if (m_compressorRollerArmIsNotConnected) {
            compressorRollerArm = null;
            Logger.error("RollerArm compressor is not connected! Disabling...");
        }
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}

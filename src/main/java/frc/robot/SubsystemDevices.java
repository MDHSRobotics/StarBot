
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped subsystem components, and utility methods.
// IMPORTANT: It is imperative that ONLY subsystems control any interactive device.
// Also, only ONE subsystem should control any given device.
public class SubsystemDevices {

    // Relays
    public static Relay relayLighter = new Relay(1);

    // Compressors
    public static Compressor compressorRollerArm = new Compressor(0);

    // Solenoids
    public static Solenoid solenoidRollerArm = new Solenoid(0);

    // Motor Controllers
    public static WPI_TalonSRX talonSrxDiffWheelFrontLeft = new WPI_TalonSRX(6); // 1 motor
    public static WPI_TalonSRX talonSrxDiffWheelRearLeft = new WPI_TalonSRX(7); // 1 motor
    public static WPI_TalonSRX talonSrxDiffWheelFrontRight = new WPI_TalonSRX(5); // 1 motor
    public static WPI_TalonSRX talonSrxDiffWheelRearRight = new WPI_TalonSRX(8); // 1 motor

    public static WPI_TalonSRX talonSrxConveyor = new WPI_TalonSRX(12);
    public static WPI_TalonSRX talonSrxRoller = new WPI_TalonSRX(15); // 1 motor

    // Drives
    public static DifferentialDrive diffDrive;

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        initConveyorDevices();
        initDiffDriverDevices();
        initRollerDevices();
        initRollerArmDevices();
    }

    // Conveyor
    private static void initConveyorDevices() {
        boolean talonSrxConveyorIsConnected = isConnected(talonSrxConveyor);
        if (!talonSrxConveyorIsConnected) {
            talonSrxConveyor = null;
            Logger.error("Conveyor talon is not connected!");
        }
    }

    // Differential Drive
    private static void initDiffDriverDevices() {
        boolean talonSrxDiffWheelFrontLeftIsConnected = isConnected(talonSrxDiffWheelFrontLeft);
        boolean talonSrxDiffWheelFrontRightIsConnected = isConnected(talonSrxDiffWheelFrontRight);
        boolean talonSrxDiffWheelRearLeftIsConnected = isConnected(talonSrxDiffWheelRearLeft);
        boolean talonSrxDiffWheelRearRightIsConnected = isConnected(talonSrxDiffWheelRearRight);

        boolean talonsAreConnected = true;
        if (!talonSrxDiffWheelFrontLeftIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelFrontLeft talon is not connected!");
        }
        if (!talonSrxDiffWheelFrontRightIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelFrontRight talon is not connected!");
        }
        if (!talonSrxDiffWheelRearLeftIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelRearLeft talon is not connected!");
        }
        if (!talonSrxDiffWheelRearRightIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelRearRight talon is not connected!");
        }

        if (!talonsAreConnected) {
            Logger.error("DiffDriver devices not all connected! Disabling...");
            talonSrxDiffWheelFrontLeft = null;
            talonSrxDiffWheelFrontRight = null;
            talonSrxDiffWheelRearLeft = null;
            talonSrxDiffWheelRearRight = null;
        } else {
            diffDrive = new DifferentialDrive(talonSrxDiffWheelFrontLeft, talonSrxDiffWheelFrontRight);
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

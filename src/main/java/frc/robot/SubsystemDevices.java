
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
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
    public static WPI_TalonFX talonFxDiffWheelFrontLeft = new WPI_TalonFX(6); // 1 motor
    public static WPI_TalonFX talonFxDiffWheelRearLeft = new WPI_TalonFX(7); // 1 motor
    public static WPI_TalonFX talonFxDiffWheelFrontRight = new WPI_TalonFX(5); // 1 motor
    public static WPI_TalonFX talonFxDiffWheelRearRight = new WPI_TalonFX(8); // 1 motor

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
        boolean talonFxDiffWheelFrontLeftIsConnected = isConnected(talonFxDiffWheelFrontLeft);
        boolean talonFxDiffWheelFrontRightIsConnected = isConnected(talonFxDiffWheelFrontRight);
        boolean talonFxDiffWheelRearLeftIsConnected = isConnected(talonFxDiffWheelRearLeft);
        boolean talonFxDiffWheelRearRightIsConnected = isConnected(talonFxDiffWheelRearRight);

        boolean talonsAreConnected = true;
        if (!talonFxDiffWheelFrontLeftIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelFrontLeft talon is not connected!");
        }
        if (!talonFxDiffWheelFrontRightIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelFrontRight talon is not connected!");
        }
        if (!talonFxDiffWheelRearLeftIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelRearLeft talon is not connected!");
        }
        if (!talonFxDiffWheelRearRightIsConnected) {
            talonsAreConnected = false;
            Logger.error("DiffWheelRearRight talon is not connected!");
        }

        if (!talonsAreConnected) {
            Logger.error("DiffDriver devices not all connected! Disabling...");
            talonFxDiffWheelFrontLeft = null;
            talonFxDiffWheelFrontRight = null;
            talonFxDiffWheelRearLeft = null;
            talonFxDiffWheelRearRight = null;
        } else {
            diffDrive = new DifferentialDrive(talonFxDiffWheelFrontLeft, talonFxDiffWheelFrontRight);
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

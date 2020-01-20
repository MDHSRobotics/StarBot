
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

import frc.robot.consoles.Logger;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // Pneumatics
    static Compressor compressorRollerArm = new Compressor(0);
    static Solenoid solenoidRollerArm = new Solenoid(0);

    // Relays
    static Relay relayLighter = new Relay(1);

    // TalonFX
    static WPI_TalonFX talonFxDiffWheelFrontLeft = new WPI_TalonFX(12);
    static WPI_TalonFX talonFxDiffWheelRearLeft = new WPI_TalonFX(4);
    static WPI_TalonFX talonFxDiffWheelFrontRight = new WPI_TalonFX(14);
    static WPI_TalonFX talonFxDiffWheelRearRight = new WPI_TalonFX(13);

    // TalonSRX
    static WPI_TalonSRX talonSrxConveyor = new WPI_TalonSRX(12);
    static WPI_TalonSRX talonSrxRoller = new WPI_TalonSRX(15);

    ////////////////////////
    // Drive Declarations //
    ////////////////////////

    public static DifferentialDrive diffDrive;

    /////////////////////
    // Initializations //
    /////////////////////

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
        boolean talonSrxConveyorIsConnected = DeviceUtils.isConnected(talonSrxConveyor);
        if (!talonSrxConveyorIsConnected) {
            talonSrxConveyor = null;
            Logger.error("Conveyor talon is not connected!");
        }
    }

    // Differential Drive
    private static void initDiffDriverDevices() {
        boolean talonFxDiffWheelFrontLeftIsConnected = DeviceUtils.isConnected(talonFxDiffWheelFrontLeft);
        boolean talonFxDiffWheelFrontRightIsConnected = DeviceUtils.isConnected(talonFxDiffWheelFrontRight);
        boolean talonFxDiffWheelRearLeftIsConnected = DeviceUtils.isConnected(talonFxDiffWheelRearLeft);
        boolean talonFxDiffWheelRearRightIsConnected = DeviceUtils.isConnected(talonFxDiffWheelRearRight);

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
        boolean talonSrxRollerIsConnected = DeviceUtils.isConnected(talonSrxRoller);
        if (!talonSrxRollerIsConnected) {
            talonSrxRoller = null;
            Logger.error("Roller talon is not connected! Disabling...");
        }
    }

    // Roller Arm
    private static void initRollerArmDevices() {
        boolean compressorRollerArmIsConnected = DeviceUtils.isConnected(compressorRollerArm);
        boolean solenoidRollerArmIsConnected = DeviceUtils.isConnected(solenoidRollerArm);

        boolean pneumaticsAreConnected = true;
        if (!compressorRollerArmIsConnected) {
            pneumaticsAreConnected = false;
            Logger.error("RollerArm compressor is not connected!");
        }
        if (!solenoidRollerArmIsConnected) {
            pneumaticsAreConnected = false;
            Logger.error("RollerArm solenoid is not connected!");
        }

        if (!pneumaticsAreConnected) {
            compressorRollerArm = null;
            solenoidRollerArm = null;
            Logger.error("RollerArm pnuematics are not connected! Disabling...");
        }
    }

}


package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.utils.DeviceUtils;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // CANSparkMax
    static SimCANSparkMax sparkMaxClimbLegsMaster = new SimCANSparkMax("sparkMaxClimbLegsMaster", 1, MotorType.kBrushless);
    static SimCANSparkMax sparkMaxClimbLegsSlave = new SimCANSparkMax("sparkMaxClimbLegsSlave", 2, MotorType.kBrushless);

    // Pneumatics
    static SimCompressor compressorRollerArm = new SimCompressor("compressorRollerArm", 0);
    static SimSolenoid solenoidRollerArm = new SimSolenoid("solenoidRollerArm", 0);

    // Relays
    static SimRelay relayLighter = new SimRelay("relayLighter", 1);

    // TalonFX
    static SimTalonFX talonFxDiffWheelFrontLeft = new SimTalonFX("talonFxDiffWheelFrontLeft", 12);
    static SimTalonFX talonFxDiffWheelFrontRight = new SimTalonFX("talonFxDiffWheelFrontRight", 14);
    static SimTalonFX talonFxDiffWheelRearLeft = new SimTalonFX("talonFxDiffWheelRearLeft", 4);
    static SimTalonFX talonFxDiffWheelRearRight = new SimTalonFX("talonFxDiffWheelRearRight", 13);

    // TalonSRX
    static SimTalonSRX talonSrxClimbBalancer = new SimTalonSRX("talonSrxClimbBalancer", 11);
    static SimTalonSRX talonSrxClimbHook = new SimTalonSRX("talonSrxClimbHook", 15);
    static SimTalonSRX talonSrxClimbLegsA = new SimTalonSRX("talonSrxClimbLegsA", 99);
    static SimTalonSRX talonSrxClimbLegsB = new SimTalonSRX("talonSrxClimbLegsB", 100);

    static SimTalonSRX talonSrxConveyor = new SimTalonSRX("", 10);
    static SimTalonSRX talonSrxRoller = new SimTalonSRX("", 99);

    static SimTalonSRX talonSrxShooterBottomWheel = new SimTalonSRX("", 98);
    static SimTalonSRX talonSrxShooterTopWheel = new SimTalonSRX("", 9);

    ////////////////////////
    // Drive Declarations //
    ////////////////////////

    public static SimDifferentialDrive diffDrive;

    /////////////////////
    // Initializations //
    /////////////////////

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing subsystem Devices...");

        initConveyorDevices();
        initDiffDriverDevices();
        initRollerDevices();
        initRollerArmDevices();
        initShooterDevices();
    }

    // Conveyor
    private static void initConveyorDevices() {
        boolean talonSrxConveyorIsConnected = talonSrxConveyor.isConnected();
        if (!talonSrxConveyorIsConnected) {
            talonSrxConveyor = null;
            Logger.problem("Conveyor talon is not connected!");
        }
    }

    // Differential Drive
    private static void initDiffDriverDevices() {
        boolean talonFxDiffWheelFrontLeftIsConnected = talonFxDiffWheelFrontLeft.isConnected();
        boolean talonFxDiffWheelFrontRightIsConnected = talonFxDiffWheelFrontRight.isConnected();
        boolean talonFxDiffWheelRearLeftIsConnected = talonFxDiffWheelRearLeft.isConnected();
        boolean talonFxDiffWheelRearRightIsConnected = talonFxDiffWheelRearRight.isConnected();

        boolean talonsAreConnected = true;
        if (!talonFxDiffWheelFrontLeftIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelFrontLeft talon is not connected!");
        }
        if (!talonFxDiffWheelFrontRightIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelFrontRight talon is not connected!");
        }
        if (!talonFxDiffWheelRearLeftIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelRearLeft talon is not connected!");
        }
        if (!talonFxDiffWheelRearRightIsConnected) {
            talonsAreConnected = false;
            Logger.problem("DiffWheelRearRight talon is not connected!");
        }

        if (!talonsAreConnected) {
            Logger.problem("DiffDriver devices not all connected! Disabling...");
            talonFxDiffWheelFrontLeft = null;
            talonFxDiffWheelFrontRight = null;
            talonFxDiffWheelRearLeft = null;
            talonFxDiffWheelRearRight = null;
        } else {
            diffDrive = new SimDifferentialDrive("Drive", talonFxDiffWheelFrontLeft, talonFxDiffWheelFrontRight);
        }
    }

    // Roller
    private static void initRollerDevices() {
        boolean talonSrxRollerIsConnected = talonSrxRoller.isConnected();
        if (!talonSrxRollerIsConnected) {
            talonSrxRoller = null;
            Logger.problem("Roller talon is not connected! Disabling...");
        }
    }

    // Roller Arm
    private static void initRollerArmDevices() {
        boolean compressorRollerArmIsConnected = compressorRollerArm.isConnected();
        boolean solenoidRollerArmIsConnected = solenoidRollerArm.isConnected();

        boolean pneumaticsAreConnected = true;
        if (!compressorRollerArmIsConnected) {
            pneumaticsAreConnected = false;
            Logger.problem("RollerArm compressor is not connected!");
        }
        if (!solenoidRollerArmIsConnected) {
            pneumaticsAreConnected = false;
            Logger.problem("RollerArm solenoid is not connected!");
        }

        if (!pneumaticsAreConnected) {
            compressorRollerArm = null;
            solenoidRollerArm = null;
            Logger.problem("RollerArm pnuematics are not connected! Disabling...");
        }
    }

    // Shooter
    private static void initShooterDevices() {
        // TODO: Check both talons and log individually if each is not connected.
        //       If either talon is not connected, make both talon instances null, to prevent the need to feed them.
        boolean talonSrxShooterTopIsConnected = talonSrxShooterTopWheel.isConnected();
        boolean talonSRXShooterBottomIsConnect = talonSrxShooterBottomWheel.isConnected();

        if (!(talonSrxShooterTopIsConnected && talonSRXShooterBottomIsConnect)) {
            talonSrxShooterTopWheel = null;
            Logger.problem("Shooter talon is not connected! Disabling...");
        }
    }

}

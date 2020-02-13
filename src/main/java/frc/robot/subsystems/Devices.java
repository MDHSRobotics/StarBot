
package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.consoles.Logger;
import frc.robot.devices.DevCANSparkMax;
import frc.robot.devices.DevCompressor;
import frc.robot.devices.DevDifferentialDrive;
import frc.robot.devices.DevRelay;
import frc.robot.devices.DevSolenoid;
import frc.robot.devices.DevTalonFX;
import frc.robot.devices.DevTalonSRX;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // CANSparkMax
    static DevCANSparkMax sparkMaxClimbLegsMaster = new DevCANSparkMax("sparkMaxClimbLegsMaster", 1, MotorType.kBrushless);
    static DevCANSparkMax sparkMaxClimbLegsSlave = new DevCANSparkMax("sparkMaxClimbLegsSlave", 2, MotorType.kBrushless);

    // Pneumatics
    static DevCompressor compressorRollerArm = new DevCompressor("compressorRollerArm", 0);
    static DevSolenoid solenoidRollerArm = new DevSolenoid("solenoidRollerArm", 0);

    // Relays
    static DevRelay relayLighter = new DevRelay("relayLighter", 1);

    // TalonFX
    static DevTalonFX talonFxDiffWheelFrontLeft = new DevTalonFX("talonFxDiffWheelFrontLeft", 12);
    static DevTalonFX talonFxDiffWheelFrontRight = new DevTalonFX("talonFxDiffWheelFrontRight", 14);
    static DevTalonFX talonFxDiffWheelRearLeft = new DevTalonFX("talonFxDiffWheelRearLeft", 4);
    static DevTalonFX talonFxDiffWheelRearRight = new DevTalonFX("talonFxDiffWheelRearRight", 13);

    // TalonSRX
    static DevTalonSRX talonSrxClimbBalancer = new DevTalonSRX("talonSrxClimbBalancer", 11);
    static DevTalonSRX talonSrxClimbHook = new DevTalonSRX("talonSrxClimbHook", 15);
    static DevTalonSRX talonSrxClimbLegsA = new DevTalonSRX("talonSrxClimbLegsA", 99);
    static DevTalonSRX talonSrxClimbLegsB = new DevTalonSRX("talonSrxClimbLegsB", 100);

    static DevTalonSRX talonSrxConveyor = new DevTalonSRX("talonSrxConveyor", 10);
    static DevTalonSRX talonSrxRoller = new DevTalonSRX("talonSrxRoller", 99);

    static DevTalonSRX talonSrxShooterBottomWheel = new DevTalonSRX("talonSrxShooterBottomWheel", 98);
    static DevTalonSRX talonSrxShooterTopWheel = new DevTalonSRX("talonSrxShooterTopWheel", 9);

    ////////////////////////
    // Drive Declarations //
    ////////////////////////

    public static DevDifferentialDrive diffDrive;

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
            diffDrive = new DevDifferentialDrive("Drive", talonFxDiffWheelFrontLeft, talonFxDiffWheelFrontRight);
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


package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

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
    static CANSparkMax sparkMaxClimbLegMaster = new CANSparkMax(1, MotorType.kBrushless);
    static CANSparkMax sparkMaxClimbLegSlave = new CANSparkMax(2, MotorType.kBrushless);

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
    static WPI_TalonSRX talonSrxConveyor = new WPI_TalonSRX(10);
    static WPI_TalonSRX talonSrxRoller = new WPI_TalonSRX(99);
    static WPI_TalonSRX talonSrxClimbArm = new WPI_TalonSRX(15);
    static WPI_TalonSRX talonSrxClimbRoller = new WPI_TalonSRX(11);
    static WPI_TalonSRX talonSrxRedLineClimbLeg = new WPI_TalonSRX(99);
    static WPI_TalonSRX talonSrxRedLineClimbLeg2 = new WPI_TalonSRX(100);

    static WPI_TalonSRX talonSrxShooterTopWheel = new WPI_TalonSRX(9);
    static WPI_TalonSRX talonSrxShooterBottomWheel = new WPI_TalonSRX(98);

    ////////////////////////
    // Drive Declarations //
    ////////////////////////

    public static DifferentialDrive diffDrive;

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
        boolean talonSrxConveyorIsConnected = DeviceUtils.isConnected(talonSrxConveyor);
        if (!talonSrxConveyorIsConnected) {
            talonSrxConveyor = null;
            Logger.problem("Conveyor talon is not connected!");
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
            diffDrive = new DifferentialDrive(talonFxDiffWheelFrontLeft, talonFxDiffWheelFrontRight);
        }
    }

    // Roller
    private static void initRollerDevices() {
        boolean talonSrxRollerIsConnected = DeviceUtils.isConnected(talonSrxRoller);
        if (!talonSrxRollerIsConnected) {
            talonSrxRoller = null;
            Logger.problem("Roller talon is not connected! Disabling...");
        }
    }

    // Roller Arm
    private static void initRollerArmDevices() {
        boolean compressorRollerArmIsConnected = DeviceUtils.isConnected(compressorRollerArm);
        boolean solenoidRollerArmIsConnected = DeviceUtils.isConnected(solenoidRollerArm);

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
        boolean talonSrxShooterTopIsConnected = DeviceUtils.isConnected(talonSrxShooterTopWheel);
        boolean talonSRXShooterBottomIsConnect = DeviceUtils.isConnected(talonSrxShooterBottomWheel);

        if (!(talonSrxShooterTopIsConnected && talonSRXShooterBottomIsConnect)) {
            talonSrxShooterTopWheel = null;
            Logger.problem("Shooter talon is not connected! Disabling...");
        }
    }

}

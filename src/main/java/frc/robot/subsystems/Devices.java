
package frc.robot.subsystems;

import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.devices.*;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // CANSparkMax
    static CANSparkMaxControllable sparkMaxClimbLegsMaster = DevCANSparkMax.getNew("sparkMaxClimbLegsMaster", 1, MotorType.kBrushless);
    static CANPIDControllable pidClimbLegsMaster = sparkMaxClimbLegsMaster.getPIDControllable("pidClimbLegsMaster");
    static CANEncodable encoderClimbLegsMaster = sparkMaxClimbLegsMaster.getEncodable("encoderClimbLegsMaster");

    static CANSparkMaxControllable sparkMaxClimbLegsSlave = DevCANSparkMax.getNew("sparkMaxClimbLegsSlave", 2, MotorType.kBrushless);
    static CANPIDControllable pidClimbLegsSlave = sparkMaxClimbLegsSlave.getPIDControllable("pidClimbLegsSlave");
    static CANEncodable encoderClimbLegsSlave = sparkMaxClimbLegsSlave.getEncodable("encoderClimbLegsSlave");

    static CANSparkMaxControllable sparkMaxDiffWheelFrontLeft = DevCANSparkMax.getNew("sparkMaxDiffWheelFrontLeft", 58, MotorType.kBrushless);
    static CANSparkMaxControllable sparkMaxDiffWheelFrontRight = DevCANSparkMax.getNew("sparkMaxDiffWheelFrontRight", 59, MotorType.kBrushless);
    static CANSparkMaxControllable sparkMaxDiffWheelRearLeft = DevCANSparkMax.getNew("sparkMaxDiffWheelRearLeft", 57, MotorType.kBrushless);
    static CANSparkMaxControllable sparkMaxDiffWheelRearRight = DevCANSparkMax.getNew("sparkMaxDiffWheelRearRight", 60, MotorType.kBrushless);

    // Pneumatics
    static DevCompressor compressorRollerArm = new DevCompressor("compressorRollerArm", 0);
    static DevSolenoid solenoidRollerArm = new DevSolenoid("solenoidRollerArm", 3);

    // Relays
    static DevRelay relayLighter = new DevRelay("relayLighter", 1);

    // TalonFX
    static DevTalonFX talonFxDiffWheelFrontLeft = new DevTalonFX("talonFxDiffWheelFrontLeft", 95);
    static DevTalonFX talonFxDiffWheelFrontRight = new DevTalonFX("talonFxDiffWheelFrontRight", 96);
    static DevTalonFX talonFxDiffWheelRearLeft = new DevTalonFX("talonFxDiffWheelRearLeft", 97);
    static DevTalonFX talonFxDiffWheelRearRight = new DevTalonFX("talonFxDiffWheelRearRight", 98);

    // TalonSRX
    static DevTalonSRX talonSrxClimbBalancer = new DevTalonSRX("talonSrxClimbBalancer", 12);
    static DevTalonSRX talonSrxClimbHook = new DevTalonSRX("talonSrxClimbHook", 14);
    static DevTalonSRX talonSrxClimbLegsA = new DevTalonSRX("talonSrxClimbLegsA", 4);
    static DevTalonSRX talonSrxClimbLegsB = new DevTalonSRX("talonSrxClimbLegsB", 13);

    static DevTalonSRX talonSrxConveyor = new DevTalonSRX("talonSrxConveyor", 10);
    static DevTalonSRX talonSrxRoller = new DevTalonSRX("talonSrxRoller", 99);

    static DevTalonSRX talonSrxShooterBottomWheel = new DevTalonSRX("talonSrxShooterBottomWheel", 98);
    static DevTalonSRX talonSrxShooterTopWheel = new DevTalonSRX("talonSrxShooterTopWheel", 9);

    /////////////////////
    // Drive Instances //
    /////////////////////

    public static DevDifferentialDrive diffDriveTalon = new DevDifferentialDrive("diffDriveTalon",
                                                                                talonFxDiffWheelFrontLeft,
                                                                                talonFxDiffWheelFrontRight);
    public static DevDifferentialDrive diffDriveSpark = new DevDifferentialDrive("diffDriveSpark",
                                                                                sparkMaxDiffWheelFrontLeft,
                                                                                sparkMaxDiffWheelFrontRight);

}

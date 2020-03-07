
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
    static CANSparkMaxControllable sparkMaxClimbLegsMaster = CANSparkMaxControllable.getNew("sparkMaxClimbLegsMaster", 1, MotorType.kBrushless);
    static CANPIDControllable pidClimbLegsMaster = sparkMaxClimbLegsMaster.getPIDControllable("pidClimbLegsMaster");
    static CANEncodable encoderClimbLegsMaster = sparkMaxClimbLegsMaster.getEncodable("encoderClimbLegsMaster");

    static CANSparkMaxControllable sparkMaxClimbLegsSlave = CANSparkMaxControllable.getNew("sparkMaxClimbLegsSlave", 2, MotorType.kBrushless);
    static CANPIDControllable pidClimbLegsSlave = sparkMaxClimbLegsSlave.getPIDControllable("pidClimbLegsSlave");
    static CANEncodable encoderClimbLegsSlave = sparkMaxClimbLegsSlave.getEncodable("encoderClimbLegsSlave");

    static CANSparkMaxControllable sparkMaxDiffWheelFrontLeft = CANSparkMaxControllable.getNew("sparkMaxDiffWheelFrontLeft", 58, MotorType.kBrushless);
    static CANSparkMaxControllable sparkMaxDiffWheelFrontRight = CANSparkMaxControllable.getNew("sparkMaxDiffWheelFrontRight", 59, MotorType.kBrushless);
    static CANSparkMaxControllable sparkMaxDiffWheelRearLeft = CANSparkMaxControllable.getNew("sparkMaxDiffWheelRearLeft", 57, MotorType.kBrushless);
    static CANSparkMaxControllable sparkMaxDiffWheelRearRight = CANSparkMaxControllable.getNew("sparkMaxDiffWheelRearRight", 60, MotorType.kBrushless);

    // Pneumatics
    static DevCompressor compressorRollerArm = new DevCompressor("compressorRollerArm", 0);
    static DevSolenoid solenoidRollerArm = new DevSolenoid("solenoidRollerArm", 3);

    // Relays
    static DevRelay relayLighter = new DevRelay("relayLighter", 1);

    // TalonFX
    static DevTalonSRX talonFxDiffWheelFrontLeft = new DevTalonSRX("talonFxDiffWheelFrontLeft", 99);
    static DevTalonSRX talonFxDiffWheelFrontRight = new DevTalonSRX("talonFxDiffWheelFrontRight", 99);
    static DevTalonSRX talonFxDiffWheelRearLeft = new DevTalonSRX("talonFxDiffWheelRearLeft", 99);
    static DevTalonSRX talonFxDiffWheelRearRight = new DevTalonSRX("talonFxDiffWheelRearRight", 99);

    // TalonSRX
    static DevTalonSRX talonSrxClimbBalancer = new DevTalonSRX("talonSrxClimbBalancer", 99);
    static DevTalonSRX talonSrxClimbHook = new DevTalonSRX("talonSrxClimbHook", 99);
    static DevTalonSRX talonSrxClimbLegsA = new DevTalonSRX("talonSrxClimbLegsA", 99);
    static DevTalonSRX talonSrxClimbLegsB = new DevTalonSRX("talonSrxClimbLegsB", 99);

    static DevTalonSRX talonSrxConveyor = new DevTalonSRX("talonSrxConveyor", 99);
    static DevTalonSRX talonSrxRoller = new DevTalonSRX("talonSrxRoller", 3);

    static DevTalonSRX talonSrxShooterBottomWheel = new DevTalonSRX("talonSrxShooterBottomWheel", 99);
    static DevTalonSRX talonSrxShooterTopWheel = new DevTalonSRX("talonSrxShooterTopWheel", 99);

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

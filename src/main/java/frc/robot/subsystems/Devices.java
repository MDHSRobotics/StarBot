
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
    static DevCANSparkMax sparkMaxClimbLegsMaster = new DevCANSparkMax("sparkMaxClimbLegsMaster", 1, MotorType.kBrushless);
    static DevCANSparkMax sparkMaxClimbLegsSlave = new DevCANSparkMax("sparkMaxClimbLegsSlave", 2, MotorType.kBrushless);

    static DevCANSparkMax sparkMaxDiffWheelFrontLeft = new DevCANSparkMax("sparkMaxDiffWheelFrontLeft", 1,
            MotorType.kBrushless);
    static DevCANSparkMax sparkMaxDiffWheelFrontRight = new DevCANSparkMax("sparkMaxDiffWheelFrontRight", 1,
            MotorType.kBrushless);
    static DevCANSparkMax sparkMaxDiffWheelRearLeft = new DevCANSparkMax("sparkMaxDiffWheelRearLeft", 1,
            MotorType.kBrushless);
    static DevCANSparkMax sparkMaxDiffWheelRearRight = new DevCANSparkMax("sparkMaxDiffWheelRearRight", 1,
            MotorType.kBrushless);

    // Pneumatics
    static DevCompressor compressorRollerArm = new DevCompressor("compressorRollerArm", 0);
    static DevSolenoid solenoidRollerArm = new DevSolenoid("solenoidRollerArm", 3);

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

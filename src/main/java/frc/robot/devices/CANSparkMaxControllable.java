
package frc.robot.devices;

import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANAnalog;
import com.revrobotics.CANAnalog.AnalogMode;
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.ExternalFollower;
import com.revrobotics.CANSparkMax.FaultID;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMax.SoftLimitDirection;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMaxLowLevel.PeriodicFrame;
import com.revrobotics.EncoderType;
import edu.wpi.first.hal.CANData;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.SpeedController;

import frc.robot.consoles.Logger;

import static frc.robot.RobotManager.isSim;

public interface CANSparkMaxControllable extends AutoCloseable, SpeedController {

    public static CANSparkMaxControllable getNew(String devName, int deviceId, MotorType motorType) {
        boolean isConnected = isConnected(deviceId);
        if (isConnected) {
            return new DevCANSparkMax(deviceId, motorType);
        }
        return new VirtualCANSparkMax(devName, deviceId, motorType);
    }

    // Determines if the given deviceId is connected
    private static boolean isConnected(int deviceId) {
        if (isSim) return false;

        // We can't create a CANSparkMax object when it's not physically connected,
        // because as soon as we do, it overloads CAN and kills the RoboRio.
        // So we have to make our own CAN object to test with.

        // TODO: This needs to be tested with a SparkMax connected.

        // https://docs.wpilib.org/en/latest/docs/software/can-devices/can-addressing.html
        int deviceManufacturer = 5; // RevRobotics
        int deviceType = 2; // Motor Controller
        CAN testCAN = new CAN(deviceId, deviceManufacturer, deviceType);
        int apiId = 0;
        CANData data = new CANData();
        boolean result = testCAN.readPacketNew(apiId, data);
        testCAN.close();
        return result;
    }

    /////////////////////////////
    // CANSparkMaxControllable //
    /////////////////////////////

    CANPIDControllable getPIDControllable(String devName);

    CANEncodable getEncodable(String devName);

    CANError follow(final CANSparkMaxControllable leader);

    /////////////////
    // CANSparkMax //
    /////////////////

    CANEncoder getEncoder();

    CANEncoder getEncoder(EncoderType sensorType, int counts_per_rev);

    CANEncoder getAlternateEncoder();

    CANEncoder getAlternateEncoder(AlternateEncoderType sensorType, int counts_per_rev);

    CANAnalog getAnalog(AnalogMode mode);

    CANPIDController getPIDController();

    CANDigitalInput getForwardLimitSwitch(CANDigitalInput.LimitSwitchPolarity polarity);

    CANDigitalInput getReverseLimitSwitch(CANDigitalInput.LimitSwitchPolarity polarity);

    CANError setSmartCurrentLimit(int limit);

    CANError setSmartCurrentLimit(int stallLimit, int freeLimit);

    CANError setSmartCurrentLimit(int stallLimit, int freeLimit, int limitRPM);

    CANError setSecondaryCurrentLimit(double limit);

    CANError setSecondaryCurrentLimit(double limit, int chopCycles);

    CANError setIdleMode(IdleMode mode);

    IdleMode getIdleMode();

    CANError enableVoltageCompensation(double nominalVoltage);

    CANError disableVoltageCompensation();

    double getVoltageCompensationNominalVoltage();

    CANError setOpenLoopRampRate(double rate);

    CANError setClosedLoopRampRate(double rate);

    double getOpenLoopRampRate();

    double getClosedLoopRampRate();

    CANError follow(final CANSparkMax leader);

    CANError follow(final CANSparkMax leader, boolean invert);

    CANError follow(ExternalFollower leader, int deviceID);

    CANError follow(ExternalFollower leader, int deviceID, boolean invert);

    boolean isFollower();

    short getFaults();

    short getStickyFaults();

    boolean getFault(FaultID faultID);

    boolean getStickyFault(FaultID faultID);

    double getBusVoltage();

    double getAppliedOutput();

    double getOutputCurrent();

    double getMotorTemperature();

    CANError clearFaults();

    CANError burnFlash();

    CANError setCANTimeout(int milliseconds);

    CANError enableSoftLimit(SoftLimitDirection direction, boolean enable);

    CANError setSoftLimit(SoftLimitDirection direction, float limit);

    double getSoftLimit(SoftLimitDirection direction);

    boolean isSoftLimitEnabled(SoftLimitDirection direction);

    CANError getLastError();

    /////////////////////////
    // CANSparkMaxLowLevel //
    /////////////////////////

    int getFirmwareVersion();

    void setControlFramePeriodMs(int periodMs);

    String getFirmwareString();

    byte[] getSerialNumber();

    int getDeviceId();

    MotorType getInitialMotorType();

    CANError setMotorType(MotorType type);

    MotorType getMotorType();

    CANError setPeriodicFramePeriod(PeriodicFrame frameID, int periodMs);

    float getSafeFloat(float f);

    CANError restoreFactoryDefaults();

    CANError restoreFactoryDefaults(boolean persist);

}

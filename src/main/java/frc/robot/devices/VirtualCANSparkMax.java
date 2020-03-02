
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
import com.revrobotics.ControlType;
import com.revrobotics.EncoderType;

public class VirtualCANSparkMax implements CANSparkMaxControllable {

    private String m_devName;
    private String m_devDescription;
    private Monitor m_monitor;

    private int m_deviceID;

    public VirtualCANSparkMax(String devName, int deviceId, MotorType motorType) {
        m_devName = devName;
        m_devDescription = String.format("VirtualCANSparkMax #%d", deviceId);
        m_monitor = new Monitor(m_devName, m_devDescription);

        m_deviceID = deviceId;
    }

    /////////////////////////////
    // CANSparkMaxControllable //
    /////////////////////////////

    public CANPIDControllable getPIDControllable(String devName) {
        return new VirtualCANPIDController(devName, this);
    }

    public CANEncodable getEncodable(String devName) {
        return new VirtualCANEncoder(devName, this);
    }

    public CANError follow(final CANSparkMaxControllable leader) {
        return CANError.kOk;
    }

    //////////////////
    // AutoClosable //
    //////////////////

    public void close() {
    }

    /////////////////////
    // SpeedController //
    /////////////////////

    public void set(double speed) {
        setpointCommand(speed, ControlType.kDutyCycle);
    }

    public void setVoltage(double outputVolts) {
        setpointCommand(outputVolts, ControlType.kVoltage);
    }

    public double get() {
        return getAppliedOutput();
    }

    public void setInverted(boolean isInverted) {
    }

    public boolean getInverted() {
        return false;
    }

    public void disable() {
        set(0);
    }

    public void stopMotor() {
        set(0);
    }

    public void pidWrite(double output) {
        set(output);
    }

    /////////////////
    // CANSparkMax //
    /////////////////

    public CANEncoder getEncoder() {
        return getEncoder(EncoderType.kHallSensor, 0);
    }

    public CANEncoder getEncoder(EncoderType sensorType, int counts_per_rev) {
        return null;
    }

    public CANEncoder getAlternateEncoder() {
        return null;
    }

    public CANEncoder getAlternateEncoder(AlternateEncoderType sensorType, int counts_per_rev) {
        return null;
    }

    public CANAnalog getAnalog(AnalogMode mode) {
        return null;
    }

    public CANPIDController getPIDController() {
        return null;
    }

    public CANDigitalInput getForwardLimitSwitch(CANDigitalInput.LimitSwitchPolarity polarity) {
        return null;
    }

    public CANDigitalInput getReverseLimitSwitch(CANDigitalInput.LimitSwitchPolarity polarity) {
        return null;
    }

    public CANError setSmartCurrentLimit(int limit) {
        return setSmartCurrentLimit(limit, 0, 20000);
    }

    public CANError setSmartCurrentLimit(int stallLimit, int freeLimit) {
        return setSmartCurrentLimit(stallLimit, freeLimit, 20000);
    }

    public CANError setSmartCurrentLimit(int stallLimit, int freeLimit, int limitRPM) {
        return CANError.kOk;
    }

    public CANError setSecondaryCurrentLimit(double limit) {
        return CANError.kOk;
    }

    public CANError setSecondaryCurrentLimit(double limit, int chopCycles) {
        return CANError.kOk;
    }

    public CANError setIdleMode(IdleMode mode) {
        return CANError.kOk;
    }

    public IdleMode getIdleMode() {
        return IdleMode.kCoast;
    }

    public CANError enableVoltageCompensation(double nominalVoltage) {
        return CANError.kOk;
    }

    public CANError disableVoltageCompensation() {
        return CANError.kOk;
    }

    public double getVoltageCompensationNominalVoltage() {
        return 0.0;
    }

    public CANError setOpenLoopRampRate(double rate) {
        return CANError.kOk;
    }

    public CANError setClosedLoopRampRate(double rate) {
        return CANError.kOk;
    }

    public double getOpenLoopRampRate() {
        return 0.0;
    }

    public double getClosedLoopRampRate() {
        return 0.0;
    }

    public CANError follow(final CANSparkMax leader) {
        return follow(leader, false);
    }

    public CANError follow(final CANSparkMax leader, boolean invert) {
        return follow(ExternalFollower.kFollowerSparkMax, leader.getDeviceId(), invert);
    }

    public CANError follow(ExternalFollower leader, int deviceID) {
        boolean inverted = getInverted();
        return follow(leader, deviceID, inverted);
    }

    public CANError follow(ExternalFollower leader, int deviceID, boolean invert) {
        return CANError.kOk;
    }

    public boolean isFollower() {
        return false;
    }

    public short getFaults() {
        return 0;
    }

    public short getStickyFaults() {
        return 0;
    }

    public boolean getFault(FaultID faultID) {
        return false;
    }

    public boolean getStickyFault(FaultID faultID) {
        return false;
    }

    public double getBusVoltage() {
        return 0.0;
    }

    public double getAppliedOutput() {
        return 0.0;
    }

    public double getOutputCurrent() {
        return 0.0;
    }

    public double getMotorTemperature() {
        return 0.0;
    }

    public CANError clearFaults() {
        return CANError.kOk;
    }

    public CANError burnFlash() {
        return CANError.kOk;
    }

    public CANError setCANTimeout(int milliseconds) {
        return CANError.kOk;
    }

    public CANError enableSoftLimit(SoftLimitDirection direction, boolean enable) {
        return CANError.kOk;
    }

    public CANError setSoftLimit(SoftLimitDirection direction, float limit) {
        return CANError.kOk;
    }

    public double getSoftLimit(SoftLimitDirection direction) {
        return 0.0;
    }

    public boolean isSoftLimitEnabled(SoftLimitDirection direction) {
        return false;
    }

    protected int getFeedbackDeviceID() {
        return 0;
    }

    public CANError getLastError() {
        return CANError.kOk;
    }

    ///////////////
    // Low Level //
    ///////////////

    public int getFirmwareVersion() {
        return -1;
    }

    public void setControlFramePeriodMs(int periodMs) {
    }

    public String getFirmwareString() {
        return "";
    }

    public byte[] getSerialNumber() {
        return new byte[0];
    }

    public int getDeviceId() {
        return m_deviceID;
    }

    public MotorType getInitialMotorType() {
        return MotorType.kBrushless;
    }

    public CANError setMotorType(MotorType type) {
        return CANError.kOk;
    }

    public MotorType getMotorType() {
        return MotorType.kBrushless;
    }

    public CANError setPeriodicFramePeriod(PeriodicFrame frameID, int periodMs) {
        return CANError.kOk;
    }

    public static void enableExternalUSBControl(boolean enable) {
    }

    static void setEnable(boolean enable) {
    }

    CANError setpointCommand(double value) {
        return setpointCommand(value, ControlType.kDutyCycle);
    }

    CANError setpointCommand(double value, ControlType ctrl) {
        return setpointCommand(value, ctrl, 0);
    }

    CANError setpointCommand(double value, ControlType ctrl, int pidSlot) {
        return setpointCommand(value, ctrl, pidSlot, 0);
    }

    CANError setpointCommand(double value, ControlType ctrl, int pidSlot, double arbFeedforward) {
        return setpointCommand(value, ctrl, pidSlot, arbFeedforward, 0);
    }

    CANError setpointCommand(double value, ControlType ctrl, int pidSlot, double arbFeedforward, int arbFFUnits) {
        return CANError.kOk;
    }

    public float getSafeFloat(float f) {
        if (Float.isNaN(f) || Float.isInfinite(f))
            return 0;

        return f;
    }

    public CANError restoreFactoryDefaults() {
        return restoreFactoryDefaults(false);
    }

    public CANError restoreFactoryDefaults(boolean persist) {
        return CANError.kOk;
    }

}

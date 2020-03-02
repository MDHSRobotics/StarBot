
package frc.robot.devices;

import com.revrobotics.CANError;
import com.revrobotics.CANPIDController.AccelStrategy;
import com.revrobotics.CANPIDController.ArbFFUnits;
import com.revrobotics.ControlType;

public class VirtualCANPIDController implements CANPIDControllable {

    private String m_devName;
    private String m_devDescription;
    private Monitor m_monitor;

    private final CANSparkMaxControllable m_device;

    public VirtualCANPIDController(String devName, CANSparkMaxControllable device) {
        m_devName = devName;
        m_devDescription = String.format("VirtualCANPIDController #%d", device.getDeviceId());
        m_monitor = new Monitor(m_devName, m_devDescription);

        m_device = device;
    }

    public CANError setReference(double value, ControlType ctrl) {
        return setReference(value, ctrl, 0);
    }

    public CANError setReference(double value, ControlType ctrl, int pidSlot) {
        return setReference(value, ctrl, pidSlot, 0);
    }

    public CANError setReference(double value, ControlType ctrl, int pidSlot, double arbFeedforward) {
        return CANError.kOk;
    }

    public CANError setReference(double value, ControlType ctrl, int pidSlot, double arbFeedforward, ArbFFUnits arbFFUnits) {
        return CANError.kOk;
    }

    public CANError setP(double gain) {
        return setP(gain, 0);
    }

    public CANError setP(double gain, int slotID) {
        return CANError.kOk;
    }

    public CANError setI(double gain) {
        return setI(gain, 0);
    }

    public CANError setI(double gain, int slotID) {
        return CANError.kOk;
    }

    public CANError setD(double gain) {
        return setD(gain, 0);
    }

    public CANError setD(double gain, int slotID) {
        return CANError.kOk;
    }

    public CANError setDFilter(double gain) {
        return setDFilter(gain, 0);
    }

    public CANError setDFilter(double gain, int slotID) {
        return CANError.kOk;
    }

    public CANError setFF(double gain) {
        return setFF(gain, 0);
    }

    public CANError setFF(double gain, int slotID) {
        return CANError.kOk;
    }

    public CANError setIZone(double IZone) {
        return setIZone(IZone, 0);
    }

    public CANError setIZone(double IZone, int slotID) {
        return CANError.kOk;
    }

    public CANError setOutputRange(double min, double max) {
        return setOutputRange(min, max, 0);
    }

    public CANError setOutputRange(double min, double max, int slotID) {
        return CANError.kOk;
    }

    public double getP() {
        return getP(0);
    }

    public double getP(int slotID) {
        return 0.0;
    }

    public double getI() {
        return getI(0);
    }

    public double getI(int slotID) {
        return 0.0;
    }

    public double getD() {
        return getD(0);
    }

    public double getD(int slotID) {
        return 0.0;
    }

    public double getDFilter(int slotID) {
        return 0.0;
    }

    public double getFF() {
        return getFF(0);
    }

    public double getFF(int slotID) {
        return 0.0;
    }

    public double getIZone() {
        return getIZone(0);
    }

    public double getIZone(int slotID) {
        return 0.0;
    }

    public double getOutputMin() {
        return getOutputMin(0);
    }

    public double getOutputMin(int slotID) {
        return 0.0;
    }

    public double getOutputMax() {
        return getOutputMax(0);
    }

    public double getOutputMax(int slotID) {
        return 0.0;
    }

    public CANError setSmartMotionMaxVelocity(double maxVel, int slotID) {
        return CANError.kOk;
    }

    public CANError setSmartMotionMaxAccel(double maxAccel, int slotID) {
        return CANError.kOk;
    }

    public CANError setSmartMotionMinOutputVelocity(double minVel, int slotID) {
        return CANError.kOk;
    }

    public CANError setSmartMotionAllowedClosedLoopError(double allowedErr, int slotID) {
        return CANError.kOk;
    }

    public CANError setSmartMotionAccelStrategy(AccelStrategy accelStrategy, int slotID) {
        return CANError.kOk;
    }

    public double getSmartMotionMaxVelocity(int slotID) {
        return 0.0;
    }

    public double getSmartMotionMaxAccel(int slotID) {
        return 0.0;
    }

    public double getSmartMotionMinOutputVelocity(int slotID) {
        return 0.0;
    }

    public double getSmartMotionAllowedClosedLoopError(int slotID) {
        return 0.0;
    }

    public AccelStrategy getSmartMotionAccelStrategy(int slotID) {
        return AccelStrategy.kTrapezoidal;
    }

    public CANError setIMaxAccum(double iMaxAccum, int slotID) {
        return CANError.kOk;
    }

    public double getIMaxAccum(int slotID) {
        return 0.0;
    }

    public CANError setIAccum(double iAccum) {
        return CANError.kOk;
    }

    public double getIAccum() {
        return 0.0;
    }

}

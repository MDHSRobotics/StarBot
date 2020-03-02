
package frc.robot.devices;

import com.revrobotics.CANError;

import static frc.robot.RobotManager.isSim;

public class VirtualCANEncoder implements CANEncodable {

    private String m_devName;
    private String m_devDescription;
    private Monitor m_monitor;

    private final CANSparkMaxControllable m_device;

    public VirtualCANEncoder(String devName, CANSparkMaxControllable device) {
        m_devName = devName;
        m_devDescription = String.format("VirtualCANEncoder #%d", device.getDeviceId());

        if (isSim) {
            m_monitor = new Monitor(m_devName, m_devDescription);
        }

        m_device = device;
    }

    public double getPosition() {
        return 0.0;
    }

    public double getVelocity() {
        return 0.0;
    }

    public CANError setPosition(double position) {
        return CANError.kOk;
    }

    public CANError setPositionConversionFactor(double factor) {
        return CANError.kOk;
    }

    public CANError setVelocityConversionFactor(double factor) {
        return CANError.kOk;
    }

    public double getPositionConversionFactor() {
        return 0.0;
    }

    public double getVelocityConversionFactor() {
        return 0.0;
    }

    public CANError setAverageDepth(int depth) {
        return CANError.kOk;
    }

    public int getAverageDepth() {
        return 0;
    }

    public CANError setMeasurementPeriod(int period_us) {
        return CANError.kOk;
    }

    public int getMeasurementPeriod() {
        return 0;
    }

    public int getCPR() {
        return getCountsPerRevolution();
    }

    public int getCountsPerRevolution() {
        return 0;
    }

    public CANError setInverted(boolean inverted) {
        return CANError.kOk;
    }

    public boolean getInverted() {
        return false;
    }

}

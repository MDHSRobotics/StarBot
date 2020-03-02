
package frc.robot.devices;

import com.revrobotics.CANError;
import com.revrobotics.CANSparkMax;

import static frc.robot.RobotManager.isSim;

// This class is a wrapper around CANSparkMax in order to handle cases where the
// SparkMax controller and associated motor are not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the SparkMax is connected then this class just forwards any calls directly
// to the CANSparkMax class.

// If the SparkMax is not connected, only a subset of the CANSparkMax interface is
// supported, mainly by tracing and other monitoring.

public class DevCANSparkMax extends CANSparkMax implements CANSparkMaxControllable {

    private String m_devName;
    private String m_devDescription;
    private Monitor m_monitor;
    public boolean isConnected = true;

    public static CANSparkMaxControllable getNew(String devName, int deviceNumber, MotorType motorType) {
        // DevCANSparkMax device = new DevCANSparkMax(devName, deviceNumber, motorType);
        // if (device.isConnected) return device;
        return new VirtualCANSparkMax(devName, deviceNumber, motorType);
    }

    public DevCANSparkMax(String devName, int deviceId, MotorType motorType) {
        super(deviceId, motorType);

        m_devName = devName;
        m_devDescription = String.format("CANSparkMax #%d", deviceId);

        isConnected = isConnected();
        if (!isConnected) {
            m_monitor = new Monitor(m_devName, m_devDescription);
        }

        if (isConnected) {
            restoreFactoryDefaults();
        }
    }

    // Determines if this is connected
    private boolean isConnected() {
        if (isSim) return false;

        int firmVer = this.getFirmwareVersion();
        return (firmVer != -1);
    }

    /////////////////////////////
    // CANSparkMaxControllable //
    /////////////////////////////

    public CANPIDControllable getPIDControllable(String devName) {
        if (isConnected) {
            return new DevCANPIDController(devName, this);
        }

        VirtualCANPIDController pidController = new VirtualCANPIDController(devName, this);
        return pidController;
    }

    public CANEncodable getEncodable(String devName) {
        if (isConnected) {
            return new DevCANEncoder(devName, this);
        }

        VirtualCANEncoder encoder = new VirtualCANEncoder(devName, this);
        return encoder;
    }

    public CANError follow(final CANSparkMaxControllable leader) {
        if (isConnected) {
            return super.follow((DevCANSparkMax) leader, false);
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = leader.toString();
        m_monitor.log(methodName, arg);
        return CANError.kOk;
    }

    /////////////////////
    // SpeedController //
    /////////////////////

    public void set(double power){
        if (isConnected) {
            super.set(power);
            return;
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.format("%.3f", power);
        m_monitor.log(methodName, arg);
    }

    public void stopMotor() {
        if (isConnected) {
            super.stopMotor();
            return;
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        m_monitor.log(methodName);
    }

}

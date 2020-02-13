
package frc.robot.devices;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import static frc.robot.RobotManager.isReal;
import static frc.robot.RobotManager.isSim;

// This class is a wrapper around CANSparkMax in order to handle cases where the
// Talon controller and associated motor are not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the Talon is connected then this class just forwards any calls directly
// to the CANSparkMax class.

// If the Talon is not connected, only a subset of the CANSparkMax interface is
// supported, mainly by tracing and other monitoring.

public class DevCANSparkMax extends CANSparkMax {

    private String m_logicalID;
    private String m_physicalID;
    private SimulationMonitor m_simMonitor;
    public boolean isConnected = false;

    public DevCANSparkMax(String logicalDeviceID, int deviceNumber, MotorType motorType) {
        super(deviceNumber, motorType);

        m_logicalID = logicalDeviceID;
        m_physicalID = String.format("CANSparkMax #%d", deviceNumber);

        if (isSim) {
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }

        isConnected = isConnected();
        if (isReal && isConnected) {
            restoreFactoryDefaults();
        }
    }

    // Determines if this is connected
    private boolean isConnected() {
        if (isSim) return true;
        return true;
    }

    public DevCANPIDController getPIDController() {
        if (isReal) {
            return (DevCANPIDController)super.getPIDController();
        }

        String pidControllerName = String.format("PID Controller for %s", m_logicalID);
        DevCANPIDController pidController = new DevCANPIDController(pidControllerName, this);
        return pidController;
    }

    public CANEncoder getEncoder() {
        if (isReal) {
            return (DevSparkEncoder)super.getEncoder();
        }

        String encoderName = String.format("Encoder for %s", m_logicalID);
        DevSparkEncoder encoder = new DevSparkEncoder(encoderName, this);
        return encoder;
    }

    public void set(double power){
        if (isReal) {
            if (isConnected) super.set(power);
            return;
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.format("%.3f", power);
        m_simMonitor.log(methodName, arg);
    }

    public void stopMotor() {
        if (isReal) {
            if (isConnected) super.stopMotor();
            return;
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        m_simMonitor.log(methodName);
    }

}

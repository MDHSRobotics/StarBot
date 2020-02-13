
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

import frc.robot.consoles.Logger;

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

public class SimCANSparkMax extends CANSparkMax {

    private String m_logicalID;
    private String m_physicalID;

    private int m_deviceNumber;

    private SimulationMonitor m_simMonitor;

    public SimCANSparkMax(String logicalDeviceID, int deviceNumber, MotorType motorType) {
        super(deviceNumber, motorType);

        m_logicalID = logicalDeviceID;

        m_deviceNumber = deviceNumber;

        if (isSim) {
            m_physicalID = String.format("CANSparkMax #%d", deviceNumber);
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }
    }

    public int getID() {
        return m_deviceNumber;
    }

    // Determines if this is connected
    public boolean isConnected() {
        if (isSim) return true;

        // TODO: Figure out how to check for connectedness of CANSparkMax
        Logger.warning("Missing technique for testing whether CANSparkMax is connected");
        return true;
    }

    public SimCANPIDController getPIDController() {
        if (isReal) return (SimCANPIDController)super.getPIDController();

        String pidControllerName = String.format("PID Controller for %s", m_logicalID);
        SimCANPIDController pidController = new SimCANPIDController(pidControllerName, this);
        return pidController;
    }

    public CANEncoder getEncoder() {
        if (isReal) return (SimSparkEncoder)super.getEncoder();

        String encoderName = String.format("Encoder for %s", m_logicalID);
        SimSparkEncoder encoder = new SimSparkEncoder(encoderName, this);
        return encoder;
    }

    public void set(double power){
        if (isReal) super.set(power);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.format("%.3f", power);
        m_simMonitor.log(methodName, arg);
    }

    public void stopMotor() {
        if (isReal) super.stopMotor();

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        m_simMonitor.log(methodName);
    }

}

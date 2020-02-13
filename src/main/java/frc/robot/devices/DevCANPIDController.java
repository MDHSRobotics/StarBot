
package frc.robot.devices;

import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import static frc.robot.RobotManager.isReal;
import static frc.robot.RobotManager.isSim;

// This class is a wrapper around CANPIDController in order to handle cases where the
// CANPIDController is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the CANPIDController is connected then this class just forwards any calls directly
// to the CANPIDController class.

// If the CANPIDController is not connected, only a subset of the CANPIDController interface is
// supported, mainly by tracing and other monitoring.

public class DevCANPIDController extends CANPIDController {

    private String m_logicalID;
    private String m_physicalID;
    private SimulationMonitor m_simMonitor;
    public boolean isConnected = false;

    public DevCANPIDController(String logicalDeviceID, DevCANSparkMax sparkDevice) {
        super(sparkDevice);

        m_logicalID = logicalDeviceID;
        m_physicalID = String.format("CANPIDController sparkDevice");

        if (isSim) {
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }

        isConnected = isConnected();
    }

    // Determines if this is connected
    private boolean isConnected() {
        if (isSim) return true;
        return true;
    }

    public CANError setReference(double value, ControlType ctrl) {
        if (isReal) {
            if (isConnected) return super.setReference(value, ctrl);
            return CANError.kOk;
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg1 = String.format("%.2f", value);
        String arg2 = ctrl.name();
        m_simMonitor.log(methodName, arg1, arg2);
        return CANError.kOk;
    }

}


package frc.robot.subsystems;

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

public class SimCANPIDController extends CANPIDController {

    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimCANPIDController(String logicalDeviceID, SimCANSparkMax sparkDevice) {
        super(sparkDevice);

        m_logicalID = logicalDeviceID;

        if (isSim) {
            m_physicalID = String.format("CANPIDController sparkDevice");
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }
    }

    public CANError setReference(double value, ControlType ctrl) {
        if (isReal) return super.setReference(value, ctrl);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg1 = String.format("%.2f", value);
        String arg2 = ctrl.name();
        m_simMonitor.log(methodName, arg1, arg2);
        return CANError.kOk;
    }

}

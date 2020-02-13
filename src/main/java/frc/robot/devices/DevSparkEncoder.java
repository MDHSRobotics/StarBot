package frc.robot.devices;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;

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

public class DevSparkEncoder extends CANEncoder {

    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public DevSparkEncoder(String logicalDeviceID, DevCANSparkMax sparkDevice) {
        super(sparkDevice);

        m_logicalID = logicalDeviceID;

        if (isSim) {
            m_physicalID = String.format("CANEncoder sparkDevice");
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }
    }

    public CANError setPosition(double position){
        if (isReal) return super.setPosition(position);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.format("%.2f", position);
        m_simMonitor.log(methodName, arg);
        return CANError.kOk;
    }

}

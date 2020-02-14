package frc.robot.devices;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;
import com.revrobotics.EncoderType;

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

public class DevCANSparkMaxEncoder extends CANEncoder {

    private String m_logicalID;
    private String m_physicalID;
    private SimulationMonitor m_simMonitor;
    public boolean isConnected = false;

    public DevCANSparkMaxEncoder(String logicalDeviceID, DevCANSparkMax sparkDevice) {
        super(sparkDevice, EncoderType.kHallSensor, 0);

        m_logicalID = logicalDeviceID;
        m_physicalID = String.format("CANSparkMaxEncoder");

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

    public CANError setPosition(double position){
        if (isReal) {
            if (isConnected) return super.setPosition(position);
            return CANError.kOk;
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.format("%.2f", position);
        m_simMonitor.log(methodName, arg);
        return CANError.kOk;
    }

}

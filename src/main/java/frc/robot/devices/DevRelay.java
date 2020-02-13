package frc.robot.devices;

import edu.wpi.first.wpilibj.Relay;

import static frc.robot.RobotManager.isReal;
import static frc.robot.RobotManager.isSim;

// This class is a wrapper around Relay in order to handle cases where the
// Relay is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the Relay is connected then this class just forwards any calls directly
// to the Relay class.

// If the Relay is not connected, only a subset of the Relay interface is
// supported, mainly by tracing and other monitoring.

public class DevRelay extends Relay {

    private String m_logicalID;
    private String m_physicalID;
    private SimulationMonitor m_simMonitor;
    public boolean isConnected = false;

    public DevRelay(String logicalDeviceID, int channel) {
        super(channel);

        m_logicalID = logicalDeviceID;
        m_physicalID = String.format("Relay channel #%d", channel);

        if (isSim) {
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
            set(Value.kOff); // The super constructor calls set(Value.kOff)
        }

        isConnected = isConnected();
    }

    // Determines if this is connected
    private boolean isConnected() {
        if (isSim) return true;
        return true;
    }

    public void set(Value value){
        if (isReal) {
            if (isConnected) super.set(value);
            return;
        }

        if (m_simMonitor == null) return; // The super constructor calls set(Value.kOff)
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = value.toString();
        m_simMonitor.log(methodName, arg);
    }

}

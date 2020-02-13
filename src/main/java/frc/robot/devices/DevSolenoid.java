package frc.robot.devices;

import edu.wpi.first.wpilibj.Solenoid;

import static frc.robot.RobotManager.isReal;
import static frc.robot.RobotManager.isSim;

// This class is a wrapper around Solenoid in order to handle cases where the
// Solenoid is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the Solenoid is connected then this class just forwards any calls directly
// to the Solenoid class.

// If the Solenoid is not connected, only a subset of the Solenoid interface is
// supported, mainly by tracing and other monitoring.

public class DevSolenoid extends Solenoid {

    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public DevSolenoid(String logicalDeviceID, int module) {
        super(module);

        m_logicalID = logicalDeviceID;

        if (isSim) {
            m_physicalID = String.format("Solenoid module #%d", module);
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }
    }

    // Determines if this is connected
    public boolean isConnected() {
        if (isSim) return true;

        boolean outputOn = this.get();
        return !outputOn;
    }

    public void set(boolean state) {
        if (isReal) super.set(state);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.valueOf(state);
        m_simMonitor.log(methodName, arg);
    }

}

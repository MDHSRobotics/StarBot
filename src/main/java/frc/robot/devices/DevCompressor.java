package frc.robot.devices;

import edu.wpi.first.wpilibj.Compressor;

import static frc.robot.RobotManager.isReal;
import static frc.robot.RobotManager.isSim;

// This class is a wrapper around Compressor in order to handle cases where the
// compressor is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the compressor is connected then this class just forwards any calls directly
// to the Compressor class.

// If the compressor is not connected, only a subset of the Compressor interface is
// supported, mainly by tracing and other monitoring.

public class DevCompressor extends Compressor {

    private String m_logicalID;
    private String m_physicalID;
    private SimulationMonitor m_simMonitor;
    public boolean isConnected = false;

    public DevCompressor(String logicalDeviceID, int module) {
        super(module);

        m_logicalID = logicalDeviceID;
        m_physicalID = String.format("Compressor module #%d", module);

        if (isSim) {
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }

        isConnected = isConnected();
    }

    // Determines if this is connected
    private boolean isConnected() {
        if (isSim) return true;
        return this.enabled();
    }

    public void setClosedLoopControl(boolean closedLoopState) {
        if (isReal) {
            if (isConnected) super.setClosedLoopControl(closedLoopState);
            return;
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.valueOf(closedLoopState);
        m_simMonitor.log(methodName, arg);
    }

    public double getCompressorCurrent() {
        if (isReal) {
            if (isConnected) return super.getCompressorCurrent();
            return -1;
        }

        return 9.99;
    }

}

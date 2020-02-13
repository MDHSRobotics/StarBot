package frc.robot.subsystems;

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

public class SimCompressor extends Compressor {

    private String m_logicalID;
    private String m_physicalID;

    private int m_module;

    private SimulationMonitor m_simMonitor;

    public SimCompressor(String logicalDeviceID, int module) {
        super(module);

        m_logicalID = logicalDeviceID;

        m_module = module;

        if (isSim) {
            m_physicalID = String.format("Compressor module #%d", m_module);
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }
    }

    // Determines if this is connected
    public boolean isConnected() {
        if (isSim) return true;
        return this.enabled();
    }

    public void setClosedLoopControl(boolean closedLoopState) {
        if (isReal) super.setClosedLoopControl(closedLoopState);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.valueOf(closedLoopState);
        m_simMonitor.log(methodName, arg);
    }

    public double getCompressorCurrent() {
        if (isReal) return super.getCompressorCurrent();
        return 9.99;
    }

}

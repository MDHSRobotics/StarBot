package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.consoles.Logger;

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

    private int m_module;
    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimCompressor(String logicalDeviceID, int module) {
        super(module);

        m_module = module;

        if (RobotBase.isSimulation()) {
            String physcialDeviceID = String.format("Compressor module #%d", module);
            m_simMonitor = new SimulationMonitor(physcialDeviceID, logicalDeviceID);
        }
    }

    // Determines if this is connected
    public boolean isConnected() {

        boolean connected;

        // Devices are not connected in Simulation mode
        if (RobotBase.isSimulation()) {
            connected = true;
        }
        else {
            connected = this.enabled();
        }
        return connected;
    }

    // Intercept setClosedLoopControl method if we are in Simulation; otherwise, just delegate it
    public void setClosedLoopControl(boolean closedLoopState) {

        if (RobotBase.isReal()) {
            super.setClosedLoopControl(closedLoopState);
        } else {
            String cmdStr = String.format("setClosedLoop(%b)", closedLoopState);
            m_simMonitor.logCommand(cmdStr);
        }
    }

    // Intercept getCompressorCurrent method if we are in Simulation; otherwise, just delegate it
    public double getCompressorCurrent() {

        if (RobotBase.isReal()) {
            return super.getCompressorCurrent();
        } else {
            return 9.99;
        }
    }
}
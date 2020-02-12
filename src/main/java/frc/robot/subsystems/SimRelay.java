package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.consoles.Logger;

// This class is a wrapper around Relay in order to handle cases where the
// Relay is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the Relay is connected then this class just forwards any calls directly
// to the Relay class.

// If the Relay is not connected, only a subset of the Relay interface is
// supported, mainly by tracing and other monitoring.

public class SimRelay extends Relay {

    private int m_channel;
    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimRelay(String logicalDeviceID, int channel) {
        super(channel);

        m_channel = channel;

        if (RobotBase.isSimulation()) {
            String physcialDeviceID = String.format("Relay channel #%d", channel);
            m_simMonitor = new SimulationMonitor(physcialDeviceID, logicalDeviceID);
        }
    }

    // Intercept set method if we are in Simulation; otherwise, just delegate it
    public void set(Value value){

        if (RobotBase.isReal()) {
            super.set(value);
        }
        else {
            String cmdStr = String.format("set(%s)", value.toString());
            if (m_simMonitor != null) m_simMonitor.logCommand(cmdStr);
        }
    }

}
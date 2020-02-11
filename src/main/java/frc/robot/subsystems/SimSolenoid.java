package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.consoles.Logger;

// This class is a wrapper around Solenoid in order to handle cases where the
// Solenoid is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the Solenoid is connected then this class just forwards any calls directly
// to the Solenoid class.

// If the Solenoid is not connected, only a subset of the Solenoid interface is
// supported, mainly by tracing and other monitoring.

public class SimSolenoid extends Solenoid {

    private int m_module;
        private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimSolenoid(String logicalDeviceID, int module) {
        super(module);

        m_module = module;

        if (RobotBase.isSimulation()) {
            String physcialDeviceID = String.format("Solenoid module #%d", module);
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
            boolean outputOn = this.get();
            connected = !outputOn;
        }
        return connected;
    }

    // Intercept set method if we are in Simulation; otherwise, just delegate it
    public void set(boolean state){

        if (RobotBase.isReal()) {
            super.set(state);
        }
        else {
            String cmdStr = String.format("set(%b)", state);
            m_simMonitor.logCommand(cmdStr);
        }
    }

}
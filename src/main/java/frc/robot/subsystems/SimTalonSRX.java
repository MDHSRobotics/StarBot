package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.consoles.Logger;

// This class is a wrapper around TalonSRX in order to handle cases where the
// Talon controller and associated motor are not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the Talon is connected then this class just forwards any calls directly
// to the TalonSRX class.

// If the Talon is not connected, only a subset of the TalonSRX interface is
// supported, mainly by tracing and other monitoring.

public class SimTalonSRX extends WPI_TalonSRX {

    private int m_deviceNumber;
    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimTalonSRX(String logicalDeviceID, int deviceNumber) {
        super(deviceNumber);

        m_deviceNumber = deviceNumber;

        if (RobotBase.isSimulation()) {
            String physcialDeviceID = String.format("TalonSRX #%d", deviceNumber);
            m_simMonitor = new SimulationMonitor(physcialDeviceID, logicalDeviceID);
        }
    }

    public int getID() {
        return m_deviceNumber;
    }

    // Determines if this is connected
    public boolean isConnected() {

        boolean connected;

        // Devices are not connected in Simulation mode
        if (RobotBase.isSimulation()) {
            connected = true;
        }
        else {
            int firmVer = this.getFirmwareVersion();
            connected = (firmVer != -1);
        }
        return connected;
    }

    // Intercept set method if we are in Simulation; otherwise, just delegate it
    public void set(double power){

        if (RobotBase.isReal()) {
            super.set(power);
        }
        else {
            String cmdStr = String.format("set(%.3f)", power);
            m_simMonitor.logCommand(cmdStr);
        }
    }

    // Intercept stopMotor method if we are in Simulation; otherwise, just delegate it
    public void stopMotor() {

        if (RobotBase.isReal()) {
            super.stopMotor();
        } else {
            String cmdStr = String.format("stopMotor()");
            m_simMonitor.logCommand(cmdStr);
        }
    }

}
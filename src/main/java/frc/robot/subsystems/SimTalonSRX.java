package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import static frc.robot.RobotManager.isReal;
import static frc.robot.RobotManager.isSim;

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

    private String m_logicalID;
    private String m_physicalID;

    private int m_deviceNumber;

    private SimulationMonitor m_simMonitor;

    public SimTalonSRX(String logicalDeviceID, int deviceNumber) {
        super(deviceNumber);

        m_logicalID = logicalDeviceID;

        m_deviceNumber = deviceNumber;

        if (isSim) {
            m_physicalID = String.format("TalonSRX #%d", deviceNumber);
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }
    }

    public int getID() {
        return m_deviceNumber;
    }

    // Determines if this is connected
    public boolean isConnected() {
        if (isSim) return true;

        int firmVer = this.getFirmwareVersion();
        return (firmVer != -1);
    }

    public void set(double power){
        if (isReal) super.set(power);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.format("%.3f", power);
        m_simMonitor.log(methodName, arg);
    }

    public void stopMotor() {
        if (isReal) super.stopMotor();

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        m_simMonitor.log(methodName);
    }

}

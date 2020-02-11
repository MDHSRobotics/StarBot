package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;

import edu.wpi.first.wpilibj.RobotBase;


// This class is a wrapper around CANPIDController in order to handle cases where the
// CANPIDController is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the CANPIDController is connected then this class just forwards any calls directly
// to the CANPIDController class.

// If the CANPIDController is not connected, only a subset of the CANPIDController interface is
// supported, mainly by tracing and other monitoring.

public class SimSparkEncoder extends CANEncoder {

    private SimCANSparkMax m_sparkDevice;
    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimSparkEncoder(String logicalDeviceID, SimCANSparkMax sparkDevice) {
        super(sparkDevice);

        m_sparkDevice = sparkDevice;

        if (RobotBase.isSimulation()) {
            String physcialDeviceID = String.format("CANEncoder sparkDevice");
            m_simMonitor = new SimulationMonitor(physcialDeviceID, logicalDeviceID);
        }
    }

    // Intercept set method if we are in Simulation; otherwise, just delegate it
    public CANError setPosition(double position){

        if (RobotBase.isReal()) {
            return super.setPosition(position);
        }
        else {
            String cmdStr = String.format("setPosition(%.2f)", position);
            m_simMonitor.logCommand(cmdStr);
            return CANError.kOk;
        }
    }

}
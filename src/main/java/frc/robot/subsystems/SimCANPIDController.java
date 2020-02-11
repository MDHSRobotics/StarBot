package frc.robot.subsystems;

import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.consoles.Logger;

// This class is a wrapper around CANPIDController in order to handle cases where the
// CANPIDController is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the CANPIDController is connected then this class just forwards any calls directly
// to the CANPIDController class.

// If the CANPIDController is not connected, only a subset of the CANPIDController interface is
// supported, mainly by tracing and other monitoring.

public class SimCANPIDController extends CANPIDController {

    private SimCANSparkMax m_sparkDevice;
    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimCANPIDController(String logicalDeviceID, SimCANSparkMax sparkDevice) {
        super(sparkDevice);

        m_sparkDevice = sparkDevice;

        if (RobotBase.isSimulation()) {
            String physcialDeviceID = String.format("CANPIDController sparkDevice");
            m_simMonitor = new SimulationMonitor(physcialDeviceID, logicalDeviceID);
        }
    }

    // Intercept set method if we are in Simulation; otherwise, just delegate it
    public CANError setReference(double value, ControlType ctrl){

        if (RobotBase.isReal()) {
            return super.setReference(value, ctrl);
        }
        else {
            String cmdStr = String.format("setReference(%.2f, %s)", value, controlTypeToString(ctrl));
            m_simMonitor.logCommand(cmdStr);
            return CANError.kOk;
        }
    }

    private static String controlTypeToString(ControlType ctrl) {
          switch(ctrl) {
                case kDutyCycle:
                    return "kDutyCycle";
                case kVelocity:
                    return "kVelocity";
                case kVoltage:
                    return "kVoltage";
                case kPosition:
                    return "kPosition";
                case kSmartMotion:
                    return "kSmartMotion";
                case kCurrent:
                    return "kCurrent";
                case kSmartVelocity:
                    return "kSmartVelocity";
                default:
                    return "Unknown Control Type";
          }
    }

}
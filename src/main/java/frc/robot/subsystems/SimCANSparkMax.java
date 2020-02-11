package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.RobotBase;
import frc.robot.consoles.Logger;

// This class is a wrapper around CANSparkMax in order to handle cases where the
// Talon controller and associated motor are not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the Talon is connected then this class just forwards any calls directly
// to the CANSparkMax class.

// If the Talon is not connected, only a subset of the CANSparkMax interface is
// supported, mainly by tracing and other monitoring.

public class SimCANSparkMax extends CANSparkMax {

    private int m_deviceNumber;
    private String m_logicalID;
    private String m_physicalID;
    private MotorType m_motorType;

    private SimulationMonitor m_simMonitor;

    public SimCANSparkMax(String logicalDeviceID, int deviceNumber, MotorType motorType) {
        super(deviceNumber, motorType);

        m_deviceNumber = deviceNumber;
        m_logicalID = logicalDeviceID;
        m_motorType = motorType;

        if (RobotBase.isSimulation()) {
            String physcialDeviceID = String.format("CANSparkMax #%d", deviceNumber);
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
            // TODO: Figure out how to check for connectedness of CANSparkMax
            Logger.problem("Missing technique for testing whether CANSparkMax is connected");
            connected = false;
        }
        return connected;
    }

    public SimCANPIDController getPIDController() {

        if (RobotBase.isReal()) {
            // This upcast is a bit tricky but should be ok as long as a real connection to the
            // RoboRio does not require any of the behavior of the parent class (SimCANPIDController)
            return (SimCANPIDController) super.getPIDController();

        } else {
            String pidControllerName = String.format("PID Controller for %s", m_logicalID);
            SimCANPIDController pidController = new SimCANPIDController(pidControllerName, this);
            return pidController;
        }
    }

    public CANEncoder getEncoder() {

        if (RobotBase.isReal()) {
            // This upcast is a bit tricky but should be ok as long as a real connection to the
            // RoboRio does not require any of the behavior of the parent class (SimCANPIDController)
            return (SimSparkEncoder) super.getEncoder();

        } else {
            String encoderName = String.format("Encoder for %s", m_logicalID);
            SimSparkEncoder encoder = new SimSparkEncoder(encoderName, this);
            return encoder;
        }
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
            String cmdStr = "stopMotor()";
            m_simMonitor.logCommand(cmdStr);
        }
    }

}
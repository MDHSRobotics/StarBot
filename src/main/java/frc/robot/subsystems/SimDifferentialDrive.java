package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// This class is a wrapper around DifferentialDrive in order to handle cases where the
// motors for the DifferentialDrive are not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the DifferentialDrive motors are connected then this class just forwards any calls directly
// to the DifferentialDrive class.

// If the DifferentialDrive motors are not connected, only a subset of the DifferentialDrive interface is
// supported, mainly by tracing and other monitoring.

public class SimDifferentialDrive extends DifferentialDrive {

    private SpeedController m_leftMotor;
    private SpeedController m_rightMotor;
    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public SimDifferentialDrive(String logicalDeviceID, SpeedController leftMotor, SpeedController rightMotor) {
        super(leftMotor, rightMotor);

        m_leftMotor = leftMotor;
        m_rightMotor = rightMotor;

        if (RobotBase.isSimulation()) {
            // Turn off motor safety if we are not attached to RoboRio
            setSafetyEnabled(false);

            String physcialDeviceID = String.format("2-Motor Drive");
            m_simMonitor = new SimulationMonitor(physcialDeviceID, logicalDeviceID);
        }
    }

    // Intercept method if we are in Simulation; otherwise, just delegate it
    public void stopMotor() {

        if (RobotBase.isReal()) {
            super.stopMotor();
        } else {
            String cmdStr = String.format("stopMotor()");
            m_simMonitor.logCommand(cmdStr);
        }
    }

    // Intercept method if we are in Simulation; otherwise, just delegate it
    public void tankDrive(double leftSpeed, double rightSpeed) {

        if (RobotBase.isReal()) {
            super.tankDrive(leftSpeed, rightSpeed);
        } else {
            String cmdString = String.format("tankDrive(%.2f, %.2f)", leftSpeed, rightSpeed);
            m_simMonitor.logCommand(cmdString);
        }
    }

    // Intercept method if we are in Simulation; otherwise, just delegate it
    public void arcadeDrive(double xSpeed, double zRotation) {

        if (RobotBase.isReal()) {
            super.arcadeDrive(xSpeed, zRotation);
        } else {
            String cmdString = String.format("arcadeDrive(%.2f, %.2f)", xSpeed, zRotation);
            m_simMonitor.logCommand(cmdString);
        }
    }

}
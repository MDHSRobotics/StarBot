
package frc.robot.devices;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;

import static frc.robot.RobotManager.isReal;
import static frc.robot.RobotManager.isSim;

// This class is a wrapper around DifferentialDrive in order to handle cases where the
// motors for the DifferentialDrive are not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the DifferentialDrive motors are connected then this class just forwards any calls directly
// to the DifferentialDrive class.

// If the DifferentialDrive motors are not connected, only a subset of the DifferentialDrive interface is
// supported, mainly by tracing and other monitoring.

public class DevDifferentialDrive extends DifferentialDrive {

    private String m_logicalID;
    private String m_physicalID;

    private SimulationMonitor m_simMonitor;

    public DevDifferentialDrive(String logicalDeviceID, SpeedController leftMotor, SpeedController rightMotor) {
        super(leftMotor, rightMotor);

        m_logicalID = logicalDeviceID;

        if (isSim) {
            // Turn off motor safety if we are not attached to RoboRio
            setSafetyEnabled(false);

            m_physicalID = String.format("2-Motor Drive");
            m_simMonitor = new SimulationMonitor(m_physicalID, m_logicalID);
        }
    }

    public void stopMotor() {
        if (isReal) super.stopMotor();

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        m_simMonitor.log(methodName);
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        if (isReal) super.tankDrive(leftSpeed, rightSpeed);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg1 = String.format("%.2f", leftSpeed);
        String arg2 = String.format("%.2f", rightSpeed);
        m_simMonitor.log(methodName, arg1, arg2);
    }

    public void arcadeDrive(double xSpeed, double zRotation) {
        if (isReal) super.arcadeDrive(xSpeed, zRotation);

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg1 = String.format("%.2f", xSpeed);
        String arg2 = String.format("%.2f", zRotation);
        m_simMonitor.log(methodName, arg1, arg2);
    }

}

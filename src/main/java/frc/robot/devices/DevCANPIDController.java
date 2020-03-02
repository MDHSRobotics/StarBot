
package frc.robot.devices;

import com.revrobotics.CANError;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import static frc.robot.RobotManager.isSim;

// This class is a wrapper around CANPIDController in order to handle cases where the
// SparkMax motor controller is not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the SparkMax is connected then this class just forwards any calls directly
// to the CANPIDController class.

// If the SparkMax is not connected, only a subset of the CANPIDController interface is
// supported, mainly by tracing and other monitoring.

public class DevCANPIDController extends CANPIDController implements CANPIDControllable {

    private String m_devName;
    private String m_devDescription;
    private Monitor m_monitor;
    public boolean isConnected = true;

    public DevCANPIDController(String devName, DevCANSparkMax device) {
        super(device);

        m_devName = devName;
        m_devDescription = String.format("CANPIDController #%d", device.getDeviceId());

        isConnected = isConnected();
        if (!isConnected) {
            m_monitor = new Monitor(m_devName, m_devDescription);
        }
    }

    // Determines if this is connected
    private boolean isConnected() {
        if (isSim) return false;
        return true;
    }

    public CANError setReference(double value, ControlType ctrl) {
        if (isConnected) {
            return super.setReference(value, ctrl);
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg1 = String.format("%.2f", value);
        String arg2 = ctrl.name();
        m_monitor.log(methodName, arg1, arg2);
        return CANError.kOk;
    }

}

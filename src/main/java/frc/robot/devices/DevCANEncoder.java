package frc.robot.devices;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;

import static frc.robot.RobotManager.isSim;

// This class is a wrapper around CANEncoder in order to handle cases where the
// CANEncoder is not physically connected.  This can be the case when running the
// simulator but it can also happen when executing code on the RoboRio
// without a fully assembled robot with all of necessary motors and controllers.

// If the CANEncoder is connected then this class just forwards any calls directly
// to the CANEncoder class.

// If the CANEncoder is not connected, only a subset of the CANEncoder interface is
// supported, mainly by tracing and other monitoring.

public class DevCANEncoder extends CANEncoder implements CANEncodable {

    private String m_devName;
    private String m_devDescription;
    private Monitor m_monitor;
    public boolean isConnected = true;

    public DevCANEncoder(String devName, DevCANSparkMax device) {
        super(device);

        m_devName = devName;
        m_devDescription = String.format("CANEncoder #%d", device.getDeviceId());

        isConnected = isConnected();
        if (isConnected) {
            m_monitor = new Monitor(m_devName, m_devDescription);
        }
    }

    // Determines if this is connected
    private boolean isConnected() {
        if (isSim) return false;
        return true;
    }

    public CANError setPosition(double position){
        if (isConnected) {
            return super.setPosition(position);
        }

        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String arg = String.format("%.2f", position);
        m_monitor.log(methodName, arg);
        return CANError.kOk;
    }

}

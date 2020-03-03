package frc.robot.devices;

import com.revrobotics.CANEncoder;

// This class is a wrapper around CANEncoder in order to handle cases where the
// CANEncoder is not physically connected.  This can be the case when running the
// simulator but it can also happen when executing code on the RoboRio
// without a fully assembled robot with all of necessary motors and controllers.

// If the CANEncoder is connected then this class just forwards any calls directly
// to the CANEncoder class.

// If the CANEncoder is not connected, only a subset of the CANEncoder interface is
// supported, mainly by tracing and other monitoring.

public class DevCANEncoder extends CANEncoder implements CANEncodable {

    public DevCANEncoder(DevCANSparkMax device) {
        super(device);
    }

}

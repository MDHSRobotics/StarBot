
package frc.robot.devices;

import com.revrobotics.CANPIDController;

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

    public DevCANPIDController(DevCANSparkMax device) {
        super(device);
    }

}

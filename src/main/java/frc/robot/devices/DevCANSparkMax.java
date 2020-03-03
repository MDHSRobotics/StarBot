
package frc.robot.devices;

import com.revrobotics.CANError;
import com.revrobotics.CANSparkMax;

// This class is a wrapper around CANSparkMax in order to handle cases where the
// SparkMax controller and associated motor are not physically connected.  This
// can be the case when running the simulator but it can also happen when
// executing code on the RoboRio without a fully assembled robot with all of
// necessary motors and controllers.

// If the SparkMax is connected then this class just forwards any calls directly
// to the CANSparkMax class.

// If the SparkMax is not connected, only a subset of the CANSparkMax interface is
// supported, mainly by tracing and other monitoring.

public class DevCANSparkMax extends CANSparkMax implements CANSparkMaxControllable {

    public DevCANSparkMax(int deviceId, MotorType motorType) {
        super(deviceId, motorType);

        restoreFactoryDefaults();
    }

    /////////////////////////////
    // CANSparkMaxControllable //
    /////////////////////////////

    public CANPIDControllable getPIDControllable(String devName) {
        return new DevCANPIDController(this);
    }

    public CANEncodable getEncodable(String devName) {
        return new DevCANEncoder(this);
    }

    public CANError follow(final CANSparkMaxControllable leader) {
        return super.follow((DevCANSparkMax)leader, false);
    }

}


package frc.robot.sensors;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import frc.robot.BotSensors;

// This class contains methods for obtaining useful distance sensor readings
public class DistanceSensor {

    // Used to convert distance sensor voltage to meters
    private static final double mV_PER_5MM = 4.88;

    // Returns the voltage output from the distance sensor
    public static double getVoltage() {
        return BotSensors.distanceSensor.getVoltage();
    }

    // Converts distance sensor voltage to the distance in meters
    public static double getDistanceInMeters() {
        double voltage = getVoltage();
        double meters = getDistanceInMeters(voltage);
        return meters;
    }

    // Converts the given voltage to distance in meters
    public static double getDistanceInMeters(double voltage) {
        double meters = voltage / mV_PER_5MM * 5;
        // Logger.info("DistanceSensor -> Meters away from object: " + meters);
        return meters;
    }

    // TODO: This doesn't get called anywhere. Instead, add a Shuffleboard tab
    public static void updateDashboard() {
        SmartDashboard.putNumber("Distance (volts)", getVoltage());
        SmartDashboard.putNumber("Distance (real)", getDistanceInMeters());
    }

}

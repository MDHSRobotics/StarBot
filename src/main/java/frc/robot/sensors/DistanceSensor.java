
package frc.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

import frc.robot.consoles.Logger;

// This class contains methods for obtaining useful distance sensor readings.
public class DistanceSensor {

    // Used to convert distance sensor voltage to meters
    private static final double mV_PER_5MM = 4.88;

    // Checks connections
    public static void initializeDistanceSensor(AnalogInput distanceSensor) {
        // TODO: How can we check connections?
        boolean distanceSensorIsConnected = true;
        if (!distanceSensorIsConnected) {
            Logger.problem("Distance sensor " + distanceSensor.getChannel() + " not connected!");
        }
    }

    // Returns the voltage output from the distance sensor
    public static double getVoltage(AnalogInput distanceSensor) {
        return distanceSensor.getVoltage();
    }

    // Converts distance sensor voltage to the distance in meters
    public static double getDistanceInMeters(AnalogInput distanceSensor) {
        double voltage = getVoltage(distanceSensor);
        double meters = getDistanceInMeters(voltage);
        return meters;
    }

    // Converts the given voltage to distance in meters
    public static double getDistanceInMeters(double voltage) {
        double meters = voltage / mV_PER_5MM * 5;
        // Logger.info("DistanceSensor -> Meters away from object: " + meters);
        return meters;
    }
}

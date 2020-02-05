package frc.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.consoles.Logger;

public class DistanceSensor {

    // (pins 3, 6 and 7 from sensor to analog input 0)
    private static final AnalogInput mb1013 = new AnalogInput(0);

    // Converts voltage to mm
    private static final double mV_PER_5MM = 4.88;

    // Returns the voltage output from the sensor
    public static double getVoltage() {
        return mb1013.getVoltage();

    }

    // uses the voltage conversion value to get the distance in mm
    public static double getDistance() {
        double voltage = getVoltage();
        Logger.info("voltage: " + voltage);
        double voltageToDistance = voltage / mV_PER_5MM * 5;
        Logger.info("Meters away from the target " + voltageToDistance);
        return voltageToDistance;

    }

    public static void updateDashboard() {
        SmartDashboard.putNumber("Distance (volts)", getVoltage());
        SmartDashboard.putNumber("Distance (real)", getDistance());
    }
}
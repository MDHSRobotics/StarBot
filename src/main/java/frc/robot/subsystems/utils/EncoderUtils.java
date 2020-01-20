
package frc.robot.subsystems.utils;

import java.lang.Math;

import static frc.robot.Constants.EncoderConstants.*;

// Helper methods for encoder values.
public class EncoderUtils {

    // Computes the encoder ticks based on the desired rotation in degrees for a given gearbox ratio
    public static double translateAngleToTicks(double angle, double gearRatio) {
        double rotationCountGS = angle / 360; // Amount of rotations on the gearbox shaft
        double rotationCountMS = rotationCountGS * gearRatio; // Amount of rotations on the motor shaft
        double rotationTicks = rotationCountMS * ENCODER_TPR; // Amount of ticks to rotate
        return rotationTicks;
    }

    // Computes the encoder ticks based on the desired distance in inches for a given winch diameter and gearbox ratio
    public static double translateDistanceToTicks(double distance, double spoolDiameter, double gearRatio) {
        double spoolCircumerence = Math.PI * spoolDiameter;
        double rotationCountGS = distance / spoolCircumerence; // Amount of rotations on the gearbox shaft
        double rotationCountMS = rotationCountGS * gearRatio; // Amount of rotations on the motor shaft
        double rotationTicks = rotationCountMS * ENCODER_TPR; // Amount of ticks to rotate
        return rotationTicks;
    }

}

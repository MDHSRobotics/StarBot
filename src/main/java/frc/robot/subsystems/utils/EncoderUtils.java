
package frc.robot.subsystems.utils;

import static frc.robot.subsystems.constants.EncoderConstants.*;

import java.lang.Math;

// Utility methods for encoder values.
public class EncoderUtils {

    // Computes the encoder ticks based on the desired rotation in degrees for a given gearbox ratio (MS : GS)
    public static double translateAngleToTicks(double angle, double gearRatio) {
        double rotationCountGS = angle / 360.0; // Amount of rotations on the gearbox shaft
        double rotationCountMS = rotationCountGS * gearRatio; // Amount of rotations on the motor shaft
        double rotationTicks = rotationCountMS * ENCODER_TPR; // Amount of ticks to rotate
        return rotationTicks;
    }

    // Computes the encoder ticks based on the desired distance in inches for a given wheel diameter and gearbox ratio (MS : GS)
    public static double translateDistanceToTicks(double distance, double wheelDiameter, double gearRatio) {
        double spoolCircumerence = Math.PI * (wheelDiameter / 12.0);
        double rotationCountGS = distance / spoolCircumerence; // Amount of rotations on the gearbox shaft
        double rotationCountMS = rotationCountGS * gearRatio; // Amount of rotations on the motor shaft
        double rotationTicks = rotationCountMS * ENCODER_TPR; // Amount of ticks to rotate
        return rotationTicks;
    }

    // Computes the encoder native velocity based on the desired velocity in feet per second for a given wheel diameter and gearbox ratio (MS : GS)
    public static double translateFPSToTicksPerDecisecond(double distance, double wheelDiameter, double gearRatio) {
        double spoolCircumerence = Math.PI * (wheelDiameter / 12.0);
        double rotationCountGS = distance / spoolCircumerence; // Amount of rotations on the gearbox shaft
        double rotationCountMS = rotationCountGS * gearRatio; // Amount of rotations on the motor shaft
        double rotationTicks = rotationCountMS * ENCODER_TPR / 10.0; // Amount of ticks to rotate
        return rotationTicks;
    }

    // Computes the encoder native velocity based on the desired rotations per second and the gearbox ratio (MS : GS)
    public static double translateRPSToTicksPerDecisecond(double rps, double gearRatio) {
        double rotationsPerDecisecondGS = rps / 10.0; // Amount of rpds on the gearbox shaft
        double rotationsPerDecisecondMS = rotationsPerDecisecondGS * gearRatio; // Amount of rpds on the motor shaft
        double ticksPerDecisecond = rotationsPerDecisecondMS * ENCODER_TPR; // Amount of ticks per decisecond to rotate
        return ticksPerDecisecond;
    }

}


package frc.robot.devices;

import com.revrobotics.CANError;

public interface CANEncodable {

    double getPosition();

    double getVelocity();

    CANError setPosition(double position);

    CANError setPositionConversionFactor(double factor);

    CANError setVelocityConversionFactor(double factor);

    double getPositionConversionFactor();

    double getVelocityConversionFactor();

    CANError setAverageDepth(int depth);

    int getAverageDepth();

    CANError setMeasurementPeriod(int period_us);

    int getMeasurementPeriod();

    int getCPR();

    int getCountsPerRevolution();

    CANError setInverted(boolean inverted);

    boolean getInverted();

}


package frc.robot.devices;

import com.revrobotics.CANError;
import com.revrobotics.CANPIDController.AccelStrategy;
import com.revrobotics.CANPIDController.ArbFFUnits;
import com.revrobotics.ControlType;

public interface CANPIDControllable {

    CANError setReference(double value, ControlType ctrl);

    CANError setReference(double value, ControlType ctrl, int pidSlot);

    CANError setReference(double value, ControlType ctrl, int pidSlot, double arbFeedforward);

    CANError setReference(double value, ControlType ctrl, int pidSlot, double arbFeedforward, ArbFFUnits arbFFUnits);

    CANError setP(double gain);

    CANError setP(double gain, int slotID);

    CANError setI(double gain);

    CANError setI(double gain, int slotID);

    CANError setD(double gain);

    CANError setD(double gain, int slotID);

    CANError setDFilter(double gain);

    CANError setDFilter(double gain, int slotID);

    CANError setFF(double gain);

    CANError setFF(double gain, int slotID);

    CANError setIZone(double IZone);

    CANError setIZone(double IZone, int slotID);

    CANError setOutputRange(double min, double max);

    CANError setOutputRange(double min, double max, int slotID);

    double getP();

    double getP(int slotID);

    double getI();

    double getI(int slotID);

    double getD();

    double getD(int slotID);

    double getDFilter(int slotID);

    double getFF();

    double getFF(int slotID);

    double getIZone();

    double getIZone(int slotID);

    double getOutputMin();

    double getOutputMin(int slotID);

    double getOutputMax();

    double getOutputMax(int slotID);

    CANError setSmartMotionMaxVelocity(double maxVel, int slotID);

    CANError setSmartMotionMaxAccel(double maxAccel, int slotID);

    CANError setSmartMotionMinOutputVelocity(double minVel, int slotID);

    CANError setSmartMotionAllowedClosedLoopError(double allowedErr, int slotID);

    CANError setSmartMotionAccelStrategy(AccelStrategy accelStrategy, int slotID);

    double getSmartMotionMaxVelocity(int slotID);

    double getSmartMotionMaxAccel(int slotID);

    double getSmartMotionMinOutputVelocity(int slotID);

    double getSmartMotionAllowedClosedLoopError(int slotID);

    AccelStrategy getSmartMotionAccelStrategy(int slotID);

    CANError setIMaxAccum(double iMaxAccum, int slotID);

    double getIMaxAccum(int slotID);

    CANError setIAccum(double iAccum);

    double getIAccum();

}

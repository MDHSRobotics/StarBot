package frc.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;
import frc.robot.consoles.Logger;

/**
 * This is a sample program demonstrating how to use an ultrasonic sensor and
 * proportional control to maintain a set distance from an object.
 */

public class DistanceSensor {

  // distance in inches the robot wants to stay from an object
  private static final double kHoldDistance = 12.0;

  // factor to convert sensor values to a distance in inches
  private static final double kValueToInches = 0.125;

  // proportional speed constant
  private static final double kP = 0.05;

  private static final int kUltrasonicPort = 0;

  private static final AnalogInput m_ultrasonic = new AnalogInput(kUltrasonicPort);

  /**
   * Tells the robot to drive to a set distance (in inches) from an object
   * using proportional control.
   */

  public static void getDistance() {
    // sensor returns a value from 0-4095 that is scaled to inches
    double currentDistance = m_ultrasonic.getValue() * kValueToInches;
    Logger.info("Current distance: " + currentDistance);
  }

// convert distance error to a motor speed
// double currentSpeed = (kHoldDistance - currentDistance) * kP;

}
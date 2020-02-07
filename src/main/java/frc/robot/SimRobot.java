/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * This is a specialization of the Robot class specifically for running in the
 * Simulator.
 */
public class SimRobot extends Robot {

    // Note that the RoboRio uses a duration of .02 seconds which is too
    // short of a time slice when running in simulation mode (i.e. it results
    // in watchdog overruns)
    private static double kSimulationPeriod = .2;

    public SimRobot() {
      super(kSimulationPeriod);
    }
}
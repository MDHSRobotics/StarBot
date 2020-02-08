
package frc.robot.tests.driving;

import edu.wpi.first.wpilibj.Timer;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.DPadButton.Direction;
import frc.robot.tests.TestRunnable;
import frc.robot.VirtualControllers;

// Test class for the DriveDiffTank command.
public class DriveDiffTankTest implements TestRunnable {

    // Timer variables
    private Timer m_timer = new Timer();
    private double m_currentTime;

    // Constants
    private final double TOTAL_SECONDS = 12.0;

    // Run the test
    public int run(int iteration) {
        if (iteration == 0) {
            // Start the test on the first iteration
            Logger.setup("Starting DriveDiffTankTest for " + TOTAL_SECONDS + " seconds...");
            m_currentTime = 0.0;
            m_timer.stop();
            m_timer.reset();
            m_timer.start();
            VirtualControllers.primary.xbox.dpadActive = true;
            VirtualControllers.primary.xbox.dpadDirection = Direction.UP;

        } else {
            // Reset the time and return 0 when all movements are complete
            Logger.ending("Ending DriveDiffTankTest...");
            m_currentTime = 0.0;
            return 0;
        }

        m_currentTime = m_timer.get();
        return iteration + 1;
    }

}

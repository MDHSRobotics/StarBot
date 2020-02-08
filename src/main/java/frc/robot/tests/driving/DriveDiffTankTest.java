
package frc.robot.tests.driving;

import edu.wpi.first.wpilibj.Timer;

import frc.robot.consoles.Logger;
import frc.robot.tests.TestRunnable;
import frc.robot.VirtualControllers;

// Test class for the DriveDiffTank command.
public class DriveDiffTankTest implements TestRunnable {

    // Timer variables
    private Timer m_timer = new Timer();
    private double m_currentTime;

    // Constants
    private final double TOTAL_SECONDS = 18.0;
    private final double TOTAL_MOVEMENTS = 12.0;
    private final double SECONDS_PER_MOVEMENT = TOTAL_SECONDS / TOTAL_MOVEMENTS;

    // Run the test
    public int run(int iteration) {
        if (iteration == 0) {
            // Start the test on the first iteration
            Logger.setup("Starting DriveDiffTankTest for " + TOTAL_SECONDS + " seconds...");

            m_timer.reset();
            m_timer.start();

            m_currentTime = m_timer.get();

            VirtualControllers.primary.xbox.xLeft = -0.5;
            VirtualControllers.primary.xbox.yLeft = -0.5;
        }
        else if (m_currentTime < 1 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.xLeft = 0.5;
            VirtualControllers.primary.xbox.yLeft = 0.5;

        }
        else if (m_currentTime < 2 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.xRight = -0.5;
            VirtualControllers.primary.xbox.yRight = -0.5;
        }
        else if (m_currentTime < 3 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.xRight = 0.5;
            VirtualControllers.primary.xbox.yRight = 0.5;
        }
        else if (m_currentTime < 4 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.xRight = -0.5;
            VirtualControllers.primary.xbox.yLeft = 0.5;
        }
        else if (m_currentTime < 6 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.xLeft = -1.0;
            while (VirtualControllers.primary.xbox.xLeft < 1.0 && VirtualControllers.primary.xbox.xLeft >= -1.0) {
                VirtualControllers.primary.xbox.xLeft += 0.1;
            }
        }
        else if (m_currentTime < 8 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.xRight = -1.0;
            while (VirtualControllers.primary.xbox.xRight < 1.0 && VirtualControllers.primary.xbox.xRight >= -1.0) {
                VirtualControllers.primary.xbox.xRight += 0.1;
            }
        }
        else if (m_currentTime < 10 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.yLeft = -1.0;
            while (VirtualControllers.primary.xbox.yLeft < 1.0 && VirtualControllers.primary.xbox.yLeft >= -1.0) {
                VirtualControllers.primary.xbox.yLeft += 0.1;
            }
        }
        else if (m_currentTime < 12 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.yRight = -1.0;
            while (VirtualControllers.primary.xbox.yRight < 1.0 && VirtualControllers.primary.xbox.yRight >= -1.0) {
                VirtualControllers.primary.xbox.yRight += 0.1;
            }
        }
        else {
            // Reset the time and return 0 when all movements are complete
            Logger.ending("Ending DriveDiffTankTest...");
            m_currentTime = 0.0;
            return 0;
        }

        m_currentTime = m_timer.get();
        return iteration + 1;
    }

}

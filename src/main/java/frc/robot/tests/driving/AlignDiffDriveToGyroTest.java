
package frc.robot.tests.driving;

import edu.wpi.first.wpilibj.Timer;

import frc.robot.consoles.Logger;
import frc.robot.oi.controllers.DPadButton.Direction;
import frc.robot.tests.TestRunnable;
import frc.robot.VirtualControllers;

// Test class for the AlignDiffDriveToGyro command.
public class AlignDiffDriveToGyroTest implements TestRunnable {

    // Timer variables
    private Timer m_timer = new Timer();
    private double m_currentTime;

    // Constants
    private final double TOTAL_SECONDS = 12.0;
    private final double TOTAL_MOVEMENTS = 8.0;
    private final double SECONDS_PER_MOVEMENT = TOTAL_SECONDS/TOTAL_MOVEMENTS;

    // Run the test
    public int run(int iteration) {
        if (iteration == 0) {
            // Start the test on the first iteration
            Logger.setup("Starting AlignDiffDriveToGyroTest for " + TOTAL_SECONDS + " seconds...");
            m_currentTime = 0.0;
            m_timer.stop();
            m_timer.reset();
            m_timer.start();
            VirtualControllers.primary.xbox.dpadActive = true;
            VirtualControllers.primary.xbox.dpadDirection = Direction.UP;
        }
        else if (m_currentTime < 1 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.RIGHT;
        }
        else if (m_currentTime < 2 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.LEFT;
        }
        else if (m_currentTime < 3 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.DOWN_RIGHT;
        }
        else if (m_currentTime < 4 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.DOWN;
        }
        else if (m_currentTime < 5 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.DOWN_LEFT;
        }
        else if (m_currentTime < 6 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.UP_RIGHT;
        }
        else if (m_currentTime < 7 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.UP_LEFT;
        }
        else if (m_currentTime < 8 * SECONDS_PER_MOVEMENT) {
            VirtualControllers.primary.xbox.dpadDirection = Direction.UP;
        }
        else {
            // Reset the time and return 0 when all movements are complete
            Logger.ending("Ending AlignDiffDriveToGyroTest...");
            m_currentTime = 0.0;
            return 0;
        }

        m_currentTime = m_timer.get();
        return iteration+1;
    }

}

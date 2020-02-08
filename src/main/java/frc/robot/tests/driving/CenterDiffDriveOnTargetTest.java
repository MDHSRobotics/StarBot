
package frc.robot.tests.driving;

import edu.wpi.first.wpilibj.Timer;

import frc.robot.consoles.Logger;
import frc.robot.tests.TestRunnable;
import frc.robot.VirtualControllers;

// Test class for the CenterDiffDriveOnTarget command.
public class CenterDiffDriveOnTargetTest implements TestRunnable {

    // Timer variables
    private Timer m_timer = new Timer();
    private double m_currentTime = 0.0;

    // Constants
    private final double TOTAL_SECONDS = 8.0;

    // Run the test
    public int run(int iteration) {
        if (iteration == 0) {
            // Start the test on the first iteration
            Logger.setup("Starting CenterDiffDriveOnTarget for " + TOTAL_SECONDS + " seconds...");
            m_timer.stop();
            m_timer.reset();
            m_timer.start();
            m_currentTime = m_timer.get();
            VirtualControllers.primary.btnBumperRight.active = true;
            Logger.action("Start Center");
        }
        else if (m_currentTime < 2) {
            VirtualControllers.primary.btnBumperRight.active = false;
            Logger.action("Stop Center");
            m_currentTime = m_timer.get();
        } else if (m_currentTime < 4) {
            VirtualControllers.primary.btnBumperRight.active = true;
            Logger.action("Start Center");
            m_currentTime = m_timer.get();
        } else if (m_currentTime < 6) {
            VirtualControllers.primary.btnBumperRight.active = false;
            Logger.action("Stop Center");
            m_currentTime = m_timer.get();
        } else if (m_currentTime < TOTAL_SECONDS) {
            VirtualControllers.primary.btnBumperRight.active = true;
            Logger.action("Start Center");
            m_currentTime = m_timer.get();
        }
        else {
            // Reset the time and return 0 when all movements are complete
            Logger.ending("Ending CenterDiffDriveOnTargetTest...");
            m_currentTime = 0.0;
            return 0;
        }

        m_currentTime = m_timer.get();
        return iteration+1;
    }

}

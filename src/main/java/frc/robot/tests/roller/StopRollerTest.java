
package frc.robot.tests.roller;

import edu.wpi.first.wpilibj.Timer;

import frc.robot.consoles.Logger;
import frc.robot.tests.TestRunnable;
import frc.robot.BotCommands;

// Test class for the CycleLights command.
public class StopRollerTest implements TestRunnable {

    // Timer variables
    private Timer m_timer = new Timer();
    private double m_currentTime;

    // Run the test
    public int run(int iteration) {
        if (iteration == 0) {
            Logger.action("Starting StopRollerTest...");
            BotCommands.stopRoller.schedule();
            m_timer.stop();
            m_timer.reset();
            m_timer.start();
        } else {
            m_currentTime = m_timer.get();
            if (m_currentTime < 4.0) {
                BotCommands.stopRoller.isFinished();
                // Return 0 when the command is finished
                return 0;
            }
        }

        return iteration + 1;
    }

}

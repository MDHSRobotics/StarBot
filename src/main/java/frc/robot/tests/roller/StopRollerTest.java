
package frc.robot.tests.roller;

import frc.robot.consoles.Logger;
import frc.robot.tests.TestRunnable;
import frc.robot.BotCommands;

// Test class for the CycleLights command.
public class StopRollerTest implements TestRunnable {

    // Run the test
    public int run(int iteration) {
        if (iteration == 0) {
            Logger.action("Starting StopRollerTest...");
            BotCommands.stopRoller.schedule();
        } else {
            boolean isScheduled = BotCommands.stopRoller.isScheduled();
            if (!isScheduled) {
                // Return 0 when the command is finished
                return 0;
            }
        }
        return iteration + 1;
    }

}

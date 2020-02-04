
package frc.robot.tests.lighting;

import frc.robot.consoles.Logger;
import frc.robot.tests.TestRunnable;
import frc.robot.BotCommands;

// Test class for the CycleLights command.
public class CycleLightsTest implements TestRunnable{

    // Run the test
    public int run(int iteration) {
        if (iteration == 0) {
            Logger.action("Starting CycleLightsTest...");
            BotCommands.cycleLights.schedule();
        }
        else {
            boolean isScheduled = BotCommands.cycleLights.isScheduled();
            if (!isScheduled) {
                // Return 0 when the command is finished
                return 0;
            }
        }
        return iteration+1;
    }

}


package frc.robot;

import frc.robot.oi.controllers.JoystickContainer;
import frc.robot.consoles.Logger;

// This class contains the robot controllers and defined ports.
public class BotJoystick {

    // Controllers
    public static final JoystickContainer joystick = new JoystickContainer(1);

    // Configure all the controllers
    public static void configure() {
        configureJoystick();
    }

    // Configure the Joystick
    public static void configureJoystick() {
        // Detect whether the primary controller has been plugged in after start-up
        if (!BotJoystick.joystick.configured) {
            boolean isConnected = BotJoystick.joystick.isConnected();
            if (!isConnected)
                return;

            // Configure button bindings
            ButtonBindings.configureJoystick();
            BotJoystick.joystick.configured = true;
            Logger.setup("Joystick detected and configured");
        }
    }

}

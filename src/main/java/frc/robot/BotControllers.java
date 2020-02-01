
package frc.robot;

import frc.robot.oi.controllers.XboxControllerContainer;

// This class contains the robot controllers and defined ports.
public class BotControllers {

    // Controllers - TODO: Need to add a climb controller?
    public static final XboxControllerContainer drive = new XboxControllerContainer(0);
    public static final XboxControllerContainer shoot = new XboxControllerContainer(1);

}

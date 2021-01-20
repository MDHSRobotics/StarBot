
package frc.robot;

import frc.robot.oi.controllers.VirtualXboxControllerContainer;

// This class contains virtual controllers for use in simulating button events.
public class VirtualControllers {

    // TODO: Change these to match the real controllers

    // Virtual Controllers
    public static final VirtualXboxControllerContainer primary = new VirtualXboxControllerContainer();


    // Configure all the virtual controller button bindings
    public static void configure() {
        VirtualButtonBindings.configurePrimary();

    }

    // Reset all virtual controller buttons and analog inputs
    public static void reset() {
        primary.reset();

    }

}

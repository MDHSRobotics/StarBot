
package frc.robot.oi.controllers;

import frc.robot.oi.positions.JoystickPosition;

// This class contains a virtual joystick and properties for all its virtual buttons.
public class VirtualJoystickControllerContainer implements JoystickPositionAccessible {

    // TODO: We need to create a VirtualJoystick class, and use it here
    public VirtualXboxController jstick;
    public VirtualButton jstickBtn1;
    public VirtualButton jstickBtn2;
    public VirtualButton jstickBtn3;
    public VirtualButton jstickBtn4;
    public VirtualButton jstickBtn5;
    public VirtualButton jstickBtn6;
    public VirtualButton jstickBtn7;
    public VirtualButton jstickBtn8;
    public VirtualButton jstickBtn9;
    public VirtualButton jstickBtn10;
    public VirtualButton jstickBtn11;
    public VirtualButton jstickBtn12;

    public VirtualJoystickControllerContainer() {
        jstick = new VirtualXboxController();
        jstickBtn1 = new VirtualButton();
        jstickBtn2 = new VirtualButton();
        jstickBtn3 = new VirtualButton();
        jstickBtn4 = new VirtualButton();
        jstickBtn5 = new VirtualButton();
        jstickBtn6 = new VirtualButton();
        jstickBtn7 = new VirtualButton();
        jstickBtn8 = new VirtualButton();
        jstickBtn9 = new VirtualButton();
        jstickBtn10 = new VirtualButton();
        jstickBtn11 = new VirtualButton();
        jstickBtn12 = new VirtualButton();
    }

    public void reset() {
        jstick.resetInputs();
        jstickBtn1.active = false;
        jstickBtn2.active = false;
        jstickBtn3.active = false;
        jstickBtn4.active = false;
        jstickBtn5.active = false;
        jstickBtn6.active = false;
        jstickBtn7.active = false;
        jstickBtn8.active = false;
        jstickBtn9.active = false;
        jstickBtn10.active = false;
        jstickBtn11.active = false;
        jstickBtn12.active = false;
    }

    // Gets the raw virtual joystick positions
    public JoystickPosition getJoystickPosition(boolean isYleftFlipped) {
        double y = jstick.getY(); // Forward & backward, flipped
        double x = jstick.getX(); // Side to Side, flipped
        double z = jstick.getY(); // Rotation

        JoystickPosition pos = new JoystickPosition(x, y, z);
        return pos;
    }

}

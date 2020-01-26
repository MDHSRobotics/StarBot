
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;

// This class contains singleton (static) instances of id mapped subsystem components.
// If a device is not connected at initialization, it should be set to null.
// IMPORTANT: Only ONE subsystem should control any given device.
// Device instances are package-private (neither private nor public) so they can only be used by subsystems.
public class Devices {

    //////////////////////
    // Device Instances //
    //////////////////////

    // CANSparkMax
    static CANSparkMax sparkMaxClimbArm = new CANSparkMax(1, MotorType.kBrushless);
    static CANSparkMax sparkMaxClimbRoller = new CANSparkMax(2, MotorType.kBrushless);
    static CANSparkMax sparkMaxClimbStandTwo = new CANSparkMax(3, MotorType.kBrushless);
    static CANSparkMax sparkMaxClimbStandThree = new CANSparkMax(4, MotorType.kBrushless);
    static CANSparkMax sparkMaxClimbStandFour = new CANSparkMax(5, MotorType.kBrushless);
    static CANSparkMax sparkMaxClimbHook = new CANSparkMax(6, MotorType.kBrushless);

    // Relays
    static Relay relayLighter = new Relay(1);

    ////////////////////////
    // Drive Declarations //
    ////////////////////////

    // TODO: Add the appropriate drives

    /////////////////////
    // Initializations //
    /////////////////////

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing subsystem Devices...");

        // TODO: Initialize the devices
    }

}

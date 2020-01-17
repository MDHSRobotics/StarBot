
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Relay;

import frc.robot.consoles.Logger;

// This class contains singleton instances of id mapped subsystem components, and utility methods.
// IMPORTANT: It is imperative that ONLY subsystems control any interactive device.
// Also, only ONE subsystem should control any given device.
public class SubsystemDevices {

    // Relays
    public static Relay relayLighter = new Relay(1);

    // Motor Controllers
    // TODO: Add the appropriate motor controllers
    public static CANSparkMax sparkMaxClimbArm = new CANSparkMax(1, MotorType.kBrushless);
    public static CANSparkMax sparkMaxClimbStandOne = new CANSparkMax(2, MotorType.kBrushless);
    public static CANSparkMax sparkMaxClimbStandTwo = new CANSparkMax(3, MotorType.kBrushless);
    public static CANSparkMax sparkMaxClimbStandThree = new CANSparkMax(4, MotorType.kBrushless);
    public static CANSparkMax sparkMaxClimbStandFour = new CANSparkMax(5, MotorType.kBrushless);

    // Drives
    // TODO: Add the appropriate drives

    // Intialize the subsystem devices
    public static void initializeDevices() {
        Logger.setup("Initializing SubsystemDevices...");

        // TODO: Initialize the devices
    }

    // Determines if the Talon SRX is connected
    public static boolean isConnected(WPI_TalonSRX talon) {
        int firmVer = talon.getFirmwareVersion();
        boolean connected = (firmVer != -1);
        return connected;
    }

}

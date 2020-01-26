
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.sparkMaxClimbArm;
import static frc.robot.subsystems.Devices.sparkMaxClimbHook;
import static frc.robot.subsystems.Devices.sparkMaxClimbRoller;
import static frc.robot.subsystems.Devices.sparkMaxClimbStandFour;
import static frc.robot.subsystems.Devices.sparkMaxClimbStandThree;
import static frc.robot.subsystems.Devices.sparkMaxClimbStandTwo;

// Climb subsystem, for lifting the robot, hooking onto the level,
// retracting the legs, and rolling on the level
public class Climb extends SubsystemBase {

    // Subsystem state variables
    public boolean hookIsOut = true;
    public boolean legsAreUp = true;

    // Subsystem constants
    private final double POWER = 0.5;
    private final double ROTATIONS = 200;

    // PID constants
    private final double kP = 0.1;
    private final double kI = 1e-4;
    private final double kD = 1;
    private final double kIz = 0;
    private final double kFF = 0;
    private final double kMaxOutput = 1;
    private final double kMinOutput = -1;

    // Private member variables
    private CANEncoder m_encoder;
    private CANPIDController m_pidController;

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public Climb() {
        Logger.setup("Constructing Subsystem: Climb...");
        m_disabled = (sparkMaxClimbArm == null);
        if (m_disabled) {
            Logger.error("Shooter devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure devices
        sparkMaxClimbArm.restoreFactoryDefaults();

        // Encoder object created to display position values
        m_encoder = sparkMaxClimbArm.getEncoder();

        // Get the PID contoller from the CANSparkMax device
        m_pidController = sparkMaxClimbArm.getPIDController();

        // Set PID coefficients
        m_pidController.setP(kP);
        m_pidController.setI(kI);
        m_pidController.setD(kD);
        m_pidController.setIZone(kIz);
        m_pidController.setFF(kFF);
        m_pidController.setOutputRange(kMinOutput, kMaxOutput);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop everything
    public void stop() {
        // Hook
        sparkMaxClimbHook.stopMotor();

        // Hook Arm
        sparkMaxClimbArm.stopMotor();

        // Legs
        sparkMaxClimbStandTwo.stopMotor();
        sparkMaxClimbStandThree.stopMotor();
        sparkMaxClimbStandFour.stopMotor();

        // Roller
        sparkMaxClimbRoller.stopMotor();
    }

    ////////////////
    // Climb Hook //
    ////////////////

    public void hookForward() {
        sparkMaxClimbHook.set(POWER);
    }

    public void hookReverse() {
        sparkMaxClimbHook.set(-POWER);
    }

    public void toggleHookPosition() {
        hookIsOut = !hookIsOut;
    }

    ////////////////////
    // Climb Hook Arm //
    ////////////////////

    public void extendArm() {
        sparkMaxClimbArm.set(0.5);
    }

    public void retractArm() {
        sparkMaxClimbArm.set(-0.5);
    }

    ////////////////
    // Climb Legs //
    ////////////////

    public void liftRobot() {
        m_pidController.setReference(ROTATIONS, ControlType.kPosition);
    }

    public void lowerRobot() {
        m_pidController.setReference(0, ControlType.kPosition);
    }

    public void toggleLegsPosition() {
        legsAreUp = !legsAreUp;
    }

    //////////////////
    // Climb Roller //
    //////////////////

    public void rollerForward() {
        sparkMaxClimbRoller.set(POWER);
    }

    public void rollerReverse() {
        sparkMaxClimbRoller.set(-POWER);
    }

}

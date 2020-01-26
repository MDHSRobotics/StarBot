
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;

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

    // If not all the motor controllers are initialized, this should be true
    private boolean m_disabled = false;

    public Climb() {
        Logger.setup("Constructing Subsystem: Climb...");
        m_disabled = (SubsystemDevices.sparkMaxClimbArm == null);
        if (m_disabled) {
            Logger.error("Shooter devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure devices
        SubsystemDevices.sparkMaxClimbArm.restoreFactoryDefaults();

        // Encoder object created to display position values
        m_encoder = SubsystemDevices.sparkMaxClimbArm.getEncoder();

        // Get the PID contoller from the CANSparkMax device
        m_pidController = SubsystemDevices.sparkMaxClimbArm.getPIDController();

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
        SubsystemDevices.sparkMaxClimbHook.stopMotor();

        // Hook Arm
        SubsystemDevices.sparkMaxClimbArm.stopMotor();

        // Legs
        SubsystemDevices.sparkMaxClimbStandTwo.stopMotor();
        SubsystemDevices.sparkMaxClimbStandThree.stopMotor();
        SubsystemDevices.sparkMaxClimbStandFour.stopMotor();

        // Roller
        SubsystemDevices.sparkMaxClimbRoller.stopMotor();
    }

    ////////////////
    // Climb Hook //
    ////////////////

    public void hookForward() {
        SubsystemDevices.sparkMaxClimbHook.set(POWER);
    }

    public void hookReverse() {
        SubsystemDevices.sparkMaxClimbHook.set(-POWER);
    }

    public void toggleHookPosition() {
        hookIsOut = !hookIsOut;
    }

    ////////////////////
    // Climb Hook Arm //
    ////////////////////

    public void extendArm() {
        SubsystemDevices.sparkMaxClimbArm.set(0.5);
    }

    public void retractArm() {
        SubsystemDevices.sparkMaxClimbArm.set(-0.5);
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
        SubsystemDevices.sparkMaxClimbRoller.set(POWER);
    }

    public void rollerReverse() {
        SubsystemDevices.sparkMaxClimbRoller.set(-POWER);
    }

}

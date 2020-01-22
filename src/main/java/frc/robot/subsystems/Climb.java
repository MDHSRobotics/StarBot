
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.SubsystemDevices;
import frc.robot.consoles.Logger;
import frc.robot.Constants;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

// Climb subsystem, for pulling robot up and down.
public class Climb extends SubsystemBase {

   private boolean m_disabled = false;
   public boolean hookIsOut = true;
   public boolean legsAreUp = true;

   private final double m_power = 0.5;
   private CANPIDController m_pidController;
   private CANEncoder m_encoder;
   public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
   public final double rotations = 200;

    public Climb () {
        Logger.setup("Constructing Subsystem: Climb...");
        m_disabled = (SubsystemDevices.sparkMaxClimbArm == null);
        if (m_disabled) {
            Logger.error("Shooter devices not initialized! Disabling subsystem...");
            return;
        }

        SubsystemDevices.sparkMaxClimbArm.restoreFactoryDefaults();

        /**
         * In order to use PID functionality for a controller, a CANPIDController object
         * is constructed by calling the getPIDController() method on an existing
         * CANSparkMax object
         */
        m_pidController = SubsystemDevices.sparkMaxClimbArm.getPIDController();

        // Encoder object created to display position values
        m_encoder = SubsystemDevices.sparkMaxClimbArm.getEncoder();

        // PID coefficients
        kP = 0.1;
        kI = 1e-4;
        kD = 1;
        kIz = 0;
        kFF = 0;
        kMaxOutput = 1;
        kMinOutput = -1;

        // set PID coefficients
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

    public void toggleHookPosition() {
        hookIsOut = !hookIsOut;
    }

    public void toggleLegsPosition() {
        legsAreUp = !legsAreUp;
    }

    public void liftRobot() {
        m_pidController.setReference(rotations, ControlType.kPosition);
    }

    public void lowerRobot() {
        m_pidController.setReference(0, ControlType.kPosition);
    }

    public void rollerForward() {
        SubsystemDevices.sparkMaxClimbRoller.set(m_power);
        }

    public void rollerReverse() {
        SubsystemDevices.sparkMaxClimbRoller.set(-m_power);

    }

    public void extendArm() {
        SubsystemDevices.sparkMaxClimbArm.set(0.5);
    }

    public void retractArm() {
        SubsystemDevices.sparkMaxClimbArm.set(-0.5);
    }

    public void hookForward() {
        SubsystemDevices.sparkMaxClimbHook.set(m_power);
    }

    public void hookReverse() {
        SubsystemDevices.sparkMaxClimbHook.set(-m_power);
    }

    public void stop() {
        SubsystemDevices.sparkMaxClimbArm.stopMotor();
        SubsystemDevices.sparkMaxClimbRoller.stopMotor();
        SubsystemDevices.sparkMaxClimbStandTwo.stopMotor();
        SubsystemDevices.sparkMaxClimbStandThree.stopMotor();
        SubsystemDevices.sparkMaxClimbStandFour.stopMotor();
        SubsystemDevices.sparkMaxClimbHook.stopMotor();

    }
}

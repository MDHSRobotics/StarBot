
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.sparkMaxClimbLegMaster;
import static frc.robot.subsystems.Devices.sparkMaxClimbLegSlave;;

// Climb subsystem, for lifting the robot, hooking onto the level,
// retracting the legs, and rolling on the level
public class SparkMaxClimb extends SubsystemBase {

    // Subsystem state variables
    public boolean hookIsOut = true;
    public boolean legsAreUp = false;

    // Subsystem constants
    private final double POWER = 0.2;
    //private final double ROTATIONS = 50;

    // PID constants
    private final double kP = 0.00016; //0.07
    private final double kI = 0; //0
    private final double kD = 0.0004; //0
    private final double kIz = 0; //0
    private final double kFF = 0.000156; //0
    private final double kMaxOutput = 1.0;
    private final double kMinOutput = -1.0;

    // Private member variables
    private CANEncoder m_encoder;
    private CANEncoder m_encoder2;
    private CANPIDController m_pidController;
    private CANPIDController m_pidController2;

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public SparkMaxClimb() {
        Logger.setup("Constructing Subsystem: Climb...");
        m_disabled = (sparkMaxClimbLegMaster == null);
        if (m_disabled) {
            Logger.problem("Climb devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure devices
        sparkMaxClimbLegMaster.restoreFactoryDefaults();
        sparkMaxClimbLegSlave.restoreFactoryDefaults();

        // Encoder object created to display position values
        m_encoder = sparkMaxClimbLegMaster.getEncoder();
        m_encoder2 = sparkMaxClimbLegSlave.getEncoder();

        // Get the PID contoller from the CANSparkMax device
        m_pidController = sparkMaxClimbLegMaster.getPIDController();
        m_pidController2 = sparkMaxClimbLegSlave.getPIDController();

        // Set PID coefficients
        m_pidController.setP(kP);
        m_pidController.setI(kI);
        m_pidController.setD(kD);
        m_pidController.setIZone(kIz);
        m_pidController.setFF(kFF);
        m_pidController.setOutputRange(kMinOutput, kMaxOutput);

        m_pidController2.setP(kP);
        m_pidController2.setI(kI);
        m_pidController2.setD(kD);
        m_pidController2.setIZone(kIz);
        m_pidController2.setFF(kFF);
        m_pidController2.setOutputRange(kMinOutput, kMaxOutput);

        // Smart Motion
        int smartMotionSlot = 0;
        m_pidController.setSmartMotionMaxVelocity(1000, smartMotionSlot);
        m_pidController.setSmartMotionMaxAccel(500, smartMotionSlot);
        m_pidController.setDFilter(0.25, smartMotionSlot);
        //m_pidController.setSmartMotionAllowedClosedLoopError(0.02, smartMotionSlot);
        m_pidController.setSmartMotionMinOutputVelocity(0, 0);

        m_pidController2.setSmartMotionMaxVelocity(1000, smartMotionSlot);
        m_pidController2.setSmartMotionMaxAccel(500, smartMotionSlot);
        m_pidController2.setDFilter(0.25, smartMotionSlot);
        //m_pidController.setSmartMotionAllowedClosedLoopError(0.02, smartMotionSlot);
        m_pidController2.setSmartMotionMinOutputVelocity(0, 0);

        // Set up followed motor
        //Devices.sparkMaxClimbLegSlave.follow(sparkMaxClimbLegMaster);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop everything
    public void stop() {
        // Legs
        sparkMaxClimbLegMaster.stopMotor();
        sparkMaxClimbLegSlave.stopMotor();
    }

    ////////////////
    // Climb Legs //
    ////////////////

    public void liftRobot() {
        double ROTATIONS = ClimbBrain.getClimbRotation();

        m_encoder.setPosition(0);
        m_encoder2.setPosition(0);
        m_pidController.setReference(ROTATIONS, ControlType.kSmartMotion);
        m_pidController2.setReference(ROTATIONS, ControlType.kSmartMotion);
        //m_pidController.setReference(ROTATIONS, ControlType.kPosition);
    }

    public void lowerRobot() {
        m_pidController.setReference(0, ControlType.kSmartMotion);
        m_pidController2.setReference(0, ControlType.kSmartMotion);
    }

    public void toggleLegsPosition() {
        legsAreUp = !legsAreUp;
    }

    //////////////////
    // Climb Roller //
    //////////////////

    public double getEncoderPosition() {
        return m_encoder.getPosition();
    }

    public boolean legsAreLowered() {
        if (m_encoder.getPosition() - 0 <= 0.001 && m_encoder.getPosition() >= -0.001) {
            return true;
        }
        return false;
    }

}

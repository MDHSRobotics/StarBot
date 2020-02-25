
package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbLegsSparkBrain;
import frc.robot.consoles.Logger;
import frc.robot.devices.DevCANSparkMax;

import static frc.robot.subsystems.Devices.sparkMaxClimbLegsMaster;
import static frc.robot.subsystems.Devices.sparkMaxClimbLegsSlave;
import static frc.robot.RobotManager.isReal;

// ClimbLegsSpark subsystem, for extending and retracting the climb legs with spark max motors.
public class ClimbLegsSpark extends SubsystemBase {

    // State variables
    public boolean legsAreRetracted = false;

    // PID constants
    private final double kP = 0.00016; //0.07
    private final double kI = 0; //0
    private final double kD = 0.0004; //0
    private final double kIz = 0; //0
    private final double kFF = 0.000156; //0
    private final double kMaxOutput = 1.0;
    private final double kMinOutput = -1.0;

    // Private member variables
    private CANEncoder m_encoderMaster;
    private CANEncoder m_encoderSlave;
    private CANPIDController m_pidMaster;
    private CANPIDController m_pidSlave;

    public ClimbLegsSpark() {
        Logger.setup("Constructing Subsystem: ClimbLegsSpark...");

        // Configure devices
        m_encoderMaster = sparkMaxClimbLegsMaster.getEncoder();
        m_encoderSlave = sparkMaxClimbLegsSlave.getEncoder();

        m_pidMaster = sparkMaxClimbLegsMaster.getPIDController();
        m_pidSlave = sparkMaxClimbLegsSlave.getPIDController();

        if (isReal) {
            configureSpark(sparkMaxClimbLegsMaster, m_pidMaster);
            configureSpark(sparkMaxClimbLegsSlave, m_pidSlave);
        }
    }

    // Configure the given spark
    private void configureSpark(DevCANSparkMax spark, CANPIDController pidController) {
        if (!spark.isConnected) return;

        // Set PID coefficients
        pidController.setP(kP);
        pidController.setI(kI);
        pidController.setD(kD);
        pidController.setIZone(kIz);
        pidController.setFF(kFF);
        pidController.setOutputRange(kMinOutput, kMaxOutput);

        // Smart Motion
        int smartMotionSlot = 0;
        pidController.setSmartMotionMaxVelocity(1000, smartMotionSlot);
        pidController.setSmartMotionMaxAccel(500, smartMotionSlot);
        pidController.setDFilter(0.25, smartMotionSlot);
        pidController.setSmartMotionMinOutputVelocity(0, 0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Toogle the legs position
    public void toggleLegsPosition() {
        legsAreRetracted = !legsAreRetracted;
    }

    // Get the encoder position
    public double getEncoderPosition() {
        return m_encoderMaster.getPosition();
    }

    // Determine if the legs are retracted from the encoder position
    public boolean getLegsAreRetractedFromPosition() {
        double position = m_encoderMaster.getPosition();
        boolean retracted = (position <= 0.001 && position >= -0.001);
        return retracted;
    }

    // Stop the legs
    public void stop() {
        sparkMaxClimbLegsMaster.stopMotor();
        sparkMaxClimbLegsSlave.stopMotor();
    }

    // Extend the legs
    public void extendLegs() {
        double rotations = ClimbLegsSparkBrain.getRotations();

        m_encoderMaster.setPosition(0);
        m_encoderSlave.setPosition(0);
        m_pidMaster.setReference(rotations, ControlType.kSmartMotion);
        m_pidSlave.setReference(rotations, ControlType.kSmartMotion);
    }

    // Retract the legs
    public void retractLegs() {
        m_pidMaster.setReference(0, ControlType.kSmartMotion);
        m_pidSlave.setReference(0, ControlType.kSmartMotion);
    }

}

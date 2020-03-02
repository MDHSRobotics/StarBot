
package frc.robot.subsystems;

import com.revrobotics.ControlType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbLegsSparkBrain;
import frc.robot.consoles.Logger;
import frc.robot.devices.CANPIDControllable;

import static frc.robot.subsystems.Devices.encoderClimbLegsMaster;
import static frc.robot.subsystems.Devices.encoderClimbLegsSlave;
import static frc.robot.subsystems.Devices.pidClimbLegsMaster;
import static frc.robot.subsystems.Devices.pidClimbLegsSlave;
import static frc.robot.subsystems.Devices.sparkMaxClimbLegsMaster;
import static frc.robot.subsystems.Devices.sparkMaxClimbLegsSlave;

// ClimbLegsSpark subsystem, for extending and retracting the climb legs with spark max motors.
public class ClimbLegsSpark extends SubsystemBase {

    // State variables
    public boolean legsAreRetracted = false;

    // PID constants
    private final double kP = 0.00016;      // 0.07
    private final double kI = 0;            // 0
    private final double kD = 0.0004;       // 0
    private final double kIz = 0;           // 0
    private final double kFF = 0.000156;    // 0
    private final double kMaxOutput = 1.0;
    private final double kMinOutput = -1.0;

    public ClimbLegsSpark() {
        Logger.setup("Constructing Subsystem: ClimbLegsSpark...");

        // Configure devices
        configurePID(pidClimbLegsMaster);
        configurePID(pidClimbLegsSlave);
    }

    // Configure the given spark
    private void configurePID(CANPIDControllable pidController) {
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
        return encoderClimbLegsMaster.getPosition();
    }

    // Determine if the legs are retracted from the encoder position
    public boolean getLegsAreRetractedFromPosition() {
        double position = encoderClimbLegsMaster.getPosition();
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

        encoderClimbLegsMaster.setPosition(0);
        encoderClimbLegsSlave.setPosition(0);
        pidClimbLegsMaster.setReference(rotations, ControlType.kSmartMotion);
        pidClimbLegsSlave.setReference(rotations, ControlType.kSmartMotion);
    }

    // Retract the legs
    public void retractLegs() {
        pidClimbLegsMaster.setReference(0, ControlType.kSmartMotion);
        pidClimbLegsSlave.setReference(0, ControlType.kSmartMotion);
    }

}

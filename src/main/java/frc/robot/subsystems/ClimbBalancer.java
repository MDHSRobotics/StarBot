
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbBalancerBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimbBalancer;

// ClimbBalancer subsystem, for balancing the robot on the level.
public class ClimbBalancer extends SubsystemBase {

    // If any of the motor controllers are null, this should be true
    private boolean m_disabled = false;

    public ClimbBalancer() {
        Logger.setup("Constructing Subsystem: ClimbBalancer...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxClimbBalancer == null);
        if (m_disabled) {
            Logger.problem("ClimbBalancer devices not initialized! Disabling subsystem...");
            return;
        }

        if (RobotBase.isReal()) {
            // Configure the subsystem devices
            talonSrxClimbBalancer.configFactoryDefault();
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the balancer
    public void stop() {
        if (m_disabled) return;
        talonSrxClimbBalancer.stopMotor();
    }

    // Move the balancer right
    public void moveRight() {
        double power = ClimbBalancerBrain.getPower();
        if (m_disabled) return;
        talonSrxClimbBalancer.set(power);
    }

    // Move the balancer left
    public void moveLeft() {
        double power = ClimbBalancerBrain.getPower();
        if (m_disabled) return;
        talonSrxClimbBalancer.set(-power);
    }

}

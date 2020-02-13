
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbBalancerBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimbBalancer;

// ClimbBalancer subsystem, for balancing the robot on the level.
public class ClimbBalancer extends SubsystemBase {

    public ClimbBalancer() {
        Logger.setup("Constructing Subsystem: ClimbBalancer...");
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Stop the balancer
    public void stop() {
        talonSrxClimbBalancer.stopMotor();
    }

    // Move the balancer right
    public void moveRight() {
        double power = ClimbBalancerBrain.getPower();
        talonSrxClimbBalancer.set(power);
    }

    // Move the balancer left
    public void moveLeft() {
        double power = ClimbBalancerBrain.getPower();
        talonSrxClimbBalancer.set(-power);
    }

}

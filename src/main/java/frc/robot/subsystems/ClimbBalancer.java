
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ClimbBrain;
import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxClimbBalancer;

// ClimbBalancer subsystem, for balancing the robot on the level.
public class ClimbBalancer extends SubsystemBase {

    public enum BalanceDirection {
        right, left;
    }

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

    // Move the balancer right or left based on enum
    public void move(BalanceDirection balanceDirection) {
        double power = ClimbBrain.getBalancerPower();

        switch (balanceDirection) {
            case right:
                talonSrxClimbBalancer.set(power);
                break;
            case left:
                talonSrxClimbBalancer.set(-power);
                break;
        }
    }

}

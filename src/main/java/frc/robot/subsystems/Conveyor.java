
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.SubsystemDevices;
import frc.robot.Constants;
import frc.robot.oi.positions.ThumbStickPosition;
import frc.robot.oi.positions.TriggerPosition;

// Conveyor subsystem, for delivering the balls to the shoot system
public class Conveyor extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Conveyor...");

        // Determine whether or not to disable the subsystem
        m_disabled = (SubsystemDevices.talonSrxConveyor == null);
        if (m_disabled) {
            Logger.error("Conveyor devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        SubsystemDevices.talonSrxConveyor.configFactoryDefault();

        SubsystemDevices.talonSrxConveyor.configPeakCurrentDuration(Constants.TalonConstants.PEAK_AMPERAGE_DURATION,
            Constants.TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configPeakCurrentLimit(Constants.TalonConstants.PEAK_AMPERAGE,
            Constants.TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configContinuousCurrentLimit(Constants.TalonConstants.CONTINUOUS_AMPERAGE_LIMIT,
            Constants.TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSrxConveyor.configNominalOutputForward(0);
        SubsystemDevices.talonSrxConveyor.configNominalOutputReverse(0);
        SubsystemDevices.talonSrxConveyor.configPeakOutputForward(0.5);
        SubsystemDevices.talonSrxConveyor.configPeakOutputReverse(-0.5);

        SubsystemDevices.talonSrxConveyor.configMotionAcceleration(3000, Constants.TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configMotionCruiseVelocity(8000, Constants.TalonConstants.TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void convey(ThumbStickPosition thumbStickPos, TriggerPosition triggerPos) {

        if (m_disabled) return;

        double conveySpeed = -triggerPos.rightTriggerPosition - thumbStickPos.rightSideToSidePosition;
        SubsystemDevices.talonSrxConveyor.set(conveySpeed);
    }

    public void stop() {

        if (m_disabled) return;
        SubsystemDevices.talonSrxConveyor.stopMotor();
    }

}

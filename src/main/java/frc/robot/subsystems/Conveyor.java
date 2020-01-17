
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.oi.positions.ThumbstickPosition;
import frc.robot.oi.positions.TriggerPosition;
import frc.robot.Constants.TalonConstants;
import frc.robot.SubsystemDevices;

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

        SubsystemDevices.talonSrxConveyor.configPeakCurrentDuration(TalonConstants.PEAK_AMPERAGE_DURATION,
                                                                    TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configPeakCurrentLimit(TalonConstants.PEAK_AMPERAGE,
                                                                 TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configContinuousCurrentLimit(TalonConstants.CONTINUOUS_AMPERAGE_LIMIT,
                                                                    TalonConstants.TIMEOUT_MS);

        SubsystemDevices.talonSrxConveyor.configNominalOutputForward(0);
        SubsystemDevices.talonSrxConveyor.configNominalOutputReverse(0);
        SubsystemDevices.talonSrxConveyor.configPeakOutputForward(0.5);
        SubsystemDevices.talonSrxConveyor.configPeakOutputReverse(-0.5);

        SubsystemDevices.talonSrxConveyor.configMotionAcceleration(3000, TalonConstants.TIMEOUT_MS);
        SubsystemDevices.talonSrxConveyor.configMotionCruiseVelocity(8000, TalonConstants.TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    public void convey(ThumbstickPosition thumbStickPos, TriggerPosition triggerPos) {
        if (m_disabled) return;

        double conveySpeed = -triggerPos.rightTriggerPosition - thumbStickPos.rightSideToSidePosition;
        SubsystemDevices.talonSrxConveyor.set(conveySpeed);
    }

    public void stop() {
        if (m_disabled) return;
        SubsystemDevices.talonSrxConveyor.stopMotor();
    }

}

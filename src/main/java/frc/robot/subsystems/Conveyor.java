
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;
import frc.robot.Constants.TalonConstants;

// Conveyor subsystem, for delivering the balls to the shoot system
public class Conveyor extends SubsystemBase {

    // If not all the talons are initialized, this should be true
    private boolean m_disabled = false;

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Conveyor...");

        // Determine whether or not to disable the subsystem
        m_disabled = (Devices.talonSrxConveyor == null);
        if (m_disabled) {
            Logger.error("Conveyor devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        Devices.talonSrxConveyor.configFactoryDefault();

        Devices.talonSrxConveyor.configPeakCurrentDuration(TalonConstants.PEAK_AMPERAGE_DURATION,
                                                           TalonConstants.TIMEOUT_MS);
        Devices.talonSrxConveyor.configPeakCurrentLimit(TalonConstants.PEAK_AMPERAGE,
                                                        TalonConstants.TIMEOUT_MS);
        Devices.talonSrxConveyor.configContinuousCurrentLimit(TalonConstants.CONTINUOUS_AMPERAGE_LIMIT,
                                                              TalonConstants.TIMEOUT_MS);

        Devices.talonSrxConveyor.configNominalOutputForward(0);
        Devices.talonSrxConveyor.configNominalOutputReverse(0);
        Devices.talonSrxConveyor.configPeakOutputForward(0.5);
        Devices.talonSrxConveyor.configPeakOutputReverse(-0.5);

        Devices.talonSrxConveyor.configMotionAcceleration(3000, TalonConstants.TIMEOUT_MS);
        Devices.talonSrxConveyor.configMotionCruiseVelocity(8000, TalonConstants.TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Moves the conveyor forward and back depending on the trigger and the right thumbstick
    public void convey(double speed) {
        if (m_disabled) return;
        Devices.talonSrxConveyor.set(speed);
    }

    // Stop the conveyor motor
    public void stop() {
        if (m_disabled) return;
        Devices.talonSrxConveyor.stopMotor();
    }

}


package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.consoles.Logger;

import static frc.robot.subsystems.Devices.talonSrxConveyor;
import static frc.robot.subsystems.constants.TalonConstants.*;

// Conveyor subsystem, for delivering the balls to the shoot system
public class Conveyor extends SubsystemBase {

    // If any of the devices are null, this should be true
    private boolean m_disabled = false;

    public Conveyor() {
        Logger.setup("Constructing Subsystem: Conveyor...");

        // Determine whether or not to disable the subsystem
        m_disabled = (talonSrxConveyor == null);
        if (m_disabled) {
            Logger.error("Conveyor devices not initialized! Disabling subsystem...");
            return;
        }

        // Configure the subsystem devices
        talonSrxConveyor.configFactoryDefault();

        talonSrxConveyor.configPeakCurrentDuration(PEAK_AMPERAGE_DURATION, TIMEOUT_MS);
        talonSrxConveyor.configPeakCurrentLimit(PEAK_AMPERAGE, TIMEOUT_MS);
        talonSrxConveyor.configContinuousCurrentLimit(CONTINUOUS_AMPERAGE_LIMIT, TIMEOUT_MS);

        talonSrxConveyor.configNominalOutputForward(0);
        talonSrxConveyor.configNominalOutputReverse(0);
        talonSrxConveyor.configPeakOutputForward(0.5);
        talonSrxConveyor.configPeakOutputReverse(-0.5);

        talonSrxConveyor.configMotionAcceleration(3000, TIMEOUT_MS);
        talonSrxConveyor.configMotionCruiseVelocity(8000, TIMEOUT_MS);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    // Moves the conveyor forward and back depending on the trigger and the right thumbstick
    public void convey(double speed) {
        if (m_disabled) return;
        talonSrxConveyor.set(speed);
    }

    // Stop the conveyor motor
    public void stop() {
        if (m_disabled) return;
        talonSrxConveyor.stopMotor();
    }

}

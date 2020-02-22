
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.brains.ShooterBrain;
import frc.robot.consoles.Logger;
import frc.robot.devices.DevTalonSRX;
import frc.robot.subsystems.utils.EncoderUtils;
import frc.robot.subsystems.utils.PIDValues;
import frc.robot.subsystems.utils.TalonUtils;
import frc.robot.BotSubsystems;

import static frc.robot.subsystems.constants.EncoderConstants.*;
import static frc.robot.subsystems.Devices.talonSrxShooterBottomWheel;
import static frc.robot.subsystems.Devices.talonSrxShooterTopWheel;
import static frc.robot.RobotManager.isReal;

// Shooter subsystem, for shooting balls with two flywheels.
public class Shooter extends SubsystemBase {

    // Mechanical constants
    private final double GEAR_RATIO = 1.0;
    private final double WHEEL_DIAMETER = 4.0;

    // Encoder constants
    private static final boolean SENSOR_PHASE_BOTTOM = true;
    private static final boolean MOTOR_INVERT_BOTTOM = false;

    private static final boolean SENSOR_PHASE_TOP = true;
    private static final boolean MOTOR_INVERT_TOP = false;

    // Shuffleboard
    private double topVelocity = ShooterBrain.shootTopWheelCurrentVelocityDefault;
    private double bottomVelocity = ShooterBrain.shootBottomWheelCurrentVelocityDefault;

    private double bottomVelocityFPS = ShooterBrain.shootBottomWheelCurrentVelocityFPSDefault;
    private double topVelocityFPS = ShooterBrain.shootTopWheelCurrentVelocityFPSDefault;

    private double minTopVelocity = ShooterBrain.shootTopWheelMinVelocityDefault;
    private double maxTopVelocity = ShooterBrain.shootTopWheelMaxVelocityDefault;

    private double minBottomVelocity = ShooterBrain.shootBottomWheelMinVelocityDefault;
    private double maxBottomVelocity = ShooterBrain.shootBottomWheelMaxVelocityDefault;

    public Shooter() {
        Logger.setup("Constructing Subsystem: Shooter...");

        if (isReal) {
            // Configure devices
            PIDValues pidBottom = new PIDValues(0.1, 0, 0, 0);
            TalonUtils.configureTalonWithEncoder(talonSrxShooterBottomWheel, SENSOR_PHASE_BOTTOM, MOTOR_INVERT_BOTTOM, pidBottom);

            PIDValues pidTop = new PIDValues(0.1, 0, 0, 0);
            TalonUtils.configureTalonWithEncoder(talonSrxShooterTopWheel, SENSOR_PHASE_TOP, MOTOR_INVERT_TOP, pidTop);
        }
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
        topVelocity = BotSubsystems.shooter.getTopWheelVelocity();
        bottomVelocity = BotSubsystems.shooter.getBottomWheelVelocity();

        topVelocityFPS = EncoderUtils.translateTicksPerDecisecondToFPS(topVelocity, WHEEL_DIAMETER, GEAR_RATIO);
        bottomVelocityFPS = EncoderUtils.translateTicksPerDecisecondToFPS(bottomVelocity, WHEEL_DIAMETER, GEAR_RATIO);

        ShooterBrain.setTopWheelCurrentVelocity(topVelocity);
        ShooterBrain.setBottomWheelCurrentVelocity(bottomVelocity);

        ShooterBrain.setTopWheelCurrentVelocityFPS(topVelocityFPS);
        ShooterBrain.setBottomWheelCurrentVelocityFPS(bottomVelocityFPS);

        if (topVelocity < minTopVelocity) minTopVelocity = topVelocity;
        if (topVelocity > maxTopVelocity) maxTopVelocity = topVelocity;
        if (bottomVelocity < minBottomVelocity) minBottomVelocity = bottomVelocity;
        if (bottomVelocity > maxBottomVelocity) maxBottomVelocity = bottomVelocity;

        ShooterBrain.setBottomWheelMinVelocity(minBottomVelocity);
        ShooterBrain.setBottomWheelMaxVelocity(maxBottomVelocity);
        ShooterBrain.setTopWheelMinVelocity(minTopVelocity);
        ShooterBrain.setTopWheelMaxVelocity(maxTopVelocity);
    }

    // Stop the shooter
    public void stop() {
        talonSrxShooterBottomWheel.stopMotor();
        talonSrxShooterTopWheel.stopMotor();
    }

    private void spinWheel(DevTalonSRX talon, double velocity) {
        double nativeVelocity = EncoderUtils.translateFPSToTicksPerDecisecond(velocity, WHEEL_DIAMETER, GEAR_RATIO);
        Logger.info("Shooter -> FlyWheel Velocity:" + velocity + " FPS");
        Logger.info("Shooter -> FlyWheel Native Velocity:" + nativeVelocity + " TPDS");

        Logger.action("Shooter -> Setting " + talon.getName() + " velocity...");
        talon.set(ControlMode.Velocity, nativeVelocity);
    }

    // Spin the bottom shooter wheel
    public void spinBottomWheel() {
        double velocity = ShooterBrain.getBottomWheelVelocity();
        spinWheel(talonSrxShooterBottomWheel, velocity);
    }

    // Spin the top Shooter wheel
    public void spinTopWheel() {
        double velocity = ShooterBrain.getTopWheelVelocity();
        spinWheel(talonSrxShooterTopWheel, velocity);
    }

    // Spin the top Shooter wheel master and follower
    public void spinTopWheelMasterFollower() {
        double velocity = ShooterBrain.getTopWheelVelocity();
        double nativeVelocity = EncoderUtils.translateFPSToTicksPerDecisecond(velocity, WHEEL_DIAMETER, GEAR_RATIO);
        double heading = talonSrxShooterBottomWheel.getSelectedSensorPosition(PID_SLOT_1);
        Logger.info("Shooter -> FlyWheel Velocity:" + velocity + " FPS");
        Logger.info("Shooter -> FlyWheel Native Velocity:" + nativeVelocity + " TPDS");

        Logger.action("Shooter -> Setting top wheel velocity...");
        talonSrxShooterTopWheel.set(ControlMode.Velocity, nativeVelocity, DemandType.AuxPID, heading);
    }

    //---------//
    // Getters //
    //---------//

    // Get the current Shooter BottomWheel motor velocity
    public int getBottomWheelVelocity() {
        int velocity = talonSrxShooterBottomWheel.getSelectedSensorVelocity();
        return velocity;
    }

    // Get the current Shooter BottomWheel motor velocity in feet per second
    public double getBottomWheelVelocityFPS() {
        double tpds = getBottomWheelVelocity();
        double fps = EncoderUtils.translateTicksPerDecisecondToFPS(tpds, WHEEL_DIAMETER, GEAR_RATIO);
        return fps;
    }

    // Get the current Shooter TopWheel motor velocity
    public int getTopWheelVelocity() {
        int velocity = talonSrxShooterTopWheel.getSelectedSensorVelocity();
        return velocity;
    }

    // Get the current Shooter TopWheel motor velocity in feet per second
    public double getTopWheelVelocityFPS() {
        double tpds = getTopWheelVelocity();
        double fps = EncoderUtils.translateTicksPerDecisecondToFPS(tpds, WHEEL_DIAMETER, GEAR_RATIO);
        return fps;
    }

    //--------------//
    // Shuffleboard //
    //--------------//

    // Resets the min/max velocity capture variables to their default values
    public void reset(){
        minTopVelocity = ShooterBrain.shootTopWheelMinVelocityDefault;
        maxTopVelocity = ShooterBrain.shootTopWheelMaxVelocityDefault;

        minBottomVelocity = ShooterBrain.shootBottomWheelMinVelocityDefault;
        maxBottomVelocity = ShooterBrain.shootBottomWheelMaxVelocityDefault;
    }

    //---------//
    // Testing //
    //---------//

    public void testMotor() {
        talonSrxShooterBottomWheel.set(0.3);
        talonSrxShooterTopWheel.set(0.3);
    }

}

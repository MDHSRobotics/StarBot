
package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class EncoderConstants {
        // Which PID slot to pull gains from.
        // Starting 2018, you can choose from 0, 1, 2 or 3.
        // Only the first two (0,1) are visible in web-based configuration.
        public static final int PID_SLOT_0 = 0;

        // Talon SRX/ Victor SPX will supported multiple (cascaded) PID loops.
        // For now we just want the primary one.
        public static final int PID_LOOP_PRIMARY = 0;

        // The amount of native ticks per revolution (Tpr) in the Redline Encoder.
        public static final int ENCODER_TPR = 4096;
    }

    public static final class TalonConstants {
        // Number of miliseconds that the talon can stay at peak current.
        public static final int PEAK_AMPERAGE_DURATION = 40;

        // Max amps that the talon can supply at peak.
        public static final int PEAK_AMPERAGE = 11;

        // Max amps that the talon can supply continuously.
        public static final int CONTINUOUS_AMPERAGE_LIMIT = 10;

        // Minimum speed the talon can move forwards.
        public static final int NOMINAL_OUTPUT_FORWARD = 0;

        // Minimum speed the talon can move backwards.
        public static final int NOMINAL_OUTPUT_REVERSE = 0;

        // Set to zero to skip waiting for confirmation,
        // set to nonzero to wait and report to DS if action fails.
        public static final int TIMEOUT_MS = 20;
    }

}

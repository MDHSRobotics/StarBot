
package frc.robot;

import java.util.ArrayList;

import frc.robot.tests.driving.*;
import frc.robot.tests.lighting.*;
import frc.robot.tests.roller.*;
import frc.robot.tests.rollerarm.*;

import frc.robot.tests.TestRunnable;

// This class supplies the list of tests to run in Test mode on the robot.
public class TestSupplier {

    private static ArrayList<TestRunnable> m_testList = new ArrayList<TestRunnable>();

    // Add all the robot tests here.
    static {
        // Lighting
        addTest(new CycleLightsTest());

        // Driving
        addTest(new AlignDiffDriveToGyroTest());
        addTest(new DriveDiffTankTest());
        addTest(new CenterDiffDriveOnTargetTest());

        // Roller
        addTest(new SpinRollerTest());
        addTest(new StopRollerTest());

        // RollerArm
        addTest(new LowerRollerArmTest());
    }

    // Adds the given test to the list
    public static void addTest(TestRunnable test) {
        m_testList.add(test);
    }

    // Gets the test for the given number
    public static TestRunnable getTest(int testNumber) {
        TestRunnable test = m_testList.get(testNumber-1);
        return test;
    }

    // Gets the number of tests
    public static int getNumberOfTests() {
        int numberOfTests = m_testList.size();
        return numberOfTests;
    }

}

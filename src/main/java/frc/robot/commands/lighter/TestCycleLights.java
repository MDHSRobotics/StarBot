
package frc.robot.commands.lighter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Lighter;

// This command tests the Lighter by cycling through all its states
public class TestCycleLights extends CommandBase {

    private Lighter m_lighter;

    // TODO: Make these constructor parameters. Use overloading for these default values.
    private static final int NUM_CYCLES = 3;
    private static final int NUM_SECONDS_PER_LIGHT = 1;

    private int m_cycleNum = 1;
    private int m_lightSequence = 0;
    private Timer m_timer = new Timer();

    public TestCycleLights(Lighter lighter) {
        Logger.setup("Constructing Command: TestCycleLights...");

        // Add given subsystem requirements
        m_lighter = lighter;
        addRequirements(m_lighter);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: TestCycleLights...");

        m_timer.reset();
        m_timer.start();

        // Start off with lights off
        m_lighter.turnOffBoth();
        Logger.action("TestCycleLights -> Turning off both lights; Cycle #" + m_cycleNum);
    }

    @Override
    public void execute() {
        double currentTime = m_timer.get();
        if (currentTime > NUM_SECONDS_PER_LIGHT) {
            ++m_lightSequence;
            switch (m_lightSequence) {
            case 1:
                m_lighter.turnOnWhiteOnly();
                Logger.action("TestCycleLights -> Turning on white light; Cycle #" + m_cycleNum);
                break;
            case 2:
                m_lighter.turnOnRedOnly();
                Logger.action("TestCycleLights -> Turning on red light; Cycle #" + m_cycleNum);
                break;
            case 3:
                m_lighter.turnOnBoth();
                Logger.action("TestCycleLights -> Turning on both lights; Cycle #" + m_cycleNum);
                break;
            default:
                ++m_cycleNum;
                m_lightSequence = 0;
                if (m_cycleNum <= NUM_CYCLES) {
                    // If we're not done with all cycles, start a new cycle with both lights off
                    m_lighter.turnOffBoth();
                    Logger.action("TestCycleLights -> Turning off both lights; Cycle #" + m_cycleNum);
                }
            }
            m_timer.reset();
            m_timer.start();
        }
    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        return m_cycleNum > NUM_CYCLES;
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            System.out.println("--");
            Logger.ending("Interrupting Command: TestCycleLights...");
        } else {
            Logger.ending("Ending Command: TestCycleLights...");
        }

        Logger.action("TestCycleLights -> Turning off both lights; Cycle #" + m_cycleNum);
        m_lighter.turnOffBoth();
    }

}

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.Autonomous; 

public class AutoPeriod extends CommandBase {

    private Autonomous m_autonomous;

    public AutoPeriod(Autonomous autonomous) {
        Logger.setup("Constructing Command: AutoPeriod...");

        // Add given subsystem requirements
        m_autonomous = autonomous;
        addRequirements(m_autonomous);
    }

    @Override
    public void initialize() {
        Logger.action("Initializing Command: AutoPeriod...");
    }

    @Override
    public void execute() {
        
    }

    // This command continues until it cycles through the set number of cycles
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        
    }

}

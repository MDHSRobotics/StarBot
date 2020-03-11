
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.BotCommands;
import frc.robot.BotSubsystems;
import frc.robot.commands.conveyor.SpinConveyorCG;
import frc.robot.commands.conveyor.StopConveyorCG;
import frc.robot.commands.shooter.ShootCG;
import frc.robot.commands.shooter.StopShooterCG;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Conveyor.ConveyorDirection;

public class AutoLineUpAndShootS2 extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Shooter m_shooter;

    public AutoLineUpAndShootS2(Conveyor conveyor, Shooter shooter, DiffDriver diffDriver) {
        Logger.setup("Constructing SequentialCommandGroup: AutoLineUpAndShootS2...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        InstantCommand printScenarioName = new InstantCommand(() -> Logger.info("Starting Auto Scenario #2"));
        // TODO The wait duration should be in Shuffleboard
        WaitCommand initialWait = new WaitCommand(2.);
        SpinConveyorCG spinConveyorBackward = new SpinConveyorCG(BotSubsystems.conveyor, ConveyorDirection.backward);
        ShootCG shoot = new ShootCG(BotSubsystems.shooter);
        StopConveyorCG stopConveyor = new StopConveyorCG(BotSubsystems.conveyor);
        StopShooterCG stopShooter = new StopShooterCG(BotSubsystems.shooter);
        AutoAlign autoAlign = new AutoAlign(BotSubsystems.diffDriver);
        AutoDriveForward autoDriveForward = new AutoDriveForward(BotSubsystems.diffDriver);

        Command cmdSequence[] = {   printScenarioName,
                                    initialWait,
                                    spinConveyorBackward,
                                    shoot.withTimeout(2),
                                    stopConveyor,
                                    stopShooter,
                                    autoAlign,
                                    autoDriveForward
        };

        for (int i = 0; i < cmdSequence.length; i++) {
            int stepNumber = i + 1;
            Command cmd = cmdSequence[i];
            String className = cmd.getClass().getName();
            String cmdName = className.substring(className.lastIndexOf('.') + 1);
            String stepName = String.format("============== STEP #%d - %s ===============", stepNumber, cmdName);
            addCommands(cmd.beforeStarting(() -> Logger.info(stepName)));
        }
    }
}

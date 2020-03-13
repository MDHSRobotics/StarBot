
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.BotSubsystems;
import frc.robot.commands.conveyor.SpinConveyor;
import frc.robot.commands.conveyor.StopConveyor;
import frc.robot.commands.diffdriver.AlignToAngle;
import frc.robot.commands.diffdriver.AlignToTarget;
import frc.robot.commands.shooter.ReverseConveyorAndShoot;
import frc.robot.commands.shooter.Shoot;
import frc.robot.commands.shooter.StopShooter;
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
        AlignToTarget alignToTarget = new AlignToTarget(BotSubsystems.diffDriver);
        ReverseConveyorAndShoot shoot = new ReverseConveyorAndShoot(BotSubsystems.conveyor, BotSubsystems.shooter);
        StopConveyor stopConveyor = new StopConveyor(BotSubsystems.conveyor);
        StopShooter stopShooter = new StopShooter(BotSubsystems.shooter);
        AlignToAngle alignToAngle = new AlignToAngle(BotSubsystems.diffDriver, 0);
        AutoDriveForward autoDriveForward = new AutoDriveForward(BotSubsystems.diffDriver);

        Command cmdSequence[] = {   printScenarioName,
                                    initialWait,
                                    alignToTarget,
                                    shoot.withTimeout(2),
                                    stopConveyor.withTimeout(0.1),
                                    stopShooter.withTimeout(0.1),
                                    alignToAngle,
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

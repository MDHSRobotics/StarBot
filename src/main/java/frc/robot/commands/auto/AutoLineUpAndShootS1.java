
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.BotCommands;
import frc.robot.BotSubsystems;
import frc.robot.commands.conveyor.ReverseConveyorCG;
import frc.robot.commands.conveyor.StopConveyorCG;
import frc.robot.commands.roller.StopRollerCG;
import frc.robot.commands.shooter.ShootCG;
import frc.robot.commands.shooter.StopShooterCG;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Shooter;

public class AutoLineUpAndShootS1 extends SequentialCommandGroup {

    private Conveyor m_conveyor;
    private DiffDriver m_diffDriver;
    private Shooter m_shooter;

    public AutoLineUpAndShootS1(Conveyor conveyor, Shooter shooter, DiffDriver diffDriver) {
        Logger.setup("Constructing SequentialCommandGroup: AutoLineUpAndShootS1...");

        // Add given subsystem requirements
        m_conveyor = conveyor;
        addRequirements(m_conveyor);

        m_shooter = shooter;
        addRequirements(m_shooter);

        m_diffDriver = diffDriver;
        addRequirements(m_diffDriver);

        InstantCommand printScenarioName = new InstantCommand(() -> Logger.info("Starting Auto Scenario #1") );
        // TODO The wait duration should be in Shuffleboard
        WaitCommand initialWait = new WaitCommand(2.);
        ShootCG firstShoot = new ShootCG(BotSubsystems.shooter);
        StopShooterCG firstStopShooter = new StopShooterCG(BotSubsystems.shooter);
        StopConveyorCG firstStopConveyor = new StopConveyorCG(BotSubsystems.conveyor);
        AutoAlign firstAutoAlign = new AutoAlign(BotSubsystems.diffDriver);
        AutoDriveAndPickUp autoDriveAndPickUp = new AutoDriveAndPickUp(BotSubsystems.conveyor,
                                                    BotSubsystems.diffDriver, BotSubsystems.roller);
        StopConveyorCG stopConveyorwithRoller = new StopConveyorCG(BotSubsystems.conveyor);
        StopRollerCG stopRoller = new StopRollerCG(BotSubsystems.roller);
        AutoDriveFromPickUp autoDriveFromPickUp = new AutoDriveFromPickUp(BotSubsystems.diffDriver);
        AutoDriveToShoot autoDriveToShoot = new AutoDriveToShoot(BotSubsystems.diffDriver);
        AutoAlign secondAutoAlign = new AutoAlign(BotSubsystems.diffDriver);
        ReverseConveyorCG secondReverseConveyor = new ReverseConveyorCG(BotSubsystems.conveyor);
        ShootCG secondShoot = new ShootCG(BotSubsystems.shooter);
        StopConveyorCG secondStopConveyor = new StopConveyorCG(BotSubsystems.conveyor);
        StopShooterCG secondStopShooter = new StopShooterCG(BotSubsystems.shooter);
        AutoDriveForward autoDriveForward = new AutoDriveForward(BotSubsystems.diffDriver);;

        Command cmdSequence[] = {   printScenarioName,
                                    initialWait,
                                    firstShoot.withTimeout(2),
                                    firstStopConveyor,
                                    firstStopShooter,
                                    firstAutoAlign,
                                    autoDriveAndPickUp,
                                    stopConveyorwithRoller,
                                    stopRoller,
                                    autoDriveFromPickUp,
                                    autoDriveToShoot,
                                    secondAutoAlign,
                                    secondReverseConveyor,
                                    secondShoot.withTimeout(2),
                                    secondStopConveyor,
                                    secondStopShooter,
                                    autoDriveForward
        };

        for (int i=0; i < cmdSequence.length; i++) {
            int stepNumber = i+1;
            Command cmd = cmdSequence[i];
            String className = cmd.getClass().getName();
            String cmdName = className.substring(className.lastIndexOf('.')+1);
            String stepName = String.format("============== STEP #%d - %s ===============", stepNumber, cmdName);
            addCommands(cmd.beforeStarting(() -> Logger.info(stepName)));
        }
    }
}

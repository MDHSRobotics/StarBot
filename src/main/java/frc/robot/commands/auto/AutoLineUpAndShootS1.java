
package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.BotCommands;
import frc.robot.BotSubsystems;
import frc.robot.commands.conveyor.SpinConveyor;
import frc.robot.commands.conveyor.StopConveyor;
import frc.robot.commands.roller.StopRoller;
import frc.robot.commands.shooter.ShootCG;
import frc.robot.commands.shooter.StopShooterCG;
import frc.robot.consoles.Logger;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.DiffDriver;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Conveyor.ConveyorDirection;

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
        StopConveyor firstStopConveyor = new StopConveyor(BotSubsystems.conveyor);
        AutoAlign firstAutoAlign = new AutoAlign(BotSubsystems.diffDriver);
        AutoDriveAndPickUp autoDriveAndPickUp = new AutoDriveAndPickUp(BotSubsystems.conveyor,
                                                    BotSubsystems.diffDriver, BotSubsystems.roller);
        StopConveyor stopConveyorwithRoller = new StopConveyor(BotSubsystems.conveyor);
        StopRoller stopRoller = new StopRoller(BotSubsystems.roller);
        AutoDriveFromPickUp autoDriveFromPickUp = new AutoDriveFromPickUp(BotSubsystems.diffDriver);
        AutoDriveToShoot autoDriveToShoot = new AutoDriveToShoot(BotSubsystems.diffDriver);
        AutoAlign secondAutoAlign = new AutoAlign(BotSubsystems.diffDriver);
        SpinConveyor secondSpinConveyorBackward = new SpinConveyor(BotSubsystems.conveyor, ConveyorDirection.backward);
        ShootCG secondShoot = new ShootCG(BotSubsystems.shooter);
        StopConveyor secondStopConveyor = new StopConveyor(BotSubsystems.conveyor);
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
                                    secondSpinConveyorBackward,
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

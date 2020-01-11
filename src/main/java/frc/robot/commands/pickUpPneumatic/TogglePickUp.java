
package frc.robot.commands.pickUpPneumatic;

import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.consoles.Logger;
import frc.robot.subsystems.PickUpPneumatic;
import frc.robot.BotCommands;

// Toggles the position of the Hatcher Claw
public class TogglePickUp extends InstantCommand {

    private PickUpPneumatic m_pickUp;

    public TogglePickUp(PickUpPneumatic pickUpPneumatic) {
        super();
        Logger.setup("Constructing InstantCommand: TogglePickUp...");

        m_pickUp = pickUpPneumatic;
    }

    @Override
    public void initialize() {
        System.out.println("--");
        Logger.action("Initializing InstantCommand: TogglePickUp...");

        if (m_pickUp.pickUpIsUp) {
            Logger.action("PickUp -> Moving to Up...");
            BotCommands.retractPickUpPneumatic.schedule();
        } else {
            Logger.action("Hatcher -> Moving to CLOSED...");
            BotCommands.lowerPickUpPneumatic.schedule();
        }
        m_pickUp.togglePickUpPosition();
    }

}

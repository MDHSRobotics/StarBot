package frc.robot.subsystems;

import frc.robot.consoles.Logger;

class SimulationMonitor {

    private String m_physicalDeviceID;
    private String m_logicalDeviceID;

    private String m_lastPrintedCmd = "";
    private int m_nSkippedDuplicateCmds = 0;

    SimulationMonitor(String physicalDeviceID, String logicalDeviceID) {

        m_physicalDeviceID = physicalDeviceID;
        m_logicalDeviceID = logicalDeviceID;
    }

    public void logCommand(String cmdString) {

        if (!cmdString.equals(m_lastPrintedCmd)) {

            // Print number of duplicate commands that were not printed
            if (m_nSkippedDuplicateCmds > 0) {
                String skipString = String.format("SIM %s (%s): %s (Skipped %d of these)", m_logicalDeviceID,
                                                  m_physicalDeviceID, m_lastPrintedCmd, m_nSkippedDuplicateCmds);
                Logger.action(skipString);
                m_nSkippedDuplicateCmds = 0;
            }
            String msgString = String.format("SIM %s (%s): %s", m_logicalDeviceID, m_physicalDeviceID, cmdString);
            Logger.action(msgString);

            m_lastPrintedCmd = cmdString;
        } else {
            ++m_nSkippedDuplicateCmds;
        }
    }

}
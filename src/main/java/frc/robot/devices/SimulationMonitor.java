
package frc.robot.devices;

import frc.robot.consoles.Logger;

class SimulationMonitor {

    private String m_physicalID;
    private String m_logicalID;

    private String m_lastPrinted = "";
    private int m_nSkippedDuplicates = 0;

    SimulationMonitor(String physicalDeviceID, String logicalDeviceID) {
        m_physicalID = physicalDeviceID;
        m_logicalID = logicalDeviceID;
    }

    public void log(String methodName, String... args) {
        String methodSignature = getMethodSignature(methodName, args);
        if (!methodSignature.equals(m_lastPrinted)) {
            // Print number of duplicate method signatures that were not printed
            if (m_nSkippedDuplicates > 0) {
                String skip = String.format("SIM %s (%s): %s (Skipped %d of these)", m_logicalID,
                                                                                     m_physicalID,
                                                                                     m_lastPrinted,
                                                                                     m_nSkippedDuplicates);
                Logger.action(skip);
                m_nSkippedDuplicates = 0;
            }
            String msg = String.format("SIM %s (%s): %s", m_logicalID, m_physicalID, methodSignature);
            Logger.action(msg);

            m_lastPrinted = methodSignature;
        } else {
            ++m_nSkippedDuplicates;
        }
    }

    private String getMethodSignature(String methodName, String... args) {
        String argStr = "";
        for (String arg : args) {
            if (argStr == "") {
                argStr = arg;
                continue;
            }
            argStr = String.format("%s, %s", argStr, arg);
        }
        return String.format("%s(%s)", methodName, argStr);
    }

}

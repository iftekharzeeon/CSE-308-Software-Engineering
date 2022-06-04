package problem_1.communicationsystem;

public class CommunicationSystemFactory {
    public static CommunicationSystem getCommunicationSystem(String communicationType) {
        if (communicationType == null) {
            return null;
        }
        if (communicationType.split("#")[0].equalsIgnoreCase("wifi")) {
            return new WiFi();
        }
        if (communicationType.split("#")[0].equalsIgnoreCase("mobile")) {
            return SIMFactory.getSim(communicationType.split("#")[1]);
        }
        return null;
    }
}

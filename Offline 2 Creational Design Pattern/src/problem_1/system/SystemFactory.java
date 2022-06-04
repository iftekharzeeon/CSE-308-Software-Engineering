package problem_1.system;

public class SystemFactory {
    public static QueueManagementSystem getSystem(String systemName) {
        if (systemName == null) {
            return null;
        }
        if (systemName.equalsIgnoreCase("deluxe")) {
            return new Deluxe();
        }
        if (systemName.equalsIgnoreCase("optimal")) {
            return new Optimal();
        }
        if (systemName.equalsIgnoreCase("poor")) {
            return new Poor();
        }
        return null;
    }
}

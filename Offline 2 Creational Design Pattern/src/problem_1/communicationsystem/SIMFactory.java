package problem_1.communicationsystem;

public class SIMFactory {
    public static MobileNetwork getSim(String simName) {
        if (simName == null) {
            return null;
        }
        if (simName.equalsIgnoreCase("grameenphone")) {
            return new GrameenPhone();
        }
        if (simName.equalsIgnoreCase("banglalink")) {
            return new Banglalink();
        }
        if (simName.equalsIgnoreCase("robi")) {
            return new Robi();
        }
        if (simName.equalsIgnoreCase("teletalk")) {
            return new Teletalk();
        }
        return null;
    }
}

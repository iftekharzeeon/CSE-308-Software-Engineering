package problem_1.display;

public class DisplayFactory {
    public static Display getDisplay(String displayType) {
        if (displayType == null) {
            return null;
        }
        if (displayType.equalsIgnoreCase("led")) {
            return new LED();
        }
        if (displayType.equalsIgnoreCase("lcd")) {
            return new LCD();
        }
        return null;
    }
}

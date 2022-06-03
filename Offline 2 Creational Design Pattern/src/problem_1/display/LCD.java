package problem_1.display;


public class LCD extends Display {
    @Override
    protected String name() {
        return "LCD Panel";
    }

    @Override
    protected double price() {
        return 4000;
    }
}

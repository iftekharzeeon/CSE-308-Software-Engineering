package problem_1.display;


public class LED extends Display {
    @Override
    protected String name() {
        return "LED Matrix";
    }

    @Override
    protected double price() {
        return 2500;
    }
}

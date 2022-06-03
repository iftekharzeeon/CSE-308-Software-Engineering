package problem_1.processor;

public class RaspberryPi extends Processor {

    @Override
    protected String name() {
        return "Raspberry Pi";
    }

    @Override
    protected double price() {
        return 8000;
    }
}

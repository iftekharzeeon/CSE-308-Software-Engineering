package problem_1.processor;

public class RaspberryPi extends Processor {

    @Override
    public String name() {
        return "Raspberry Pi";
    }

    @Override
    public double price() {
        return 8000;
    }
}

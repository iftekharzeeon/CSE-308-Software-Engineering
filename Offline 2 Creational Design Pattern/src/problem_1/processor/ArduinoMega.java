package problem_1.processor;


public class ArduinoMega extends Processor {
    @Override
    public String name() {
        return "Arduino Mega";
    }

    @Override
    protected double price() {
        return 5000;
    }
}

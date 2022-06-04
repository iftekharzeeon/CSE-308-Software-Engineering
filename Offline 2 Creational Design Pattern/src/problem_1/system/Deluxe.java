package problem_1.system;

import problem_1.display.Display;
import problem_1.display.DisplayFactory;
import problem_1.processor.Processor;
import problem_1.processor.ProcessorFactory;

public class Deluxe extends QueueManagementSystem {

    public Deluxe() {
        Processor processor = ProcessorFactory.getProcessor("raspberrypi");
        Display display = DisplayFactory.getDisplay("lcd");

        addComponent(processor);
        addComponent(display);
    }

    @Override
    public String toString() {
        return "Deluxe";
    }
}

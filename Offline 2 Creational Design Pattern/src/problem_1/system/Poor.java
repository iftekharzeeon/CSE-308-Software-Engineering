package problem_1.system;

import problem_1.display.Display;
import problem_1.display.DisplayFactory;
import problem_1.processor.Processor;
import problem_1.processor.ProcessorFactory;

public class Poor extends QueueManagementSystem {
    public Poor() {
        Processor processor = ProcessorFactory.getProcessor("atmega32");
        Display display = DisplayFactory.getDisplay("led");

        addComponent(processor);
        addComponent(display);
    }

    @Override
    public String toString() {
        return "Poor";
    }
}

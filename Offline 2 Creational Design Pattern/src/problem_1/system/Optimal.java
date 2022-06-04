package problem_1.system;

import problem_1.display.Display;
import problem_1.display.DisplayFactory;
import problem_1.processor.Processor;
import problem_1.processor.ProcessorFactory;

public class Optimal extends QueueManagementSystem {

    public Optimal() {
        Processor processor = ProcessorFactory.getProcessor("arduinomega");
        Display display = DisplayFactory.getDisplay("led");

        addComponent(processor);
        addComponent(display);
    }

    @Override
    public String toString() {
        return "Optimal";
    }
}

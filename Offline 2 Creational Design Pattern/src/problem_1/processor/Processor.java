package problem_1.processor;

import problem_1.components.Component;

public abstract class Processor implements Component {
    @Override
    public abstract String name();
    @Override
    public abstract double price();
}

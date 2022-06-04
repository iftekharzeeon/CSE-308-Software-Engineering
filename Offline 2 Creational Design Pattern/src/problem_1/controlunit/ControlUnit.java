package problem_1.controlunit;

import problem_1.Component;

public class ControlUnit implements Component {

    private String systemName;

    public ControlUnit(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String name() {
        return systemName + " Control Unit";
    }

    @Override
    public double price() {
        return 5000;
    }
}
